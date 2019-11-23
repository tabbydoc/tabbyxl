/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@icc.ru)
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

import java.util.regex.Pattern;

final class StaticImportDescriptor {
    private String packageName;
    private String className;
    private String memberName;

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getMemberName() {
        return memberName;
    }

    private StaticImportDescriptor() {
    }

    private static final Pattern validator;

    static {
        String regex = "import(\\s)+static(\\s)+(\\w+(\\.)?\\w+)+\\.((\\w)+|\\*)";
        validator = Pattern.compile(regex);
    }

    static StaticImportDescriptor parseStaticImportStatement(final String statement) {
        if (!validator.matcher(statement).matches()) return null;

        StaticImportDescriptor desc = new StaticImportDescriptor();

        String imported = statement.replaceFirst("import(\\s)+static(\\s)+", "");

        int posOfLastDot = imported.lastIndexOf('.');
        desc.memberName = imported.substring(posOfLastDot + 1, imported.length());

        imported = imported.substring(0, posOfLastDot);
        posOfLastDot = imported.lastIndexOf('.');
        desc.className = imported.substring(posOfLastDot + 1, imported.length());

        desc.packageName = imported.substring(0, posOfLastDot);

        return desc;
    }
}
