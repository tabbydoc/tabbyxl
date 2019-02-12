package ru.icc.td.tabbyxl.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Class for clarification numerical type
 */
public class NumTypeClarification {
    public static boolean isInteger(String value){
        boolean res;
        value = value.trim();
        Pattern isInteger = Pattern.compile("\\d+(\\s*\\d+)*");
        Matcher m = isInteger.matcher(value);
        res = m.matches();
        return true;
    }

    private boolean digOrLit(String value){
        /*
        Function for determination does numerical in digits or literal presentation.
        Return true if digits and false if literal
         */
        return true;
    }
}
