package ru.icc.td.tabbyxl.util;

import ru.icc.td.tabbyxl.commons.LitTypeDetect;

import java.io.IOException;
import java.util.List;

public class CommonAPILoader {

    public static void main(String[] params) throws IOException, ClassNotFoundException {
        if (params[0].equals("-s")){
            //Data from param
            String delim = "\\s*,\\s*";
            String[] initData = params[1].split(delim);
            stanfordCore(initData);
        }

    }

    private static void stanfordCore(String[] data) throws IOException, ClassNotFoundException {
        LitTypeDetect ltd = new LitTypeDetect(data);

        for (String s : data){

            System.out.print(s + "; ");
        }
        System.out.println("");


        List<String> tags = ltd.getNerTags();
        for(String tag : tags){
            System.out.print(tag + "; ");
        }


    }


}


