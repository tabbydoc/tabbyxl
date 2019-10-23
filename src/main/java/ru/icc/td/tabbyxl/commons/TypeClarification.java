package ru.icc.td.tabbyxl.commons;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static edu.stanford.nlp.ie.NumberNormalizer.wordToNumber;

/*
Class for clarification numerical type
 */
public class TypeClarification {



    public static String getNumberType(String s){
        String result = "";
        Number value = getNumType(s);
        if (value instanceof Byte)
            result = "Byte";
        else if((value instanceof Integer) || (value instanceof Long))
            result = "Integer";
        else if (value instanceof Float)
            result = "Float";
        else if (value instanceof Double)
            result = "Double";
        else
            result = "Number";
        return result;


    }


    private static Number getNumType(String value){
        Pattern isWord = Pattern.compile("[a-zA-Z]+");
        Matcher mt = isWord.matcher(value);
        if( mt.find()){
            //Number in string format
            try{
                return wordToNumber(value);
            }
            catch (Exception e){
                return null;
            }
        }
        else{
            try {
                Number res = NumberFormat.getInstance().parse(value);
                return res;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


}
