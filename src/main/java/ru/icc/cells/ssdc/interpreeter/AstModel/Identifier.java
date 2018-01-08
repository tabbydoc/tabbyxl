package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.interpreeter.AstModelInterpreeter;
import ru.icc.cells.ssdc.interpreeter.FieldAlias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Identifier {

    private List<String> parts = new ArrayList<>();

    public Identifier() {}

    public void addPart(String part) {
        parts.add(part);
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        for(String part:parts)
            builder.append(part);

        return builder.toString();
    }

    public String getNormalForm() {

        Map<String, String> aliases = new FieldAlias().getAliases();
        StringBuilder code = new StringBuilder();
        String digits = "0123456789";

        for(int i=0; i<parts.size(); i++) {
            if(aliases.containsKey(parts.get(i))) {
                code.append(aliases.get(parts.get(i))).append("(");
                if(i<parts.size()-1 && isDigit(parts.get(i+1))) {
                    code.append(parts.get(i+1));
                    i++;
                }
                code.append(")");
            }
            else {
                code.append(parts.get(i));
            }
        }

        return code.toString();
    }

    private boolean isDigit(String string) {

        String digits = "0123456789";

        for(char c:string.toCharArray()) {
            if(digits.indexOf(c) == -1) return false;
        }
        return true;
    }
}
