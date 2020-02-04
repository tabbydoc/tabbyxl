package ru.icc.td.tabbyxl.preprocessing.headrecog;


import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.style.BorderType;
import ru.icc.td.tabbyxl.model.style.CBorder;
import ru.icc.td.tabbyxl.model.style.CStyle;

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

        if (cell.getRb() != cell.getRt())
            hB = cell.getRb();
        else
            hB = getHeaderLine();
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
                //cCell = expCell(cCell, hR, hB);

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

                //cCell = expByHeight(cCell); //cCell
                if (! isRightBorder(cCell)) {
                    CCell rc = getRightCell(cCell);
                    Block block = checkForExtension(rc, cCell.getRb(), hR, isLabel(cCell));
                    if (block != null) {
                        cCell = cellTransofrm(cCell, block);
                    }
                }
            }
            System.out.println(String.format("Cell block(l:%s, r:%s, t:%s, b:%s) Value=%s", cCell.getCl(), cCell.getCr() ,cCell.getRt(), cCell.getRb(), cCell.getText()));

            if (cCell.getRb() < hB)
                buildBlock(cCell);
            //Value for next cell
            curCellLeft = cCell.getCr() + 1;
        }while(curCellLeft <= hR);
    }

    private CCell expCell(CCell cCell, int rightBorder, int bottomBorder) {
        Block block;
        CCell tmpCell;
        if (cCell == null)
            return cCell;
        cCell = expByHeight(cCell, bottomBorder);
        if (! isRightBorder(cCell)){
            tmpCell = getRightCell(cCell);
            block = checkForExtension(tmpCell, cCell.getRb(), rightBorder, isLabel(cCell));
            if (block != null) {
                cCell = block.mergeWithCell(cCell);
                //Reflect new cells in Excel document
                if (isDebug)
                    workbookManage.mergeCells(new Block(cCell), cellShift, tmpC++);
            }
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
        cellTransofrm(emptyCell, new Block(emptyCell));
        return emptyCell;
    }

    void buildBlock(CCell topCell){
        buildBlock(topCell, null);
    }

    void buildBlock(CCell topCell, Block block){
        CCell tmpCell;
        Block tmpBlock;
        boolean direction = true; //True - go downwards; false - go upwards
        Stack<CCell> blockItems = new Stack<>();
        if (topCell == null)
            return;
        CCell curCell, newCell = null;
        if (block == null) {
            block = new Block(topCell); //Default block size
            block.setBottom(hB);
        }
        if (! isLabel(topCell)) topCell = expCell(topCell, block.getRight(), block.getBottom());
        blockItems.push(topCell);
        while(! blockItems.empty()){
            curCell = blockItems.peek();
            if( (curCell.getRb() == hB) && (direction)) direction = false;

            if (direction == true){
                newCell = getCellByCoord(curCell.getCl(), curCell.getRb()+1);
                if (newCell == null) return;
                //if (! isLabel(newCell))
                    newCell = expCell(newCell,block.getRight(),block.getBottom());
                if ((newCell != null) && (! isLabel(newCell))){
                    System.out.print(String.format("! cell_old(l:%s, r:%s, t:%s, b:%s) - ", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb()));
                    Block newBlock = new Block(newCell);
                    newBlock.setBottom(block.getBottom());
                    newBlock.setRight(curCell.getCr());
                    newCell = cellTransofrm(newCell, newBlock);
                    tmpCell = getUpperCell(newCell.getCl(), newCell.getRt());

                    if ((tmpCell != null) && (isLabel(tmpCell)) && (tmpCell.getCl() == newCell.getCl()) &&
                            (tmpCell.getCr() == newCell.getCr()) && (tmpCell.getRb() + 1 == newCell.getRt())
                            && (! isLabel(tmpCell) && (tmpCell.getStyle().getBottomBorder().getType() == BorderType.NONE))
                            && (newCell.getStyle().getTopBorder().getType() == BorderType.NONE)
                    ){
                        tmpBlock = new Block(tmpCell);
                        tmpBlock.setBottom(newCell.getRb());
                        newCell = cellTransofrm(tmpCell, tmpBlock);
                        blockItems.pop();
                    }
                    System.out.println(String.format("#cell_new(l:%s, r:%s, t:%s, b:%s) Value = '%s'", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb(), newCell.getText()));
                }

                else if(newCell == null) {
                    newCell = expByHeight(curCell);//mergeVertCells(newCell);
                }


                blockItems.push(newCell);
                block.increaseBlockSize(newCell);
                if (newCell.getRb() == hB) direction = false;
            }
            else{
                //Back step
                newCell = blockItems.pop();
                //if there are no any items in stack than exit
                if (blockItems.empty()) break;
                curCell = blockItems.peek();

                if (newCell.getCr() < curCell.getCr()){
                    //sub column
                    newCell = getCellByCoord(newCell.getCr()+1, newCell.getRt());
                    if (newCell == null) break;
                    if (! isLabel(newCell)){
                        System.out.print(String.format("- cell_old(%s, %s, %s, %s) - ", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb()));
                        newCell = cellTransofrm(newCell, block);
                        System.out.println(String.format("cell_new(%s, %s, %s, %s), Value = %s", newCell.getCl(), newCell.getCr(), newCell.getRt(), newCell.getRb(), newCell.getText()));
                    }
                    if ((newCell.getRb() == hB) && (newCell.getCr() == hR)) break;
                    curCell = expCell(newCell, block.getRight(), block.getBottom());

                    if (curCell.getRb() != newCell.getRb())
                        newCell = cellTransofrm(curCell, new Block(curCell));
                    else
                        newCell = curCell;
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
                rightCell = getRightCell(cCell);
                if ((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() == BorderType.NONE)) {
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
                else
                    f=false;


            } while (f);
        }
        else{

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

    public CCell getLowerCell(Block curCell){
        int l = curCell.getLeft();
        int t = curCell.getBottom() + 1;
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
        Block block = null;
        CCell newCell = cCell, tmpCell;
        boolean newCellLbl;
        String blockText="";
        Deque<CCell> blockDeque = new ArrayDeque<CCell>();
        if (cCell == null)
            return null;
        do{
            newCell = expByHeight(newCell, bottomBorder);
            newCellLbl = isLabel(newCell);
            if ((newCell.getRb() == bottomBorder) &&
               (newCell.getCr()<= rightBorder)){

                if ( ((lbl ==false) && (newCellLbl == false)) || (lbl != newCellLbl) ){
                    blockDeque.add(newCell);
                    lbl = isLabel(newCell);
                    if ( isRightBorder(newCell))
                        //Reach to the border. Nothing to search
                        break;
                    newCell = getRightCell(newCell);

                } else {
                    //Both cells have some text
                    while((blockDeque.size()>0) && (!isLabel(blockDeque.peekLast()))){
                        //Remove cells without text from the deque
                        blockDeque.getLast();
                    }
                    break;
                }
            }
            else break;
        }while(newCell != null);
        //There are some cells in the deque
        if (blockDeque.size()>0) {
            for (CCell c:blockDeque
                 ) {
                if (! c.getText().trim().isEmpty())
                    blockText = blockText.concat(" " + c.getText());
            }
            block = new Block(blockDeque.peekFirst().getRt(), blockDeque.peekFirst().getRb(), blockDeque.peekFirst().getCl(), blockDeque.peekLast().getCr());
            block.setLeftBorderStyle(blockDeque.peekFirst().getStyle().getLeftBorder());
            block.setRightBorderStyle(blockDeque.peekLast().getStyle().getRightBorder());
            block.setTopBorderStyle(blockDeque.peekFirst().getStyle().getTopBorder());
            block.setBottomBorderStyle(blockDeque.peekFirst().getStyle().getBottomBorder());
            block.setText(blockText.trim());
        }



        return block;



    }
    private Block checkForExtension_(CCell cCell, int bottomBorder, int rightBorder, boolean lbl){

        boolean hasRightBorder = false; //Variable for the case if current cell hasn't BORDER but cell by right hand side - has.
        boolean rightCellLbl;
        CCell rightCell;
        if (cCell == null) //No data
            return null;

        Block emptyBlock = new Block(cCell);
        CCell newCell = cCell;
        if (cCell.getRb()<bottomBorder)
            do {
                newCell = getLowerCell(emptyBlock);
                //------Should be checked-------

                //---End of should be checked---
                rightCellLbl =isLabel(newCell);
                if (!
                        ((! lbl) && (! rightCellLbl)) || //Both cells haven't text
                        ((! lbl) && (rightCellLbl)) ||   //Current cell hasn't text, but right has
                        ((lbl) && (! rightCellLbl) && (isRightBorder(newCell))) //Current cell has label, right - hasn't but border after right cell

                )
                    return null;

                emptyBlock.increaseBlockSize(newCell);
            } while((newCell != null) && (isLabel(newCell) == false) && (newCell.getRb()+1 <= bottomBorder));

        //Check logic!!!!!
        if (isLabel(newCell) == true)
            return null;

        if (newCell == null)
           newCell = cCell;

        rightCell = getRightCell(newCell);
        if((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
            hasRightBorder = true;



        if ((newCell.getRb() == bottomBorder) && (newCell.getCr() + 1 < rightBorder + 1) &&
                (( newCell.getStyle().getRightBorder().getType() == BorderType.NONE ) && (hasRightBorder == false))){
            newCell = getRightCell(cCell);
            if ((newCell != null) ){
                Block tmpBlock = checkForExtension(newCell, bottomBorder, rightBorder, isLabel(cCell));
                if (tmpBlock != null)
                   emptyBlock.concatBlock(tmpBlock);
            }
        }
        return emptyBlock; //temporary for return value
    }

    private boolean isRightBorder(CCell curCell){
        CCell rightCell;
        if (curCell == null) return false;
        if (curCell.getStyle().getRightBorder().getType() != BorderType.NONE)
            return true;
        rightCell = getRightCell(curCell);
        if ((rightCell != null) && (rightCell.getStyle().getLeftBorder().getType() != BorderType.NONE))
            return true;
        return false;

    }

}
