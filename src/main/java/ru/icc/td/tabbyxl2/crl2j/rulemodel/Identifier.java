/*
 * Copyright 2018 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl2.crl2j.rulemodel;

import ru.icc.td.tabbyxl2.crl2j.FieldAliases;

import java.util.ArrayList;
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

        Map<String, String> aliases = new FieldAliases().getAliases();
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
