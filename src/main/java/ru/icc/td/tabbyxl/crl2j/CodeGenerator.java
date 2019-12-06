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
import ru.icc.td.tabbyxl.model.*;

import java.lang.reflect.Field;
import java.util.*;

import com.squareup.javapoet.*;
import javax.lang.model.element.Modifier;
import static java.lang.reflect.Modifier.isStatic;

final class CodeGenerator {
    private static final List<Field> fields = new ArrayList<>();
    private static final List<String> binaryOperators;

    static {
        List<Class> classes = new ArrayList<>();

        classes.add(CCell.class);
        classes.add(COwned.class);
        classes.add(CItem.class);
        classes.add(CEntry.class);
        classes.add(CLabel.class);
        classes.add(CCategory.class);

        // TODO Add here all classes we need to use (Maybe the style classes such as CStyle, CFont?)

        for (Class clazz : classes) {
            for (Field field : clazz.getDeclaredFields()) {
                if (isStatic(field.getModifiers())) continue;
                if (field.isEnumConstant()) continue;
                fields.add(field);
            }
        }

        binaryOperators = Arrays.asList(
                "=",
                "+", "-", "*", "/", "%",
                "==", "!=", ">", ">=", "<", "<=",
                "&&", "||",
                "instanceof",
                "<<", ">>", ">>>", "&", "^", "|"
        );
    }

    private String packageName;
    private Ruleset ruleset;

    CodeGenerator(String packageName, Ruleset ruleset) {
        this.packageName = packageName;
        this.ruleset = ruleset;
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
        final Rule rule;

        private List<CodeBlock> codeBlocks = new ArrayList<>();

        ForRule(Rule rule) {
            this.rule = rule;
        }

        JavaFile createJavaFile() {
            MethodSpec method = createMethod();

            String className = TableConsumer.class.getSimpleName() + rule.getId();

            TypeSpec typeSpec = TypeSpec
                    .classBuilder(className)
                    .addModifiers(Modifier.PUBLIC)
                    .addSuperinterface(TableConsumer.class)
                    .addMethod(method)
                    .build();

            JavaFile.Builder builder = JavaFile
                    .builder(packageName, typeSpec)
                    .indent("    ")
                    .skipJavaLangImports(true)
                    .addFileComment("This source code was generated by TabbyXL from Rule$L", rule.getId())
                    .addStaticImport(TypeTag.class, "*")
                    .addStaticImport(NerTag.class, "*");

            // Add user-defined static imports

            addStaticImports(builder);

            JavaFile javaFile = builder.build();

            return javaFile;
        }

        // TODO Test this method
        void addStaticImports(JavaFile.Builder builder) {
            List<StaticImportDescriptor> staticImportDescriptors = ruleset.getStaticImportDescriptors();

            if (staticImportDescriptors.isEmpty()) return;

            for (StaticImportDescriptor importDesc : staticImportDescriptors) {
                ClassName className = ClassName.get(importDesc.getPackageName(), importDesc.getClassName());
                builder.addStaticImport(className, importDesc.getMemberName());
            }
        }

        MethodSpec createMethod() {

            createCodeBlock(rule.getConditions().iterator(), rule.getActions().iterator());

            CodeBlock cb = CodeBlock.join(codeBlocks, "");

            return MethodSpec
                    .methodBuilder("accept")
                    .addAnnotation(Override.class)
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(CTable.class, "table")
                    .addCode(cb)
                    .build();
        }

        String generateIteratorExpression(Class type) {
            if (type == CCell.class)
                return "table.getCells()";

            if (type == CLabel.class)
                return "table.getLabels()";

            if (type == CEntry.class)
                return "table.getEntries()";

            if (type == CCategory.class)
                return "table.getLocalCategoryBox().getCategories()";

            // TODO Throw an exception
            return null;
        }

        void createCodeBlock(Iterator<Condition> conditions, Iterator<Action> actions) {

            // Go to the next condition

            final Condition currentCondition = conditions.next();

            CodeBlock statement;
            CodeBlock controlFlow;

            // Collect data of the condition

            final Class type = currentCondition.getQueriedType();
            final String varName = currentCondition.getIdentifier();
            final String iteratorName = varName.concat("Iterator");
            final String iteratorExpression = generateIteratorExpression(type);

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
                List<Expression> constraints = currentCondition.getConstraints();

                if (constraints.isEmpty())
                    allConstraints = Boolean.TRUE.toString();
                else
                    allConstraints = collectConstraintsOfCondition(constraints, varName);

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
                    createActionStatements(actions);

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

                List<Expression> constraints = currentCondition.getConstraints();
                String allConstraints;

                if (constraints.isEmpty())
                    allConstraints = Boolean.FALSE.toString();
                else
                    allConstraints = collectConstraintsOfCondition(constraints, varName);

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
                    createActionStatements(actions);

                // Add finalization of if-block

                controlFlow = CodeBlock.builder().endControlFlow().build();
                codeBlocks.add(controlFlow);
            }
        }

