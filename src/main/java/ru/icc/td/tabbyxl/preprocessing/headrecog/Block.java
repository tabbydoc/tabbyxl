package ru.icc.td.tabbyxl.preprocessing.headrecog;

import ru.icc.td.tabbyxl.model.CCell;


public class Block {
    private int top, bottom, left, right;
    private boolean isLabel = false;

    Block(CCell cCell){
        top = cCell.getRt();
        bottom = cCell.getRb();
        left = cCell.getCl();
        right = cCell.getCr();
    }

    Block(int top, int bottom, int left, int right){
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setLabel(boolean label) {
        isLabel = label;
    }
    public int getTop(){
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public boolean getIsLabel(){return isLabel; }

    public void increaseBlockSize(CCell cCell){
        if (cCell == null) return;
        if (cCell.getRb() > bottom) bottom = cCell.getRb();
        if (cCell.getCr() > right) right = cCell.getCr() +1;

    }

}
