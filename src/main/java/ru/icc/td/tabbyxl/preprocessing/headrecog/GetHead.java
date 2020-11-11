package ru.icc.td.tabbyxl.preprocessing.headrecog;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.style.BorderType;
import ru.icc.td.tabbyxl.model.style.CBorder;
import ru.icc.td.tabbyxl.model.style.CStyle;
import ru.icc.td.tabbyxl.model.style.HorzAlignment;

import java.io.IOException;
import java.util.*;


public class GetHead {
    CTable table;
    int hB =0, hR = 0;
    boolean isDebug;
    CellPoint cellShift;
    WorkbookManage workbookManage;
    enum CellParam { WIDTH, HEIGHT, BOTH}

    private int tmpC =0;

    public GetHead(CTable inputTable, int [] shift, Workbook workbook, String sheetName, String pathToSave){
        new GetHead(inputTable, shift, workbook, sheetName, pathToSave, false);
    }
    public GetHead(CTable inputTable, int [] shift, Workbook workbook, String sheetName, String pathToSave, boolean isDebug){
        int c=0, cId;
        table = inputTable;
        cellShift = new CellPoint(shift);
        hR = table.numOfCols();
        this.isDebug = isDebug;

        if (isDebug)
            workbookManage = new WorkbookManage(workbook, sheetName, pathToSave);

        //First cell determine the border of the header
        CCell cell = getCellByCoord(1, 1);
        /*
        if (cell.getRb() != cell.getRt())
            hB = cell.getRb();
        else
            hB = getHeaderLine();
        */
        hB = getBottomBorder(cell);
        if (isDebug) {
            System.out.println(String.format("%s sheet is processing", sheetName));
            System.out.printf("Head bottom = %d\n", hB);
            System.out.printf("Head right = %d\n", hR);
            System.out.printf("Value '%s'\n", getCellByCoord(1, 1).getText());
        }
    }

    private boolean isBorder(CCell cell, boolean isBottom){
        /*cell - cell for analyzis
        posititon: true - bottom line; false - top line.
        */
        BorderType borderType;
        if (isBottom == true)
            borderType = cell.getStyle().getBottomBorder().getType();
        else
            borderType = cell.getStyle().getTopBorder().getType();

        if (borderType == BorderType.NONE)
            return false;
        else
            return true;
    }

     private int getHeaderLine(){
        CCell curCell, nextCell;
        int res = 0;
        curCell = getCellByCoord(1, 1);
        do{
            if ( curCell == null ) return  0;
            if (isBorder(curCell,true)){
                res = curCell.getRb();
            }
            else{
                curCell = getCellByCoord(curCell.getCl(), curCell.getRb() +1);

            }
        }while (res == 0);
        return res;
    }



    public void analyzeHead(){
        //CellCoordNode cellCoordNode;
        CCell cCell, tmpCell;
        Block headBlock;
        Block block = null;
        int b,r;
        boolean lbl;
        int curCellTop = 1, curCellLeft = 1;
        do{
            //Get top level block borders
            cCell = getCellByCoord(curCellLeft, 1);
            if (cCell == null)
                break;
            cCell = expCell(cCell, hR, hB);
            if (! isLabel(cCell)) {
                //Get lower cell size
                headBlock = new Block(cCell);
                if ((! isLabel(cCell)) && (cCell.getStyle().getLeftBorder().getType() != BorderType.NONE) && (cCell.getCr() < hR)) {

                    tmpCell = getCellByCoord(cCell.getCr()+1, cCell.getRt());
                    if ((tmpCell != null)) {
                        cCell = expByHeight(cCell, tmpCell.getRb());
                        if (cCell.getRb() == tmpCell.getRb()) {
                            headBlock.setRight(tmpCell.getCr());
                            headBlock.setBottom(cCell.getRb());
                        }
                    }
                }
                cCell = cellTransofrm(cCell, headBlock);
            }

            else{
                block = null;
                cCell = expByHeight(cCell); //cCell Check the necessity of this operation
                if (! isRightBorder(cCell)) {
                    CCell rc = getRightCell(cCell);
                    block = checkForExtension(rc, cCell.getRb(), hR, isLabel(cCell));
                    if (block != null) {
                        cCell = cellTransofrm(cCell, block);
                    }

                }
                //TODO replace operation to cellTransform
                if ((block == null) && (isDebug))
                    workbookManage.mergeCells(new Block(cCell), cellShift, tmpC++);



            }

            System.out.println(String.format("Cell block(l:%s, r:%s, t:%s, b:%s) Value=%s", cCell.getCl(), cCell.getCr() ,cCell.getRt(), cCell.getRb(), cCell.getText()));

            if (cCell.getRb() < hB)
                buildBlock(cCell);
            //Value for next cell
            curCellLeft = cCell.getCr() + 1;
        }while(curCellLeft <= hR);
    }