        String collectConstraintsOfCondition(List<Expression> constraints, String conditionVarName) {

            StringBuilder allConstraints = new StringBuilder();
            List<String> expressions;

            if (constraints.size() == 1) {
                expressions = constraints.get(0).getTokens();
                allConstraints.append(generateNormalizedExpression(expressions, conditionVarName));
            } else if (constraints.size() > 1) {
                for (int i = 0; i < constraints.size(); i++) {
                    expressions = constraints.get(i).getTokens();
                    String normalizedExpression = generateNormalizedExpression(expressions, conditionVarName);

                    allConstraints
                            .append("(")
                            .append(normalizedExpression)
                            .append(")");

                    if (i < constraints.size() - 1) allConstraints.append(" && ");
                }
            }

            return allConstraints.toString();
        }

        void createActionStatements(Iterator<Action> actions) {
            while (actions.hasNext()) {
                StringBuilder code = new StringBuilder();

                Action action = actions.next();

                List<Expression> operands = action.getOperands();
                String caller = generateNormalizedExpression(operands.get(0).getTokens(), "");

                code
                        .append(caller)
                        .append(".")
                        .append(action.getMethodName())
                        .append("(");

                if (operands.size() > 1) {
                    for (int i = 1; i < operands.size(); i++) {
                        String argument = generateNormalizedExpression(operands.get(i).getTokens(), "");
                        code.append(argument);
                        if (i < operands.size() - 1) code.append(", ");
                    }
                }

                code.append(")");

                CodeBlock statement = CodeBlock.builder().addStatement("$L", code.toString()).build();
                codeBlocks.add(statement);

                // TODO Test cases with the use of "split" and "merge" actions
                // When the current action is "split" or "merge"
                // then it is needed to re-start the all iterators of cells

                if (action.getMethodName().equals("split") || action.getMethodName().equals("merge")) {
                    final List<String> varNames = new ArrayList<>();
                    for (Condition condition : rule.getConditions()) {
                        Class queriedType = condition.getQueriedType();

                        if (queriedType == CCell.class) {
                            String varName = condition.getIdentifier();
                            varNames.add(varName);

                            String iteratorName = varName.concat("Iterator");
                            String iteratorExpression = "table.getCells()";

                            statement = CodeBlock
                                    .builder()
                                    .addStatement("$N = $L", iteratorName, iteratorExpression)
                                    .build();

                            codeBlocks.add(statement);
                        }
                    }
                }
            }
        }

        String generateNormalizedExpression(List<String> tokens, String variable) {

            StringBuilder expression = new StringBuilder();

            for (int i = 0; i < tokens.size(); i++) {

                String token = tokens.get(i);

                String methodName = "";
                boolean wasFoundMethod = false;

                for (Field field : fields) {
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
                } else if (binaryOperators.contains(token)) {
                    expression.append(" ").append(token).append(" ");
                } else {
                    expression.append(token);
                }
            }

            return expression.toString();
        }
    }

}
