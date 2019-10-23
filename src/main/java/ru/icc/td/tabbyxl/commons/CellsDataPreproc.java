package ru.icc.td.tabbyxl.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import ru.icc.td.tabbyxl.commons.LitType;

public class CellsDataPreproc {
    String delim = "";
    List<Object[]> data = new ArrayList<Object[]>();

    public CellsDataPreproc(String initStr){
         new CellsDataPreproc(initStr, "");
    }
    public  CellsDataPreproc(String initStr, String delim){
        String[] initData;
        this.delim = delim;
        initStr = initStr.trim();
        if ( !delim.isEmpty() )
            initData = initStr.split(Pattern.quote(delim));
        else
            initData = new String[]{initStr};
        strModif(initData);
        for (String s: initData){
            LitType litType = new LitType(s);
            Object[] res = {litType.getEntry(), litType.getTag(), litType.subType ,litType.getLemmas()};
            data.add(res);
        }
    }
    private void strModif(String[] initData){
        int l = initData.length;
        int il;
        String item;
        String[] itemComp;
        for (int i= 0; i< l; i++){
            item = initData[i];
            itemComp = item.split(Pattern.quote(" "));
            for (int j = 0; j < itemComp.length; j ++){
                il = itemComp[j].length();
                if (il == 2)
                    itemComp[j] = itemComp[j].toUpperCase();
                else if(il > 2)
                    itemComp[j] = itemComp[j].substring(0,1).toUpperCase() + itemComp[j].substring(1);
            }
            initData[i] = String.join(" ", itemComp);
        }
    }

    public List<Object[]> getLit(){
        return data;
    }

    public  String getNerList(int id){
        List<String> res = new ArrayList<>();
        if ((id < 0) && (id > 2)) return "";
        for (Object[] o: data){
            if (id == 0)
                res.add(String.valueOf(o[id]));
            else
                if (o[id]!= null)
                    res.add(o[id].toString());
                else
                    res.add("");
        }
        if (delim.isEmpty())
            return res.toString();
        else
            return String.join(delim , res);

    }
}
