package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public final class Expression {

    private List<String> tokens = new ArrayList<>();

    public void addToken(String token) {
        tokens.add(token);
    }

    public List<String> getTokens() {
        return tokens;
    }

}
