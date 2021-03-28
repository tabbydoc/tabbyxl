package ru.icc.td.tabbyxl.preprocessing.headrecog;

import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.style.CBorder;
import ru.icc.td.tabbyxl.model.style.CStyle;
import ru.icc.td.tabbyxl.model.style.HorzAlignment;

public class Block {
    private int top, bottom, left, right;
    private String label = null;
    private CStyle cStyle;

    public Block(CCell cCell) {
        top = cCell.getRt();
        bottom = cCell.getRb();
        left = cCell.getCl();
        right = cCell.getCr();
        cStyle = cCell.getStyle();
        label = cCell.getText();
    }

    public Block(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        cStyle = new CStyle();
    }

    public String getText() {
        return this.label;
    }

    public void setText(String label) {
        this.label = label.trim();
    }

    public void setLeftBorderStyle(CBorder leftBorderStyle) {
        cStyle.setLeftBorder(leftBorderStyle);
    }

    public void setRightBorderStyle(CBorder rightBorderStyle) {
        cStyle.setRightBorder(rightBorderStyle);
    }

    public void setTopBorderStyle(CBorder topBorderStyle) {
        cStyle.setTopBorder(topBorderStyle);
    }

    public void setBottomBorderStyle(CBorder bottomBorderStyle) {
        cStyle.setBottomBorder(bottomBorderStyle);
    }

    public void setHAlignment(HorzAlignment hAligment) {
        cStyle.setHorzAlignment(hAligment);
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void increaseBlockSize(CCell cCell) {
        if (cCell == null) return;
        if (cCell.getRb() > bottom) bottom = cCell.getRb();
        if (cCell.getCr() > right) right = cCell.getCr();

    }

    public CCell mergeWithCell(CCell cell) {
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

    public boolean compareWith(Block block) {
        return (this.left == block.left) && (this.right == block.right) &&
                (this.top == block.top) && (this.bottom == block.bottom);
    }

}
