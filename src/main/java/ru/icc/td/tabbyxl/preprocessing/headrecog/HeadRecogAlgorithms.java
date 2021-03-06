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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class HeadRecogAlgorithms {
    private CTable table;
    private int hB = 0, hR = 0;
    private boolean canWrite;
    private CellPointer cellShift;
    private WorkbookManager workbookManager;

    public HeadRecogAlgorithms(CTable inputTable, Workbook workbook) {
        table = inputTable;
        int shift[] = cellsInIntArray(table.getSrcStartCellRef());
        cellShift = new CellPointer(shift);
        hR = table.numOfCols();
        canWrite = true;

        if (canWrite) {
            String sheetName = table.getSrcSheetName();
            workbookManager = new WorkbookManager(workbook, sheetName);
        }

        // The first cell determines a bottom border of the header
        CCell cell = cellAt(1, 1);
        hB = getBottomBorder(cell);
    }

    // Get a column number by its name
    private int rowLetterToInt(String col) {
        int number = 0;
        col = col.toUpperCase();

        for (int i = 0; i < col.length(); i++)
            number = number * 26 + (col.charAt(i) - ('A' - 1));

        return number;
    }

    private int[] cellsInIntArray(String col) {
        int divPos;
        int[] result = new int[2];
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(col);

        if (m.find()) {
            divPos = m.start();

            if (divPos < 1)
                throw new IllegalArgumentException("Incorrect coordinates of Excel cell");

            result[0] = rowLetterToInt(col.substring(0, divPos)) - 1;
            result[1] = Integer.parseInt(col.substring(divPos)) - 1;
        }

        return result;
    }

    public void analyze() {
        CCell cCell, tmpCell;
        Block headBlock;
        Block block;
        int curCellLeft = 1;

        do {
            cCell = cellAt(curCellLeft, 1);

            if (cCell == null)
                break;

            cCell = expandCell(cCell, hR, hB);

            if (!isLabel(cCell)) {
                headBlock = new Block(cCell);

                if (!isLabel(cCell) && isVisible(lfBorder(cCell)) && cCell.getCr() < hR) {

                    tmpCell = cellAt(cCell.getCr() + 1, cCell.getRt());

                    if (tmpCell != null) {
                        cCell = expandByHeight(cCell, tmpCell.getRb());

                        if (cCell.getRb() == tmpCell.getRb()) {
                            headBlock.setRight(tmpCell.getCr());
                            headBlock.setBottom(cCell.getRb());
                        }
                    }
                }
                cCell = transform(cCell, headBlock);
            } else {
                block = null;
                cCell = expandByHeight(cCell);

                if (!isRightBorder(cCell)) {
                    CCell rc = getRightCell(cCell);
                    block = getExpansion(rc, cCell.getRb(), hR, isLabel(cCell), btBorder(cCell));

                    if (block != null) {
                        cCell = transform(cCell, block);
                    }
                }

                if (block == null && canWrite)
                    workbookManager.mergeCells(new Block(cCell), cellShift);
            }

            if (cCell.getRb() < hB)
                buildBlock(cCell);

            // Value for next cell
            curCellLeft = cCell.getCr() + 1;
        } while (curCellLeft <= hR);
    }

    private CCell expandCell(CCell cCell, int rightBorder, int bottomBorder) {
        Block block, blockToCompare;
        CCell tmpCell;

        if (cCell == null)
            return cCell;

        blockToCompare = new Block(cCell);
        cCell = expandByHeight(cCell, bottomBorder);

        if (!isRightBorder(cCell) && cCell.getCr() < rightBorder) {
            tmpCell = getRightCell(cCell);
            block = getExpansion(tmpCell, cCell.getRb(), rightBorder, isLabel(cCell), btBorder(cCell));

            if (block != null) {
                cCell = block.mergeWithCell(cCell);

                if (!isLabel(cCell)) {
                    tmpCell = getLowerCell(cCell);

                    if (tmpCell.getCr() == cCell.getCr())
                        cCell = expandCell(cCell, rightBorder, bottomBorder);
                }
            }
        }

        // Map new cells to the Excel workbook
        if (canWrite) {
            block = new Block(cCell);

            if (!blockToCompare.compareWith(block))
                workbookManager.mergeCells(block, cellShift);
        }

        return cCell;
    }

    private CCell expandByWidth(CCell emptyCell, int rightBorder) {
        CCell nextCell, tmpCell = emptyCell;

        if (emptyCell == null)
            return null;

        boolean next = true;

        if (isVisible(rgBorder(emptyCell)))
            next = false;

        while (next) {
            if ((emptyCell.getCr() + 1) > rightBorder)
                break;
            nextCell = cellAt(emptyCell.getCr() + 1, emptyCell.getRt());

            if (nextCell == null)
                return emptyCell;

            if (nextCell == null || isVisible(lfBorder(nextCell)))
                return emptyCell;

            if (nextCell.getCr() >= rightBorder)
                next = false;

            if (emptyCell.getRb() > nextCell.getRb()) {
                Block block = getExpansion(getRightCell(nextCell), emptyCell.getRb(), rightBorder, isLabel(nextCell), btBorder(nextCell));

                if (block != null)
                    emptyCell = block.mergeWithCell(emptyCell);
            }

            if (emptyCell.getRb() == nextCell.getRb()) {
                // Check for the vertical split
                if (!isLabel(emptyCell)) {
                    // Can merge
                    nextCell.merge(emptyCell);
                    emptyCell = nextCell;

                    if (isLabel(emptyCell) || isVisible(rgBorder(emptyCell)))
                        next = false;
                } else
                    next = false;
            } else next = false;
        }

        if (!emptyCell.equals(tmpCell))
            transform(emptyCell, new Block(emptyCell));

        return emptyCell;
    }

    private CCell expandByHeight(CCell emptyCell) {
        return expandByHeight(emptyCell, -1);
    }

    private CCell expandByHeight(CCell emptyCell, int bottomBorder) {
        CCell nextCell;
        String cellVal;
        int cellsCount;

        if (emptyCell == null)
            return null;

        if (emptyCell.getRb() >= hB)
            return emptyCell;

        if (bottomBorder == -1)
            bottomBorder = hB;

        if (emptyCell.getRb() == hB)
            return emptyCell;

        cellsCount = (emptyCell.getRb() - emptyCell.getRt());

        do {
            if (emptyCell.getRb() == bottomBorder || isVisible(btBorder(emptyCell)))
                return emptyCell;

            nextCell = expandByWidth(cellAt(emptyCell.getCl(), emptyCell.getRb() + 1), emptyCell.getCr());

            if (nextCell == null)
                return emptyCell;

            boolean isLeft = emptyCell.getCl() == 1;
            boolean diffMerge = (nextCell.isBlank() != emptyCell.isBlank() || emptyCell.isBlank() && nextCell.isBlank());
            boolean eqSize = emptyCell.getCr() == nextCell.getCr();
            boolean eqCells = cellsCount == (nextCell.getRb() - nextCell.getRt());

            if (!(((eqCells || (!eqCells && !isLeft)) || diffMerge) && eqSize))
                return emptyCell;

            cellVal = String.format("%s %s", emptyCell.getText().trim(), nextCell.getText().trim()).trim();
            nextCell.merge(emptyCell);
            nextCell.setText(cellVal);
            emptyCell = nextCell;
        } while (emptyCell.getRb() < bottomBorder);

        transform(emptyCell, new Block(emptyCell));
        return emptyCell;
    }

    private void buildBlock(CCell topCell) {
        buildBlock(topCell, null);
    }

    private void buildBlock(CCell topCell, Block block) {
        boolean direction = true; //true - go downwards; false - go upwards
        CCell curCell, newCell;
        Stack<CCell> blockItems = new Stack<>();

        if (block == null) {
            block = new Block(topCell);
            block.setBottom(hB);
            block.setText(topCell.getText());
        }

        topCell = expandCell(topCell, block.getRight(), block.getBottom());
        blockItems.push(topCell);

        while (!blockItems.empty()) {
            curCell = blockItems.peek();

            if (curCell.getRb() == hB && direction)
                direction = false;

            if (direction) {
                newCell = cellAt(curCell.getCl(), curCell.getRb() + 1);

                if (newCell == null)
                    return;

                newCell = expandCell(newCell, block.getRight(), block.getBottom());

                blockItems.push(newCell);
                block.increaseBlockSize(newCell);

                if (newCell.getRb() == hB)
                    direction = false;
            } else {
                newCell = blockItems.pop();

                if (blockItems.empty())
                    break;

                curCell = blockItems.peek();

                if (newCell.getCr() < curCell.getCr()) {
                    newCell = cellAt(newCell.getCr() + 1, newCell.getRt());

                    if (newCell == null)
                        break;

                    if (newCell.getRb() == hB && newCell.getCr() == hR)
                        break;

                    curCell = expandCell(newCell, block.getRight(), block.getBottom());

                    if (curCell.getRb() != newCell.getRb())
                        newCell = transform(curCell, new Block(curCell));
                    else
                        newCell = curCell;

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

    private CCell transform(CCell cCell, Block block) {
        return transform(cCell, block, false);
    }

    private CCell transform(CCell cCell, Block block, boolean sameBlock) {
        CCell rightCell;

        if (!sameBlock) {
            CCell neighborCellR = null, neighborCellB = null;
            boolean f;
            block.increaseBlockSize(cCell);

            do {
                f = false;

                if (cCell.getRb() < block.getBottom()) {
                    neighborCellB = expandCell(cCell, block.getRight(), block.getBottom());

                    if ((neighborCellB != null) && (cCell.getRb() < neighborCellB.getRb())) {
                        f = true;
                        cCell = neighborCellB;
                    }
                }

                if (!isRightBorder(cCell)) {
                    rightCell = expandByHeight(getRightCell(cCell));

                    if (rightCell != null && isVisible(lfBorder(rightCell)) && cCell.getRb() == rightCell.getRb()) {
                        if (cCell.getCr() < block.getRight()) {
                            Block bl = getExpansion(rightCell, cCell.getRb(), block.getRight(), isLabel(cCell), btBorder(cCell));

                            if (bl != null) {
                                neighborCellR = bl.mergeWithCell(cCell);

                                if (neighborCellR != null && cCell.getCr() < neighborCellR.getCr()) {
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

        if (canWrite)
            workbookManager.mergeCells(new Block(cCell), cellShift);

        return cCell;
    }

    private CCell cellAt(int l, int t) {
        Iterator<CCell> cCellIterator = table.getCells();

        while (cCellIterator.hasNext()) {
            CCell cCell = cCellIterator.next();

            if (cCell.getCl() == l && cCell.getRt() == t) {
                return cCell;
            }
        }
        return null;
    }

    private CCell getLowerCell(CCell curCell) {
        int l = curCell.getCl();
        int t = curCell.getRb() + 1;
        return cellAt(l, t);
    }

    private CCell getRightCell(CCell curCell) {
        int l = curCell.getCr() + 1;
        int t = curCell.getRt();
        return cellAt(l, t);
    }

    private Block getExpansion(CCell cCell, int bottomBorder, int rightBorder, boolean lbl, CBorder bBorder) {
        /*
            Create a block to merge with a cell
            cCell - a right-hand cell
            bottomBorder - a block border. The right cells should have this border
            rightBorder - a maximum right border for the extension
        */
        Block block = null, cellBlock;
        CCell newCell = expandByHeight(cCell, bottomBorder), tmpCell;
        final boolean initCellLabel = lbl;
        boolean newCellLabel = false, f = false;

        String blockText = "";

        if (!newCell.getStyle().getBottomBorder().getType().equals(bBorder.getType()))
            return null;

        Deque<CCell> blockDeque = new ArrayDeque<>();

        if (cCell == null)
            return null;

        if ((lbl && newCell != null && isLabel(newCell)) || newCell == null)
            return null;

        if (isRightBorder(newCell)) {
            blockDeque.add(newCell);
        } else {
            do {
                cellBlock = new Block(newCell);

                if (newCell.getCr() <= rightBorder) {
                    newCellLabel = isLabel(newCell);

                    if (initCellLabel) {
                        if (!newCellLabel) {
                            blockDeque.add(newCell);
                        } else {
                            break;
                        }
                    } else {
                        blockDeque.add(newCell);

                        if (newCellLabel) {
                            if (!f && newCell.getCr() <= rightBorder)
                                f = true;
                            else
                                break;
                        }
                    }

                    newCell = getRightCell(newCell);

                    if (newCell == null || newCell.getCr() >= rightBorder) {
                        if (newCell != null && newCell.getCr() == rightBorder) {
                            if (initCellLabel && isLabel(newCell) && blockDeque.size() == 1)
                                break;

                            blockDeque.add(newCell);
                        }
                        break;
                    }

                    tmpCell = expandByHeight(newCell, bottomBorder);

                    if (tmpCell.getRb() == cellBlock.getBottom() && type(btBorder(tmpCell)).equals(bBorder.getType()))
                        newCell = tmpCell;
                    else
                        break;
                    if (isRightBorder(newCell)) {
                        blockDeque.add(newCell);
                        break;
                    }
                }

            } while (newCell != null && newCell.getRb() <= bottomBorder &&
                    newCell.getCr() <= rightBorder && !cellBlock.compareWith(new Block(newCell))
            );
        }

        if (f) {
            if (blockDeque.size() > 1 && isLabel(blockDeque.peekLast())) {
                blockDeque.pollLast();

                while (!isLabel(blockDeque.peekLast())) {
                    blockDeque.pollLast();
                }
            }
        }

        if (blockDeque.size() > 0) {
            for (CCell c : blockDeque) {
                if (!c.getText().trim().isEmpty())
                    blockText = blockText.concat(" " + c.getText().trim());
            }

            CCell first = blockDeque.peekFirst();
            CCell last = blockDeque.peekLast();

            block = new Block(first.getRt(), first.getRb(), first.getCl(), last.getCr());
            block.setLeftBorderStyle(lfBorder(first));
            block.setRightBorderStyle(rgBorder(last));
            block.setTopBorderStyle(tpBorder(first));
            block.setBottomBorderStyle(btBorder(first));

            if (block.getRight() - block.getLeft() > 5)
                block.setHAlignment(HorzAlignment.FILL);

            block.setText(blockText.trim());
        }
        return block;
    }

    private boolean isRightBorder(CCell curCell) {
        CCell rightCell;

        if (curCell == null) return false;

        if (isVisible(rgBorder(curCell)) || curCell.getCr() == hR)
            return true;

        rightCell = getRightCell(curCell);

        if (rightCell != null && isVisible(lfBorder(rightCell)))
            return true;

        return false;
    }

    private int getBottomBorder(CCell curCell) {
        CCell lowerCell = curCell;
        int borderPos = -1;
        boolean lbl = isLabel(lowerCell);

        do {
            if (isVisible(btBorder(lowerCell)))
                borderPos = lowerCell.getRb();

            if (isVisible(btBorder(lowerCell)) && lbl)
                return lowerCell.getRb();

            lowerCell = getLowerCell(lowerCell);

            if (!lbl)
                lbl = isLabel(lowerCell);
        } while (lowerCell != null && lowerCell.getRb() < table.numOfRows());

        if (borderPos != -1)
            return borderPos;

        return curCell.getRb();
    }

    private static CBorder lfBorder(CCell cell) {
        return cell.getStyle().getLeftBorder();
    }

    private static CBorder tpBorder(CCell cell) {
        return cell.getStyle().getTopBorder();
    }

    private static CBorder rgBorder(CCell cell) {
        return cell.getStyle().getRightBorder();
    }

    private static CBorder btBorder(CCell cell) {
        return cell.getStyle().getBottomBorder();
    }

    private static BorderType type(CBorder border) {
        return border.getType();
    }

    private static boolean isVisible(CBorder border) {
        return border.getType() != BorderType.NONE;
    }

}