package ru.icc.td.tabbyxl.preprocessing.headrecog;

import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.style.BorderType;
import ru.icc.td.tabbyxl.model.style.CBorder;
import ru.icc.td.tabbyxl.model.style.HorzAlignment;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;


public class HeadRecogAlgorithms {
    CTable table;
    int hB = 0, hR = 0;
    boolean isDebug;
    CellPointer cellShift;
    WorkbookManager workbookManager;

    private int tmpC = 0;

    public HeadRecogAlgorithms(CTable inputTable, int[] shift, Workbook workbook, String sheetName, String pathToSave, boolean isDebug) {
        table = inputTable;
        cellShift = new CellPointer(shift);
        hR = table.numOfCols();
        this.isDebug = isDebug;

        if (isDebug)
            workbookManager = new WorkbookManager(workbook, sheetName);

        //First cell determine the border of the header
        CCell cell = getCellByCoord(1, 1);

        hB = getBottomBorder(cell);
        if (isDebug) {
            System.out.println(String.format("%s sheet is processing", sheetName));
            System.out.printf("Head bottom = %d\n", hB);
            System.out.printf("Head right = %d\n", hR);
            System.out.printf("Value '%s'\n", getCellByCoord(1, 1).getText());
        }
    }

    public void analyzeHead() {
        //CellCoordNode cellCoordNode;
        CCell cCell, tmpCell;
        Block headBlock;
        Block block;

        int curCellLeft = 1;
        do {
            //Get top level block borders
            cCell = getCellByCoord(curCellLeft, 1);
            System.out.println(cCell.getStyle().getFgColor());
            if (cCell == null)
                break;
            cCell = expCell(cCell, hR, hB);
            if (!isLabel(cCell)) {
                //Get lower cell size
                headBlock = new Block(cCell);
                if ((!isLabel(cCell)) && (cCell.getStyle().getLeftBorder().getType() != BorderType.NONE) && (cCell.getCr() < hR)) {

                    tmpCell = getCellByCoord(cCell.getCr() + 1, cCell.getRt());
                    if ((tmpCell != null)) {
                        cCell = expByHeight(cCell, tmpCell.getRb());
                        if (cCell.getRb() == tmpCell.getRb()) {
                            headBlock.setRight(tmpCell.getCr());
                            headBlock.setBottom(cCell.getRb());
                        }
                    }
                }
                cCell = cellTransofrm(cCell, headBlock);
            } else {
                block = null;
                cCell = expByHeight(cCell); //cCell Check the necessity of this operation
                if (!isRightBorder(cCell)) {
                    CCell rc = getRightCell(cCell);
                    block = checkForExtension(rc, cCell.getRb(), hR, isLabel(cCell), cCell.getStyle().getBottomBorder());
                    if (block != null) {
                        cCell = cellTransofrm(cCell, block);
                    }

                }
                //TODO replace operation to cellTransform
                if ((block == null) && (isDebug))
                    workbookManager.mergeCells(new Block(cCell), cellShift, tmpC++);
            }

            System.out.println(String.format("Cell block(l:%s, r:%s, t:%s, b:%s) Value=%s", cCell.getCl(), cCell.getCr(), cCell.getRt(), cCell.getRb(), cCell.getText()));

            if (cCell.getRb() < hB)
                buildBlock(cCell);
            //Value for next cell
            curCellLeft = cCell.getCr() + 1;
        } while (curCellLeft <= hR);
    }

    private CCell expCell(CCell cCell, int rightBorder, int bottomBorder) {
        Block block, blockToCompare;
        CCell tmpCell;
        if (cCell == null)
            return cCell;
        blockToCompare = new Block(cCell);
        cCell = expByHeight(cCell, bottomBorder);
        if ((!isRightBorder(cCell)) && (cCell.getCr() < rightBorder)) {
            tmpCell = getRightCell(cCell);
            block = checkForExtension(tmpCell, cCell.getRb(), rightBorder, isLabel(cCell), cCell.getStyle().getBottomBorder());
            if (block != null) {
                cCell = block.mergeWithCell(cCell);
                if (!isLabel(cCell)) {
                    tmpCell = getLowerCell(cCell);
                    if (tmpCell.getCr() == cCell.getCr())
                        cCell = expCell(cCell, rightBorder, bottomBorder);
                }
            }
        }
        //Reflect new cells in Excel document
        if (isDebug) {
            block = new Block(cCell);
            if (!blockToCompare.compareWith(block))
                workbookManager.mergeCells(block, cellShift, tmpC++);
        }

        return cCell;
    }

