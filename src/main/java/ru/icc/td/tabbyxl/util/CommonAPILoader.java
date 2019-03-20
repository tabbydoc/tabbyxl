package ru.icc.td.tabbyxl.util;

import ru.icc.td.tabbyxl.commons.CellsDataPreproc;
import ru.icc.td.tabbyxl.commons.LitType;

import java.io.IOException;

public class CommonAPILoader {

    public static void main(String[] params) throws IOException, ClassNotFoundException {
        if (params[0].equals("-s")){
            //Data from param
            String delim = "\\s*,\\s*";
            //String[] initData = params[1].split(delim);
            //stanfordCore(params[1]);
            CellsDataPreproc preproc = new CellsDataPreproc(params[1], " ");
            System.out.println(preproc.getNerList(1));
            System.out.println(preproc.getNerList(2));

        }

    }

    private static void stanfordCore(String data) throws IOException, ClassNotFoundException {
        System.out.println("Result of strings array processing:");


        LitType litType = new LitType(data);

        System.out.println(String.format("%s:(%s | %s | %s)", litType.getEntry(), litType.getTag(), litType.getSubType(), litType.getLemmas().toString()));







    }


}


