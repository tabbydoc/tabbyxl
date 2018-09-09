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

import javax.tools.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharSequenceCompiler<T> {
    private static final String JAVA_EXTENSION = ".java";

    private ClassLoaderImpl classLoader;

    private JavaCompiler compiler;

    private List<String> options;

    private DiagnosticCollector<JavaFileObject> diagnostics;

    private FileManagerImpl fileManagerImpl;

    public CharSequenceCompiler(ClassLoader classLoader, Iterable<String> options)
    {
        compiler = ToolProvider.getSystemJavaCompiler();
        if(compiler == null)
        {
            throw new IllegalStateException();
        }

        this.classLoader = new ClassLoaderImpl(classLoader);
        diagnostics = new DiagnosticCollector<>();

        JavaFileManager standartFileManager = compiler.getStandardFileManager(diagnostics, null, null);

        fileManagerImpl = new FileManagerImpl(standartFileManager, this.classLoader);

        this.options = new ArrayList<>();
        if(options != null)
        {
            for(String option:options)
            {
                this.options.add(option);
            }
        }
    }

    public synchronized Class<T> compile(String qualifiedClassName,
                                         CharSequence source,
                                         DiagnosticCollector<JavaFileObject> diagnosticList,
                                         Class<?>... types) throws CharSequenceCompilerException, ClassCastException
    {
        if(diagnosticList != null) diagnostics = diagnosticList;
        else diagnostics = new DiagnosticCollector<JavaFileObject>();

        Map<String, CharSequence> classes = new HashMap<>(1);
        classes.put(qualifiedClassName, source);

        Map<String, Class<T>> compiled = compile(classes, diagnosticList);
        Class<T> newClass = compiled.get(qualifiedClassName);
        return castable(newClass, types);
    }

    private synchronized Map<String, Class<T>> compile(Map<String, CharSequence> classes,
                                                      DiagnosticCollector<JavaFileObject> diagnosticList)
            throws CharSequenceCompilerException
    {
        List<JavaFileObject> sources = new ArrayList<>();
        for(Map.Entry<String, CharSequence> entry : classes.entrySet())
        {
            String fullClassName = entry.getKey();
            CharSequence javaSource = entry.getValue();
            if(javaSource != null)
            {
                int dotPos = fullClassName.lastIndexOf('.');
                String className = dotPos == -1 ? fullClassName : fullClassName.substring(dotPos+1);
                String packageName = dotPos == -1 ? "" : fullClassName.substring(0, dotPos);
                FileObjectImpl source = new FileObjectImpl(className, javaSource);
                sources.add(source);
                fileManagerImpl.putFileForInput(StandardLocation.SOURCE_PATH, packageName, className + JAVA_EXTENSION, source);
            }
        }

        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManagerImpl, diagnostics, options, null, sources);
        Boolean res = task.call();

        if(res == null || !res.booleanValue())
        {
            throw new CharSequenceCompilerException("Compilation failed.", classes.keySet(), diagnostics);
        }
        try
        {
            Map<String, Class<T>> compiled = new HashMap<>();
            for(String className:classes.keySet())
            {
                Class<T> newClass = loadClass(className);
                compiled.put(className, newClass);
            }
            return compiled;
        } catch (ClassNotFoundException e)
        {
            throw new CharSequenceCompilerException(classes.keySet(), e, diagnostics);
        } catch (IllegalArgumentException e)
        {
            throw new CharSequenceCompilerException(classes.keySet(), e, diagnostics);
        } catch (SecurityException e)
        {
            throw new CharSequenceCompilerException(classes.keySet(), e, diagnostics);
        }
    }

    public static URI toURI(String name)
    {
        try
        {
            return URI.create(name);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public Class<T> loadClass(String className) throws ClassNotFoundException
    {
        return (Class<T>) classLoader.loadClass(className);
    }

    private Class<T> castable(Class<T> newClass, Class<?>... types) throws ClassCastException
    {
        for(Class<?> type : types)
            if(!type.isAssignableFrom(newClass)) throw new ClassCastException(type.getName());
        return newClass;
    }

    public ClassLoader getClassLoader() { return fileManagerImpl.getClassLoader(); }
}
