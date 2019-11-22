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

import com.squareup.javapoet.ClassName;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.lang3.tuple.Pair;
import ru.icc.td.tabbyxl.crl2j.rulemodel.*;

import java.util.ArrayList;
import java.util.List;

final class Ruleset {

    private List<String> importStatements = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();

    public List<String> getImportStatements() {
        return importStatements;
    }

    public List<Rule> getRules() {
        return rules;
    }

    private Ruleset() {}

    public static Ruleset createInstance(Tree ast) {

        // TODO Check a param (AST-tree)

        Ruleset ruleset = new Ruleset();
        ruleset.importStatements.addAll(Interpreter.createImports(ast));
        ruleset.rules.addAll(Interpreter.createRules(ast));

        return ruleset;
    }
}
