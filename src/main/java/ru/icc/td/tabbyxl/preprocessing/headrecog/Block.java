package ru.icc.td.tabbyxl.preprocessing.headrecog;

import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.style.CBorder;
import ru.icc.td.tabbyxl.model.style.CStyle;
import ru.icc.td.tabbyxl.model.style.HorzAlignment;

final class Block {
    private int top, bottom, left, right;
    private String label = null;
    private CStyle cStyle;

    Block(CCell cCell) {
        top = cCell.getRt();
        bottom = cCell.getRb();
        left = cCell.getCl();
        right = cCell.getCr();
        cStyle = cCell.getStyle();
        label = cCell.getText();
    }

    Block(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        cStyle = new CStyle();
    }

    String getText() {
        return this.label;
    }

    void setText(String label) {
        this.label = label.trim();
    }

    void setLeftBorderStyle(CBorder leftBorderStyle) {
        cStyle.setLeftBorder(leftBorderStyle);
    }

    void setRightBorderStyle(CBorder rightBorderStyle) {
        cStyle.setRightBorder(rightBorderStyle);
    }

    void setTopBorderStyle(CBorder topBorderStyle) {
        cStyle.setTopBorder(topBorderStyle);
    }

    void setBottomBorderStyle(CBorder bottomBorderStyle) {
        cStyle.setBottomBorder(bottomBorderStyle);
    }

    void setHAlignment(HorzAlignment hAligment) {
        cStyle.setHorzAlignment(hAligment);
    }

    int getTop() {
        return top;
    }

    int getBottom() {
        return bottom;
    }

    void setBottom(int bottom) {
        this.bottom = bottom;
    }

    int getLeft() {
        return left;
    }

    int getRight() {
        return right;
    }

    void setRight(int right) {
        this.right = right;
    }

    void increaseBlockSize(CCell cCell) {
        if (cCell == null) return;
        if (cCell.getRb() > bottom) bottom = cCell.getRb();
        if (cCell.getCr() > right) right = cCell.getCr();

    }

    CCell mergeWithCell(CCell cell) {
        String text;
        if (null == cell)
            throw new NullPointerException("The merging cell is null");
        if (null == this)
            throw new NullPointerException("The merging block is null");

        int l = Math.min(left, cell.getCl());
        int t = Math.min(top, cell.getRt());
        int r = Math.max(right, cell.getCr());
        int b = Math.max(bottom, cell.getRb());
        text = (cell.getText().trim() + " " + this.getText().trim()).trim();
        cell.setCl(l);
        cell.setRt(t);
        cell.setCr(r);
        cell.setRb(b);
        cell.setText(text);
        this.setRightBorderStyle(cell.getStyle().getLeftBorder());
        cell.setStyle(this.cStyle);
        return cell;
    }

    boolean compareWith(Block block) {
        return (this.left == block.left) && (this.right == block.right) &&
                (this.top == block.top) && (this.bottom == block.bottom);
    }

}
