package ru.icc.td.tabbyxl.crl2j;

import ru.icc.td.tabbyxl.crl2j.rulemodel.Condition;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public class Translator {

    private HashMap<String, String> variables = new HashMap<>();
    private List<Class> classes = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();

    public Translator(List<Condition> conditions, List<String> imports) {

        for (Condition condition: conditions) {
            variables.put(condition.getIdentifier(), condition.getDataType().toString());
        }

        for (String importItem: imports){

            String pack = importItem
                    .replace("import ", "")
                    .replace(".*", "")
                    .replace(";", "");

            classes.addAll(getClasses(pack));
        }

        for (Class cClass: classes) {
            fields.addAll(Arrays.asList(cClass.getDeclaredFields()));
        }
    }

    private List<Class> getClasses(String packageName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;

        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = null;

        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            try {
                classes.addAll(findClasses(directory, packageName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {

        List<Class> classes = new ArrayList<>();

        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length()  - 6)));
            }
        }
        return classes;
    }

    public String translateExpressions(List<String> expressions, String variable) {

        StringBuilder code = new StringBuilder();

        for ( int i = 0; i < expressions.size(); i ++ ) {

            String expression = expressions.get(i);
            boolean fieldFounded = false;
            String methodName = "";

            for (Field field: fields) {

                if (field.getName().equals(expression)) {

                    fieldFounded = true;
                    String fieldType = field.getType().getName();

                    if ( !fieldType.equals("boolean")) {
                        methodName = String.format("get%s%s", expression.substring(0,1).toUpperCase(), expression.substring(1, expression.length()));
                    } else {
                        methodName = String.format("is%s%s", expression.substring(0,1).toUpperCase(), expression.substring(1, expression.length()));
                    }

                    break;
                }
            }

            if (fieldFounded) {
                if (i<2) {
                    code.append(variable).append(".").append(methodName);
                } else {
                    if( !expressions.get(i-1).equals(".") ) {
                        code.append(variable).append(".").append(methodName);
                    }
                    else
                    {
                        code.append(methodName);
                    }
                }

                if( i > expressions.size()-3) {
                    code.append("()");
                } else {
                    if(expressions.get(i+1).equals("[") && expressions.get(i+3).equals("]")) {
                        code.append("(").append(expressions.get(i + 2)).append(")");
                        i=i+3;
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
