package ru.icc.td.tabbyxl.crl2j;

import ru.icc.td.tabbyxl.crl2j.rulemodel.Condition;
import ru.icc.td.tabbyxl.model.*;

import java.lang.reflect.Field;
import java.util.*;

public class Translator {

    private final HashMap<String, String> variables = new HashMap<>();
    private final List<Class> classes = new ArrayList<>();
    private final List<Field> fields = new ArrayList<>();

    public Translator(List<Condition> conditions) {

        for (Condition condition: conditions) {
            variables.put(condition.getIdentifier(), condition.getDataType().toString());
        }

        // TODO Добавить необходимые классы в список classes
        classes.add(CCell.class);
        classes.add(CEntry.class);
        classes.add(CLabel.class);
        classes.add(CCategory.class);

        for (Class c: classes) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
    }

    public String translateExpressions(List<String> expressions, String variable) {

        StringBuilder code = new StringBuilder();

        for (int i = 0; i < expressions.size(); i ++) {

            String expression = expressions.get(i);
            boolean fieldFounded = false;
            String methodName = "";

            for (Field field: fields) {

                if (field.isEnumConstant()) continue;

                if (field.getName().equals(expression)) {

                    fieldFounded = true;
                    String fieldType = field.getType().getName();

                    String e1 = expression.substring(0, 1).toUpperCase();
                    String e2 = expression.substring(1, expression.length());

                    if ( !fieldType.equals("boolean"))
                        methodName = String.format("get%s%s", e1, e2);
                    else
                        methodName = String.format("is%s%s", e1, e2);

                    break;
                }
            }

            if (fieldFounded) {
                if (i < 2) {
                    code.append(variable).append(".").append(methodName);
                } else {
                    if(!expressions.get(i - 1).equals("."))
                        code.append(variable).append(".").append(methodName);
                    else
                        code.append(methodName);
                }

                if( i > expressions.size() - 3) {
                    code.append("()");
                } else {
                    if(expressions.get(i + 1).equals("[") && expressions.get(i + 3).equals("]")) {
                        code.append("(").append(expressions.get(i + 2)).append(")");
                        i = i + 3;
                    } else {
                        code.append("()");
                    }
                }
            } else {
                code.append(expression);
            }

        }

        return code.toString();
    }

    public HashMap<String, String> getVariables() {
        return variables;
    }
}