    private CCell expCell(CCell cCell, int rightBorder, int bottomBorder) {
        Block block, blockToCompare;
        CCell tmpCell;
        if (cCell == null)
            return cCell;
        blockToCompare = new Block(cCell);
        cCell = expByHeight(cCell, bottomBorder);
        if ((! isRightBorder(cCell)) && (cCell.getCr() < rightBorder)){
            tmpCell = getRightCell(cCell);
            block = checkForExtension(tmpCell, cCell.getRb(), rightBorder, isLabel(cCell));
            if (block != null) {
                cCell = block.mergeWithCell(cCell);
                if (! isLabel(cCell)) {
                    tmpCell = getLowerCell(cCell);
                    if (tmpCell.getCr() == cCell.getCr())
                        cCell = expCell(cCell, rightBorder, bottomBorder);
                }

            }
        }
        //Reflect new cells in Excel document
        if (isDebug) {
            block = new Block(cCell);
            if (! blockToCompare.compareWith(block))
                workbookManage.mergeCells(block, cellShift, tmpC++);
        }
        return cCell;
    }


    private CCell expByWidth(CCell emptyCell){
        return expByWidth(emptyCell, emptyCell.getCr()+1);
    }

    private CCell expByWidth(CCell emptyCell, int rightBorder){
        CCell nextCell, tmpCell = emptyCell;
        boolean next = true;
        if (emptyCell.getStyle().getRightBorder().getType() != BorderType.NONE)
            next = false;

        while (next){
            if ((emptyCell.getCr()+1)> rightBorder)
                break;
            nextCell = getCellByCoord(emptyCell.getCr()+1, emptyCell.getRt());
            if (nextCell == null)
                return emptyCell;
            //Check
            //nextCell = expByHeight(nextCell, emptyCell.getRb());
            if ((nextCell == null) || (nextCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
                return emptyCell;
            if (nextCell.getCr() >= rightBorder)
                next = false;
            //Check right cell to extend to height
            if (( emptyCell.getRb() > nextCell.getRb() ) ){
                Block block = checkForExtension(getRightCell(nextCell), emptyCell.getRb(), rightBorder, isLabel(nextCell));
                if (block != null) {
                    //cellTransofrm(emptyCell, block);
                    emptyCell = block.mergeWithCell(emptyCell);
                    System.out.print(String.format("-Some block( %s, %s, %s, %s)-", block.getLeft(), block.getRight(), block.getTop(), block.getBottom()));
                }



            }

            if ( emptyCell.getRb() == nextCell.getRb() ){
                //Check for vertical split
                if (! isLabel(emptyCell)){
                    //It is possible to merge
                    nextCell.merge(emptyCell);
                    emptyCell = nextCell;

                    if ((isLabel(emptyCell)) || (emptyCell.getStyle().getRightBorder().getType() != BorderType.NONE)) //Cell has text
                        next = false;
                }
                else
                    next = false;
            }
            else next=false;

        };

        if (!emptyCell.equals(tmpCell))
            cellTransofrm(emptyCell, new Block(emptyCell));
        return emptyCell;

    }

    private CCell expByHeight(CCell emptyCell){
        return expByHeight(emptyCell, -1);
    }

    private CCell expByHeight(CCell emptyCell, int bottomBorder){
        CCell nextCell;
        String cellVal, nexCelVal;

        if (emptyCell == null)
            return null;
        if ( emptyCell.getRb() >= hB )
            return emptyCell;
        //If bottom border of block doesn't set
        if (bottomBorder == -1 )
            bottomBorder = hB;
        //If impossible to increase height
        if (emptyCell.getRb() == hB)
            return emptyCell;
        do{
            if ((emptyCell.getRb() == bottomBorder) || (emptyCell.getStyle().getBottomBorder().getType() != BorderType.NONE))
                return  emptyCell;
            nextCell = getCellByCoord(emptyCell.getCl(), emptyCell.getRb() + 1);
            if (nextCell == null)
                return emptyCell;
            if (emptyCell.getCr() != nextCell.getCr()) {
                return emptyCell; //if width of lower cell doesn't equial that current
            }
            //Cells are equial, may be merged
            cellVal = String.format("%s %s",emptyCell.getText().trim(), nextCell.getText().trim()).trim() ;
            nextCell.merge(emptyCell);
            nextCell.setText(cellVal);
            emptyCell = nextCell;
        } while(emptyCell.getRb() < bottomBorder);
        //TODO Check the necessity of call
        cellTransofrm(emptyCell, new Block(emptyCell));
        return emptyCell;
    }

    void buildBlock(CCell topCell){
        buildBlock(topCell, null);
    }

    void buildBlock(CCell topCell, Block block){
        boolean direction = true; //true - go downwards; false - go upwards
        CCell curCell, newCell;
        Stack<CCell> blockItems = new Stack<>();
        if (block == null) {
            block = new Block(topCell);
            block.setBottom(hB);
            block.setText(topCell.getText());
        }
        topCell = expCell(topCell,block.getRight(), block.getBottom());
        blockItems.push(topCell);
        while(! blockItems.empty()){
            //Do while there are some cells in block
            curCell = blockItems.peek();
            if( (curCell.getRb() == hB) && (direction)) direction = false;
            if (direction){
                newCell = getCellByCoord(curCell.getCl(), curCell.getRb()+1); //Get lower cell
                if (newCell == null) return;
                System.out.print(String.format("Cell was (l:%s, r:%s, t:%s, b:%s) become", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb() ));
                newCell = expCell(newCell, block.getRight(), block.getBottom());
                System.out.println(String.format("(l:%s, r:%s, t:%s, b:%s) -", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb() ));

                blockItems.push(newCell);
                block.increaseBlockSize(newCell);
                if (newCell.getRb() == hB) direction = false;
            }
            else {
                newCell = blockItems.pop();
                if (blockItems.empty()) break;
                curCell = blockItems.peek();

                if (newCell.getCr() < curCell.getCr()){
                    //sub column
                    newCell = getCellByCoord(newCell.getCr()+1, newCell.getRt());
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

    private boolean isLabel(CCell cell){
        if ( cell == null ) return false;
        if (cell.getText().isEmpty())
            return false;
        else
            return true;
    }
    private CCell cellTransofrm(CCell cCell,  Block block){
        return cellTransofrm(cCell, block, false);
    }
    private CCell cellTransofrm(CCell cCell,  Block block, boolean sameBlock){
        CCell rightCell;
        if (! sameBlock) {
            CCell neighborCellR = null, neighborCellB = null;
            boolean f;
            block.increaseBlockSize(cCell);
            do {
                f = false;
                if (cCell.getRb() < block.getBottom()) {
                    //neighborCellB = expByHeight(cCell, block.getBottom());
                    neighborCellB = expCell(cCell,block.getRight(), block.getBottom());
                    if ((neighborCellB != null) && (cCell.getRb() < neighborCellB.getRb())) {
                        f = true;
                        cCell = neighborCellB;
                    }
                }
                if (! isRightBorder(cCell)) {
                    rightCell = expByHeight(getRightCell(cCell));
                    if ((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() == BorderType.NONE) && (cCell.getRb() == rightCell.getRb())) {
                        if (cCell.getCr() < block.getRight()) {
                            Block bl = checkForExtension(rightCell, cCell.getRb(), block.getRight(), isLabel(cCell));
                            if (bl != null) {
                                neighborCellR = bl.mergeWithCell(cCell);
                                if ((neighborCellR != null) && (cCell.getCr() < neighborCellR.getCr())) {
                                    f = true;
                                    cCell = neighborCellB;

                                }
                            }
                        }
                    }
                }
                else
                    f=false;


            } while (f);
        }
        //Expansion in width
        if (isDebug)
            workbookManage.mergeCells(new Block(cCell), cellShift, tmpC++);

        return  cCell;
    }


    private boolean equal(CCell cell1, CCell cell2){
        return equals(cell1, cell2, CellParam.BOTH);
    }

    private boolean equals(CCell cell1, CCell cell2, CellParam cellParam){
        boolean resultW = false, resultH = false;
        if ((cell1 == null) || (cell2 == null))
            return false;
        if ((cell1.getCl() == cell2.getCl()) && (cell1.getCr() == cell2.getCr())) resultW = true;
        if (cellParam == CellParam.WIDTH) return resultW;
        if ((cell1.getRt() == cell2.getRt()) && (cell1.getRb() == cell2.getRb())) resultH = true;
        if (cellParam == CellParam.HEIGHT) return resultH;
        return resultH & resultW;
    }

    public CCell getCellByCoord(int l, int t){
        //if (t > hB ) t = hB;
        Iterator<CCell> cCellIterator = table.getCells();
        while (cCellIterator.hasNext()){
            CCell cCell = cCellIterator.next();
            if ((cCell.getCl() == l) && (cCell.getRt() == t)){
                return cCell;
            }
        }
        return null;
    }

    public CCell getUpperCell(int l, int b){
        Iterator<CCell> cCellIterator = table.getCells();
        while (cCellIterator.hasNext()){
            CCell cCell = cCellIterator.next();
            if ((cCell.getCl() == l) && (cCell.getRb() + 1 == b)){
                if (cCell.getStyle().getBottomBorder().getType() != BorderType.NONE)
                    return null;
                else
                    return cCell;
            }
        }
        return null;
    }

    public CCell getLeftCell(CCell curCell){
        int r, t;
        r = curCell.getCl() - 1;
        t = curCell.getRt();
        Iterator<CCell> cCellIterator = table.getCells();
        while (cCellIterator.hasNext()) {
            CCell cCell = cCellIterator.next();
            if (( cCell.getCr() == r ) && ( cCell.getRt() == t )){
                return cCell;
            }
        }
        return null;
    }

    public CCell getLowerCell(Block curBlock){
        int l = curBlock.getLeft();
        int t = curBlock.getBottom() + 1;
        return getCellByCoord(l,t);
    }

    public CCell getLowerCell(CCell curCell){
        int l = curCell.getCl();
        int t = curCell.getRb()+1;
        return getCellByCoord(l,t);
    }

    public CCell getRightCell(CCell curCell){
        int l = curCell.getCr() + 1;
        int t = curCell.getRt();
        return getCellByCoord(l,t);
    }

    public void saveWorksheet(String path){
        try {
            workbookManage.saveWorkbook(path);
            System.out.println("Copy was save");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveWorkbook(String path){
        try {
            workbookManage.saveWorkbook(path);
            System.out.println("Copy was save");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CCell checkLower(CCell curCell){ return checkLower(curCell, hB);}
    private CCell checkLower(CCell curCell, int bottomBorder){
        CCell resCell = curCell,
              tmpCell = null;
        boolean next = true;
        int ul = resCell.getRt();;
        do{
           if (resCell.getRb() +1 <= bottomBorder){
               if (resCell.getStyle().getBottomBorder().getType() != BorderType.NONE) {
                   next = false;
                   break;
               }
               tmpCell= getCellByCoord(resCell.getCr(), resCell.getRb()+1);
               if ((tmpCell == null) || (!equals(resCell, tmpCell,  CellParam.WIDTH))){
                   next = false;

               }
               else if (isLabel(tmpCell)) {
                   next = false;
               }
               else if (tmpCell.getStyle().getTopBorder().getType() != BorderType.NONE)
                   next = false;

               if (next){
                   resCell = tmpCell;
                   ul = resCell.getRt();
               }

           }
           else break;


        }while (next);

        if (next == false){
            //Cells may be merged
            int cellTop = curCell.getRb()+1;
            while(ul > cellTop){
                tmpCell = getCellByCoord(curCell.getCl(), cellTop);
                curCell = curCell.merge(tmpCell);
                cellTop = tmpCell.getRb()+1;

            };
        }

        return curCell;
    }
    private CCell checkRight(CCell curCell){
        return checkRight(curCell, -1);
    }
    private CCell checkRight(CCell curCell, int rightBorder){
        CCell resCell = curCell, tmpCell;
        CStyle cellStyle;
        CBorder cB;
        boolean next;
        do{
            next = true;
            if (resCell.getCr()+1 < hR){
                if (resCell.getStyle().getRightBorder().getType() != BorderType.NONE)
                    break;
                tmpCell = getCellByCoord(resCell.getCr()+1, resCell.getRt());
                if (isLabel(tmpCell) || (!equals(resCell, tmpCell,  CellParam.HEIGHT))) break;
                if ((tmpCell == null) || (tmpCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
                    break;
                else {
                    cB = tmpCell.getStyle().getRightBorder();
                    resCell = resCell.merge(tmpCell);
                    cellStyle = resCell.getStyle();
                    cellStyle.setRightBorder(cB);
                    resCell.setStyle(cellStyle); //Need to add method to CCell class


                }

                    cellTransofrm(resCell, new Block(resCell)); //Was added for test
            }
            else next = false;
        }while (next);

        return  resCell;
    }

    private int analyse2BottomLine(CCell cCell, int bottomBorder){
        //Looking for bottom border of col
        CCell curCell = cCell, tmpCell;

        int border = curCell.getRb();
        do{
            if (curCell.getRb() > bottomBorder)
                return -1;
            //Bottom border exists
            if ((curCell.getStyle().getBottomBorder().getType() != BorderType.NONE) || (curCell.getRb() == bottomBorder))
                return curCell.getRb();
            tmpCell = getCellByCoord(curCell.getCr(), curCell.getRb()+1);
            //Lower cell upper border exists
            if (tmpCell.getStyle().getTopBorder().getType() != BorderType.NONE)
                return curCell.getRb();
            curCell = tmpCell;
            //Check text



        }while(true);
    }


    private CCell mergeToLeft(CCell cCell){
        CCell leftCell;
        //Check the text existance in the cell
        if (isLabel(cCell) || (cCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
            return cCell;
        //The cell does not contain any text
        leftCell = getLeftCell(cCell);
        if (leftCell == null)
            return  cCell;
        if (leftCell.getStyle().getRightBorder().getType() != BorderType.NONE)
            return cCell;
        if ((cCell.getRt() == leftCell.getRt()) && (cCell.getRb() == leftCell.getRb()))
            cCell = leftCell.merge(cCell);
        return cCell;

    }
    private Block checkForExtension(CCell cCell, int bottomBorder, int rightBorder, boolean lbl){
        /*Cerate block to merge with cell
            cCell - right hand cell
            bottomBorder - block border. All righter cells must have this border
            rightBorder - maximim right extension border
            lbl - does the initial cell has label
         */
        if ((cCell != null) && (cCell.getCl() == 8))
            System.out.println("!!!!!");
        Block block = null, cellBlock;
        CCell newCell = expByHeight(cCell, bottomBorder), tmpCell;
        final boolean initCellLabel = lbl; // Label of left cell in block
        boolean newCellLabel = false, f=false;
        int bottomLine;
        String blockText="";
        Deque<CCell> blockDeque = new ArrayDeque<CCell>();
        if (cCell == null)
            return null;
        if (((lbl) && (newCell != null) && (isLabel(newCell))) || (newCell == null))
            return null;
        if (isRightBorder(newCell)) {
            blockDeque.add(newCell);
        }
        else {
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
                        ;
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
                        if   ((newCell != null) && (newCell.getCr() == rightBorder)) {
                            if ((initCellLabel == true) && (isLabel(newCell)) && (blockDeque.size() == 1))
                                break;
                            blockDeque.add(newCell);
                        }
                        break;
                    }
                    tmpCell = expByHeight(newCell, bottomBorder);
                    if (tmpCell.getRb() == cellBlock.getBottom())
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

        if ( f == true ){
            if ((blockDeque.size() > 1) && (isLabel(blockDeque.peekLast()) == true)){
                blockDeque.pollLast();
                while (isLabel(blockDeque.peekLast()) == false){
                    blockDeque.pollLast();
                }
            }
        }
        if (blockDeque.size()>0) {
            for (CCell c:blockDeque
                 ) {
                if (! c.getText().trim().isEmpty())
                    blockText = blockText.concat(" " + c.getText().trim());
            }
            block = new Block(blockDeque.peekFirst().getRt(), blockDeque.peekFirst().getRb(), blockDeque.peekFirst().getCl(), blockDeque.peekLast().getCr());
            block.setLeftBorderStyle(blockDeque.peekFirst().getStyle().getLeftBorder());
            block.setRightBorderStyle(blockDeque.peekLast().getStyle().getRightBorder());
            block.setTopBorderStyle(blockDeque.peekFirst().getStyle().getTopBorder());
            block.setBottomBorderStyle(blockDeque.peekFirst().getStyle().getBottomBorder());
            if ( block.getRight() - block.getLeft() > 5 )
                block.setHAlignment(HorzAlignment.FILL);
            block.setText(blockText.trim());
        }
        return block;



    }

    private boolean isRightBorder(CCell curCell){
        CCell rightCell;
        if (curCell == null) return false;

        if((curCell.getStyle().getRightBorder().getType() != BorderType.NONE) || (curCell.getCr() == hR))
            return true;
        rightCell = getRightCell(curCell);
        if ((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
            return true;
        return false;

    }

    private int getBottomBorder(CCell curCell){
        CCell lowerCell =curCell;
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

    private boolean mergeIsPossible(CCell cell1, CCell cell2){
        //Function estimate the possibility of cells merging
        CStyle c1Style =cell1.getStyle(),
               c2Style = cell2.getStyle();
        //Choose direction
        if ( (cell1.getCl() == cell2.getCl()) && (cell1.getCr() == cell2.getCr()) ) {
            //Merging in vertical direction
            if ((c1Style.getBottomBorder().getType() != BorderType.NONE) || (c2Style.getTopBorder().getType() != BorderType.NONE))
                return false;
        }
        else if ((cell1.getRt() == cell2.getRt()) && (cell1.getRb() == cell2.getRb())){
            //Merging in horizontal direction
            if ((c1Style.getRightBorder().getType() != BorderType.NONE) || (c2Style.getLeftBorder().getType() != BorderType.NONE))
                return false;
        }
        else
            //Different size. Merging is impossible
            return false;
        //Check styles information
        if (c1Style.getFgColor() != c2Style.getFgColor())
            return false;
        if (c1Style.getBgColor() != c2Style.getBgColor())
            return false;

        return true;
    }

}