    private CCell expByWidth(CCell emptyCell, int rightBorder) {
        CCell nextCell, tmpCell = emptyCell;
        if (emptyCell == null)
            return null;
        boolean next = true;
        if (emptyCell.getStyle().getRightBorder().getType() != BorderType.NONE)
            next = false;
        while (next) {
            if ((emptyCell.getCr() + 1) > rightBorder)
                break;
            nextCell = getCellByCoord(emptyCell.getCr() + 1, emptyCell.getRt());
            if (nextCell == null)
                return emptyCell;
            //Check
            if ((nextCell == null) || (nextCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
                return emptyCell;
            if (nextCell.getCr() >= rightBorder)
                next = false;
            //Check right cell to extend to height
            if ((emptyCell.getRb() > nextCell.getRb())) {
                Block block = checkForExtension(getRightCell(nextCell), emptyCell.getRb(), rightBorder, isLabel(nextCell), nextCell.getStyle().getBottomBorder());
                if (block != null) {
                    //cellTransofrm(emptyCell, block);
                    emptyCell = block.mergeWithCell(emptyCell);
                    System.out.print(String.format("-Some block( %s, %s, %s, %s)-", block.getLeft(), block.getRight(), block.getTop(), block.getBottom()));
                }
            }

            if (emptyCell.getRb() == nextCell.getRb()) {
                //Check for vertical split
                if (!isLabel(emptyCell)) {
                    //It is possible to merge
                    nextCell.merge(emptyCell);
                    emptyCell = nextCell;

                    if ((isLabel(emptyCell)) || (emptyCell.getStyle().getRightBorder().getType() != BorderType.NONE)) //Cell has text
                        next = false;
                } else
                    next = false;
            } else next = false;
        }

        if (!emptyCell.equals(tmpCell))
            cellTransofrm(emptyCell, new Block(emptyCell));
        return emptyCell;
    }

    private CCell expByHeight(CCell emptyCell) {
        return expByHeight(emptyCell, -1);
    }

    private CCell expByHeight(CCell emptyCell, int bottomBorder) {
        CCell nextCell;
        String cellVal, nexCelVal;
        int cellsCount;
        if (emptyCell == null)
            return null;
        if (emptyCell.getRb() >= hB)
            return emptyCell;
        //If bottom border of block doesn't set
        if (bottomBorder == -1)
            bottomBorder = hB;
        //If impossible to increase height
        if (emptyCell.getRb() == hB)
            return emptyCell;
        cellsCount = (emptyCell.getRb() - emptyCell.getRt());
        do {
            if ((emptyCell.getRb() == bottomBorder) || (emptyCell.getStyle().getBottomBorder().getType() != BorderType.NONE))
                return emptyCell;
            nextCell = expByWidth(getCellByCoord(emptyCell.getCl(), emptyCell.getRb() + 1), emptyCell.getCr());
            if (nextCell == null)
                return emptyCell;

            //Rewrite height
            boolean isLeft = emptyCell.getCl() == 1;
            boolean diffMerge = ((nextCell.isBlank() != emptyCell.isBlank()) || (emptyCell.isBlank() && nextCell.isBlank()));
            boolean eqSize = emptyCell.getCr() == nextCell.getCr();
            boolean eqCells = cellsCount == (nextCell.getRb() - nextCell.getRt());

            if (!(((eqCells || ((eqCells == false) && (isLeft == false))) || diffMerge) && eqSize))
                return emptyCell;

            //Cells are equial, may be merged
            cellVal = String.format("%s %s", emptyCell.getText().trim(), nextCell.getText().trim()).trim();
            nextCell.merge(emptyCell);
            nextCell.setText(cellVal);
            emptyCell = nextCell;
        } while (emptyCell.getRb() < bottomBorder);
        //TODO Check the necessity of call
        cellTransofrm(emptyCell, new Block(emptyCell));
        return emptyCell;
    }

    void buildBlock(CCell topCell) {
        buildBlock(topCell, null);
    }

    void buildBlock(CCell topCell, Block block) {
        boolean direction = true; //true - go downwards; false - go upwards
        CCell curCell, newCell;
        Stack<CCell> blockItems = new Stack<>();
        if (block == null) {
            block = new Block(topCell);
            block.setBottom(hB);
            block.setText(topCell.getText());
        }
        topCell = expCell(topCell, block.getRight(), block.getBottom());
        blockItems.push(topCell);
        while (!blockItems.empty()) {
            //Do while there are some cells in block
            curCell = blockItems.peek();
            if ((curCell.getRb() == hB) && (direction)) direction = false;
            if (direction) {
                newCell = getCellByCoord(curCell.getCl(), curCell.getRb() + 1); //Get lower cell
                if (newCell == null) return;
                System.out.print(String.format("Cell was (l:%s, r:%s, t:%s, b:%s) become", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb()));
                if ((newCell.getCl() == 2) && (newCell.getRt() == 3))
                    System.out.println(123);
                newCell = expCell(newCell, block.getRight(), block.getBottom());
                System.out.println(String.format("(l:%s, r:%s, t:%s, b:%s) -", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb()));

                blockItems.push(newCell);
                block.increaseBlockSize(newCell);
                if (newCell.getRb() == hB) direction = false;
            } else {
                newCell = blockItems.pop();
                if (blockItems.empty()) break;
                curCell = blockItems.peek();

                if (newCell.getCr() < curCell.getCr()) {
                    //sub column
                    newCell = getCellByCoord(newCell.getCr() + 1, newCell.getRt());
                    if (newCell == null) break;
                    System.out.print(String.format("- cell_old(%s, %s, %s, %s) - ", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb()));
                    if ((newCell.getRb() == hB) && (newCell.getCr() == hR)) break;
                    curCell = expCell(newCell, block.getRight(), block.getBottom());
                    if (curCell.getRb() != newCell.getRb())
                        newCell = cellTransofrm(curCell, new Block(curCell));
                    else
                        newCell = curCell;
                    System.out.println(String.format("- cell_new(%s, %s, %s, %s) - ", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb()));
                    blockItems.push(newCell);
                    direction = true;
                }
            }
        }
    }

    private boolean isLabel(CCell cell) {
        if (cell == null) return false;
        if (cell.getText().isEmpty())
            return false;
        else
            return true;
    }

    private CCell cellTransofrm(CCell cCell, Block block) {
        return cellTransofrm(cCell, block, false);
    }

    private CCell cellTransofrm(CCell cCell, Block block, boolean sameBlock) {
        CCell rightCell;
        if (!sameBlock) {
            CCell neighborCellR = null, neighborCellB = null;
            boolean f;
            block.increaseBlockSize(cCell);
            do {
                f = false;
                if (cCell.getRb() < block.getBottom()) {
                    neighborCellB = expCell(cCell, block.getRight(), block.getBottom());
                    if ((neighborCellB != null) && (cCell.getRb() < neighborCellB.getRb())) {
                        f = true;
                        cCell = neighborCellB;
                    }
                }
                if (!isRightBorder(cCell)) {
                    rightCell = expByHeight(getRightCell(cCell));
                    if ((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() == BorderType.NONE) && (cCell.getRb() == rightCell.getRb())) {
                        if (cCell.getCr() < block.getRight()) {
                            Block bl = checkForExtension(rightCell, cCell.getRb(), block.getRight(), isLabel(cCell), cCell.getStyle().getBottomBorder());
                            if (bl != null) {
                                neighborCellR = bl.mergeWithCell(cCell);
                                if ((neighborCellR != null) && (cCell.getCr() < neighborCellR.getCr())) {
                                    f = true;
                                    cCell = neighborCellB;

                                }
                            }
                        }
                    }
                } else
                    f = false;
            } while (f);
        }
        //Expansion in width

        if (isDebug)
            workbookManager.mergeCells(new Block(cCell), cellShift, tmpC++);

        return cCell;
    }

    public CCell getCellByCoord(int l, int t) {
        Iterator<CCell> cCellIterator = table.getCells();
        while (cCellIterator.hasNext()) {
            CCell cCell = cCellIterator.next();
            if ((cCell.getCl() == l) && (cCell.getRt() == t)) {
                return cCell;
            }
        }
        return null;
    }

    public CCell getLowerCell(CCell curCell) {
        int l = curCell.getCl();
        int t = curCell.getRb() + 1;
        return getCellByCoord(l, t);
    }

    public CCell getRightCell(CCell curCell) {
        int l = curCell.getCr() + 1;
        int t = curCell.getRt();
        return getCellByCoord(l, t);
    }

    private Block checkForExtension(CCell cCell, int bottomBorder, int rightBorder, boolean lbl, CBorder bBorder) {
        /*
        Cerate block to merge with cell
        cCell - right hand cell
        bottomBorder - block border. All righter cells must have this border
        rightBorder - maximim right extension border
        lbl - does the initial cell has label
         */
        Block block = null, cellBlock;
        CCell newCell = expByHeight(cCell, bottomBorder), tmpCell;
        final boolean initCellLabel = lbl; // Label of left cell in block
        boolean newCellLabel = false, f = false;

        String blockText = "";
        if (!newCell.getStyle().getBottomBorder().getType().equals(bBorder.getType()))
            return null;
        Deque<CCell> blockDeque = new ArrayDeque<CCell>();
        if (cCell == null)
            return null;
        if (((lbl) && (newCell != null) && (isLabel(newCell))) || (newCell == null))
            return null;
        if (isRightBorder(newCell)) {
            blockDeque.add(newCell);
        } else {
            do {
                //TODO Optimize logic of cells extension
                cellBlock = new Block(newCell);
                if (newCell.getCr() <= rightBorder) {
                    //Cell may be extend to right
                    newCellLabel = isLabel(newCell);
                    if (initCellLabel == true) {
                        if (newCellLabel == false) {
                            blockDeque.add(newCell);
                        } else {
                            break;
                        }
                    } else {
                        blockDeque.add(newCell);
                        if (newCellLabel == true) {
                            if ((f == false) && (newCell.getCr() <= rightBorder))
                                f = true;
                            else break;
                        }
                    }

                    newCell = getRightCell(newCell);
                    if ((newCell == null) || (newCell.getCr() >= rightBorder)) {
                        if ((newCell != null) && (newCell.getCr() == rightBorder)) {
                            if ((initCellLabel == true) && (isLabel(newCell)) && (blockDeque.size() == 1))
                                break;
                            blockDeque.add(newCell);
                        }
                        break;
                    }
                    tmpCell = expByHeight(newCell, bottomBorder);
                    if ((tmpCell.getRb() == cellBlock.getBottom()) && (tmpCell.getStyle().getBottomBorder().getType().equals(bBorder.getType())))
                        newCell = tmpCell;
                    else
                        break;
                    if (isRightBorder(newCell)) {
                        blockDeque.add(newCell);
                        break;
                    }
                }

            } while ((newCell != null) && (newCell.getRb() <= bottomBorder) &&
                    (newCell.getCr() <= rightBorder) && (!cellBlock.compareWith(new Block(newCell)))
            );
        }

        if (f == true) {
            if ((blockDeque.size() > 1) && (isLabel(blockDeque.peekLast()) == true)) {
                blockDeque.pollLast();
                while (isLabel(blockDeque.peekLast()) == false) {
                    blockDeque.pollLast();
                }
            }
        }
        if (blockDeque.size() > 0) {
            for (CCell c : blockDeque
            ) {
                if (!c.getText().trim().isEmpty())
                    blockText = blockText.concat(" " + c.getText().trim());
            }
            block = new Block(blockDeque.peekFirst().getRt(), blockDeque.peekFirst().getRb(), blockDeque.peekFirst().getCl(), blockDeque.peekLast().getCr());
            block.setLeftBorderStyle(blockDeque.peekFirst().getStyle().getLeftBorder());
            block.setRightBorderStyle(blockDeque.peekLast().getStyle().getRightBorder());
            block.setTopBorderStyle(blockDeque.peekFirst().getStyle().getTopBorder());
            block.setBottomBorderStyle(blockDeque.peekFirst().getStyle().getBottomBorder());
            if (block.getRight() - block.getLeft() > 5)
                block.setHAlignment(HorzAlignment.FILL);
            block.setText(blockText.trim());
        }
        return block;
    }

    private boolean isRightBorder(CCell curCell) {
        CCell rightCell;
        if (curCell == null) return false;

        if ((curCell.getStyle().getRightBorder().getType() != BorderType.NONE) || (curCell.getCr() == hR))
            return true;
        rightCell = getRightCell(curCell);
        if ((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
            return true;
        return false;
    }

    private int getBottomBorder(CCell curCell) {
        CCell lowerCell = curCell;
        int borderPos = -1;
        boolean lbl = isLabel(lowerCell);
        do {
            if (lowerCell.getStyle().getBottomBorder().getType() != BorderType.NONE)
                borderPos = lowerCell.getRb();
            if ((lowerCell.getStyle().getBottomBorder().getType() != BorderType.NONE) && lbl)
                return lowerCell.getRb();
            lowerCell = getLowerCell(lowerCell);
            if (!lbl)
                lbl = isLabel(lowerCell);

        } while ((lowerCell != null) && (lowerCell.getRb() < table.numOfRows()));
        if (borderPos != -1)
            return borderPos;
        return curCell.getRb();
    }

}