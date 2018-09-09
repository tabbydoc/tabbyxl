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

package ru.icc.td.tabbyxl2.crl2j.compiler;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CharSequenceCompilerException extends Exception {
    private static final long serialVersion = 1L;

    private Set<String> classNames;

    transient private DiagnosticCollector<JavaFileObject> diagnostics;

    public CharSequenceCompilerException(String message, Set<String> classNames, Throwable cause, DiagnosticCollector<JavaFileObject> diagnostics)
    {
        super(message, cause);
        setClassNames(classNames);
        setDiagnostics(diagnostics);
    }

    public CharSequenceCompilerException(String message, Set<String> classNames, DiagnosticCollector<JavaFileObject> diagnostics)
    {
        super(message);
        setClassNames(classNames);
        setDiagnostics(diagnostics);
    }

    public CharSequenceCompilerException(Set<String> classNames, Throwable cause, DiagnosticCollector<JavaFileObject> diagnostics)
    {
        super(cause);
        setClassNames(classNames);
        setDiagnostics(diagnostics);
    }

    private void setClassNames(Set<String> classNames)
    {
        this.classNames = new HashSet<String>(classNames);
    }

    private void setDiagnostics(DiagnosticCollector<JavaFileObject> diagnostics)
    {
        this.diagnostics = diagnostics;
    }

    public DiagnosticCollector<JavaFileObject> getDiagnostics() {
        return diagnostics;
    }

    public Collection<String> getClassNames() { return Collections.unmodifiableSet(classNames); }
}
