package ru.icc.cells.ssdc.crl2j.compiler;

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
