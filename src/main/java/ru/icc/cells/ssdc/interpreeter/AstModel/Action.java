package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.ArrayList;
import java.util.List;

public class Action {

    private String name;
    public String getName() {
        return name;
    }

    private List<String> params = new ArrayList<>();

    public List<String> getParams() {
        return params;
    }

    public void addParam(String param) {
        this.params.add(param);
    }

    public Action(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[ ").append(name).append(" ( ");
        for(int i=0; i<params.size(); i++) {
            res.append(params.get(i));
            if(i<params.size()-1) res.append(", ");
        }
        res.append(" ) ]");
        return res.toString();
    }
}
