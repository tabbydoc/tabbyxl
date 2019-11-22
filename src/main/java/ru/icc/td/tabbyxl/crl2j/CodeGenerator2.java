/*
 * Copyright 2018-19 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.icc.td.tabbyxl.crl2j;

import ru.icc.td.tabbyxl.crl2j.rulemodel.*;
import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;
import ru.icc.td.tabbyxl.model.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;

final class CodeGenerator2 {

    private static final String newLine = System.lineSeparator();

    private static final List<Class> classes = new ArrayList<>();
    private static final List<Field> fields = new ArrayList<>();

    static {
        classes.add(CCell.class);
        classes.add(COwned.class);
        classes.add(CItem.class);
        classes.add(CEntry.class);
        classes.add(CLabel.class);
        classes.add(CCategory.class);

        // TODO Add here all classes we need to use (Maybe the style classes such as CStyle, CFont?)

        for (Class c : classes)
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
    }

    private String packageName;
    private Ruleset ruleset;

    CodeGenerator2(String packageName, Ruleset ruleset) {
        this.packageName = packageName;
        this.ruleset = ruleset;
    }

    // TODO Remove this temporal method if this CodeGenerator will become trusted
    List<String> fetchSourceCode() {
        List<String> sourceCode = new ArrayList<>();

        List<JavaFile> javaFiles = generateJavaFiles();
        //System.out.println();
        for (JavaFile javaFile : javaFiles) {
            //System.out.println(StringUtils.repeat("~", 140));
            //System.out.println(javaFile.toString());
            //System.out.println(StringUtils.repeat("~", 140));
            sourceCode.add(javaFile.toString());
        }
        //System.out.println();

        return sourceCode;
    }

    List<JavaFile> generateJavaFiles() {
        List<Rule> rules = ruleset.getRules();

        if (rules.isEmpty()) return null;

        List<JavaFile> sourceCode = new ArrayList<>();

        for (Rule rule : rules) {
            JavaFile ruleClassCode = new ForRule(rule).createJavaFile();
            sourceCode.add(ruleClassCode);
        }

        return sourceCode;
    }

    private final class ForRule {
        final String[] importStatements;
        final Rule rule;

        private List<CodeBlock> codeBlocks = new ArrayList<>();

        ForRule(Rule rule) {
            this.rule = rule;

            List<String> importStatementList = ruleset.getImportStatements();
            importStatements = importStatementList.toArray(new String[0]);
        }

        JavaFile createJavaFile() {
            MethodSpec constructor = createConstructor();
            MethodSpec evalMethod = createEvalMethod();

            String className = "Rule" + rule.getId();

            TypeSpec typeSpec = TypeSpec
                    .classBuilder(className)
                    .addModifiers(Modifier.PUBLIC)
                    .superclass(RuleProgramPrototype.class)
                    .addMethod(constructor)
                    .addMethod(evalMethod)
                    .build();

            JavaFile.Builder builder = JavaFile
                    .builder(packageName, typeSpec)
                    .indent("    ")
                    .addStaticImport(TypeTag.class, "*")
                    .addStaticImport(NerTag.class, "*");

            // Add user-defined static imports

            addStaticImports(builder);

            JavaFile javaFile = builder.build();

            return javaFile;
        }

        void addStaticImports(JavaFile.Builder builder) {
            List<String> importStatements = ruleset.getImportStatements();

            if (importStatements.isEmpty()) return;

            final String regex = "import(\\s)+static(\\s)+(\\w+(\\.)?\\w+)+\\.((\\w)+|\\*)";
            final Pattern validator = Pattern.compile(regex);

            for (String importStatement : importStatements) {

                if (validator.matcher(importStatement).matches()) {
                    importStatement = importStatement.replaceFirst("import(\\s)+static(\\s)+", "");

                    int separatorIndex = importStatement.lastIndexOf('.');
                    String s = importStatement.substring(0, separatorIndex);
                    ClassName className = ClassName.bestGuess(s);
                    String imported = importStatement.substring(separatorIndex + 1, importStatement.length());

                    builder.addStaticImport(className, imported);
                }
            }
        }

        MethodSpec createConstructor() {

            return MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(CTable.class, "table")
                    .addStatement("super(table)")
                    .build();
        }

        MethodSpec createEvalMethod() {

            createCodeBlock(rule.getConditions().iterator(), rule.getActions().iterator());

            CodeBlock cb = CodeBlock.join(codeBlocks, "");

            return MethodSpec
                    .methodBuilder("eval")
                    .addAnnotation(Override.class)
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(cb)
                    .build();
        }

        void createCodeBlock(Iterator<Condition> conditions, Iterator<Action> actions) {

            final Condition currentCondition = conditions.next();

            CodeBlock statement;
            CodeBlock controlFlow;

            final Class type;
            final String varName = currentCondition.getIdentifier();
            final String iteratorName = varName.concat("Iterator");
            final String iteratorExpression;

            // Find the method to get the needed iterator

            switch (currentCondition.getDataType()) {
                case CCell:
                    iteratorExpression = "getTable().getCells()";
                    type = CCell.class;
                    break;
                case CLabel:
                    iteratorExpression = "getTable().getLabels()";
                    type = CLabel.class;
                    break;
                case CEntry:
                    iteratorExpression = "getTable().getEntries()";
                    type = CEntry.class;
                    break;
                case CCategory:
                    iteratorExpression = "getTable().getLocalCategoryBox().getCategories()";
                    type = CCategory.class;
                    break;
                default:
                    // TODO Throw an exception
                    iteratorExpression = "";
                    type = null;
                    break;
            }

            // Add initialization of the iterator variable

            statement = CodeBlock
                    .builder()
                    .addStatement("$T<$T> $N = $L", Iterator.class, type, iteratorName, iteratorExpression)
                    .build();

            codeBlocks.add(statement);

            // Generate code blocks for the case of for-all-condition

            if (currentCondition.getQuantifier() == Condition.Quantifier.FOR_ALL) {

                // Add while-block

                controlFlow = CodeBlock.builder().beginControlFlow("while ($N.hasNext())", iteratorName).build();
                codeBlocks.add(controlFlow);

                // Add a variable for iteration

                statement = CodeBlock.builder().addStatement("$T $N = $N.next()", type, varName, iteratorName).build();
                codeBlocks.add(statement);

                // Add if-block by using the constraints

                String allConstraints;
                List<Constraint> constraints = currentCondition.getConstraints();

                if (constraints.isEmpty())
                    allConstraints = Boolean.TRUE.toString();
                else
                    allConstraints = generateConstraintExpression(constraints, varName);

                controlFlow = CodeBlock.builder().beginControlFlow("if ($L)", allConstraints).build();
                codeBlocks.add(controlFlow);

                // Add assignments

                for (Assignment assignment : currentCondition.getAssignments()) {
                    String varAssignment = assignment.getIdentifier();
                    String exprAssignment = generateNormalizedExpression(assignment.getExpressions(), varName);

                    statement = CodeBlock
                            .builder()
                            .addStatement("String $N = String.valueOf($L)", varAssignment, exprAssignment)
                            .build();

                    codeBlocks.add(statement);
                }

                // Create either a nested code block or actions

                if (conditions.hasNext())
                    createCodeBlock(conditions, actions);
                else
                    createActions(actions);

                // Add finalization of if-block

                controlFlow = CodeBlock.builder().endControlFlow().build();
                codeBlocks.add(controlFlow);

                // Add finalization of while-block

                controlFlow = CodeBlock.builder().endControlFlow().build();
                codeBlocks.add(controlFlow);

            }

            // Generate code blocks for the case of not-exist-condition

            else if (currentCondition.getQuantifier() == Condition.Quantifier.NOT_EXIST) {

                final String flagName = "$flag" + currentCondition.getId();

                // Add initialization of the flag variable

                statement = CodeBlock.builder().addStatement("$T $N = $L", boolean.class, flagName, Boolean.TRUE).build();
                codeBlocks.add(statement);

                // Add while-block

                controlFlow = CodeBlock.builder().beginControlFlow("while ($N.hasNext())", iteratorName).build();
                codeBlocks.add(controlFlow);

                // Add a variable for iteration

                statement = CodeBlock.builder().addStatement("$T $N = $N.next()", type, varName, iteratorName).build();
                codeBlocks.add(statement);

                // Add if-block by using the constraints

                List<Constraint> constraints = currentCondition.getConstraints();
                String allConstraints;

                if (constraints.isEmpty())
                    allConstraints = "false";
                else
                    allConstraints = generateConstraintExpression(currentCondition.getConstraints(), varName);

                controlFlow = CodeBlock.builder().beginControlFlow("if ($L)", allConstraints).build();
                codeBlocks.add(controlFlow);

                // Add assignment of the flag variable

                statement = CodeBlock.builder().addStatement("$T $N = $L", boolean.class, flagName, Boolean.FALSE).build();
                codeBlocks.add(statement);

                // Add break

                statement = CodeBlock.builder().addStatement("break").build();
                codeBlocks.add(statement);

                // Add finalization of if-block

                controlFlow = CodeBlock.builder().endControlFlow().build();
                codeBlocks.add(controlFlow);

                // Add finalization of while-block

                controlFlow = CodeBlock.builder().endControlFlow().build();
                codeBlocks.add(controlFlow);

                // Add if-block by using the flag variable

                controlFlow = CodeBlock.builder().beginControlFlow("if ($N)", flagName).build();
                codeBlocks.add(controlFlow);

                // Create either a nested code block or actions

                if (conditions.hasNext())
                    createCodeBlock(conditions, actions);
                else
                    createActions(actions);

                // Add finalization of if-block

                controlFlow = CodeBlock.builder().endControlFlow().build();
                codeBlocks.add(controlFlow);
            }
        }

        String generateConstraintExpression(List<Constraint> constraints, String conditionVarName) {

            StringBuilder expression = new StringBuilder();
            List<String> expressions;

            if (constraints.size() == 1) {
                expressions = constraints.get(0).getExpressions();
                expression.append(generateNormalizedExpression(expressions, conditionVarName));
            }
            else if (constraints.size() > 1) {
                for (int i = 0; i < constraints.size(); i++) {
                    expressions = constraints.get(i).getExpressions();
                    expression
                            .append("(")
                            .append(generateNormalizedExpression(expressions, conditionVarName))
                            .append(")");

                    if (i < constraints.size() - 1) expression.append(" && ");
                }
            }

            return expression.toString();
        }

        void createActions(Iterator<Action> actions) {
            while (actions.hasNext()) {
                StringBuilder code = new StringBuilder();

                Action action = actions.next();

                if (action.getType().equals(Action.Type.update)) continue;

                List<Operand> operands = action.getOperands();

                code
                        .append(generateNormalizedExpression(operands.get(0).getExpressions(), ""))
                        .append(".")
                        .append(action.getType())
                        .append("(");

                if (operands.size() > 1) {
                    for (int i = 1; i < operands.size(); i++) {
                        code.append(generateNormalizedExpression(operands.get(i).getExpressions(), ""));
                        if (i < operands.size() - 1) code.append(", ");
                    }
                }

                code.append(")");

                CodeBlock statement = CodeBlock.builder().addStatement("$L", code.toString()).build();
                codeBlocks.add(statement);
            }
        }

        String generateNormalizedExpression(List<String> tokens, String variable) {

            StringBuilder expression = new StringBuilder();

            for (int i = 0; i < tokens.size(); i++) {

                String token = tokens.get(i);

                String methodName = "";
                boolean wasFoundMethod = false;

                for (Field field : fields) {

                    if (field.isEnumConstant()) continue;

                    if (field.getName().equals(token)) {
                        String capitalized = token.substring(0, 1).toUpperCase() + token.substring(1);
                        if (field.getType() == boolean.class)
                            methodName = "is" + capitalized;
                        else
                            methodName = "get" + capitalized;

                        wasFoundMethod = true;
                        break;
                    }
                }

                if (wasFoundMethod) {
                    if (i < 2) {
                        expression.append(variable).append(".").append(methodName);
                    } else {
                        if (!tokens.get(i - 1).equals("."))
                            expression.append(variable).append(".").append(methodName);
                        else
                            expression.append(methodName);
                    }

                    if (i > tokens.size() - 3) {
                        expression.append("()");
                    } else {
                        if (tokens.get(i + 1).equals("[") && tokens.get(i + 3).equals("]")) {
                            expression.append("(").append(tokens.get(i + 2)).append(")");
                            i = i + 3;
                        } else {
                            expression.append("()");
                        }
                    }
                } else {
                    expression.append(token);
                }
            }

            return expression.toString();
        }
    }

}
