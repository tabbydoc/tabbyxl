package ru.icc.cells.ssdc;

public class MyPrinter {

    private static boolean flag = true;

    public static void setFlag(boolean flag) {
        MyPrinter.flag = flag;
    }

    public static void print(String string) {

        if(flag) System.out.println(string);
    }
}
