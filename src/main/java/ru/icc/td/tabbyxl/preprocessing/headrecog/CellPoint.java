/*
 * Class for storing the shift of cells in Cells model in relation to Excel sheet
 */

package ru.icc.td.tabbyxl.preprocessing.headrecog;

public final class CellPoint {
    int c, r;

    public CellPoint(int[] shift) {
        this.c = shift[0];
        this.r = shift[1];
    }

}
