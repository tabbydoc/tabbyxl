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

import javax.tools.JavaFileObject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ClassLoaderImpl extends ClassLoader {
    private Map<String, JavaFileObject> classes = new HashMap<>();

    public ClassLoaderImpl(ClassLoader parentClassLoader)
    {
        super(parentClassLoader);
    }

    public Collection<JavaFileObject> files()
    {
        return Collections.unmodifiableCollection(classes.values());
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException
    {
        FileObjectImpl file = (FileObjectImpl) classes.get(className);
        if(file != null)
        {
            byte[] bytes = ((FileObjectImpl)file).getByteCode();
            return defineClass(className, bytes, 0, bytes.length);
        }

        try
        {
            Class<?> c = Class.forName(className);
            return c;
        }catch ( ClassNotFoundException e ) {}

        return super.findClass(className);
    }

    public void add(String className, JavaFileObject file)
    {
        classes.put(className, file);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        return super.loadClass(name, resolve);
    }

    @Override
    public InputStream getResourceAsStream(String name)
    {
        if(name.endsWith(".class"))
        {
            String className = name.substring(0, name.length() - ".class".length()).replace('/','.');
            FileObjectImpl file = (FileObjectImpl) classes.get(className);
            if(file != null)
                return new ByteArrayInputStream(file.getByteCode());
        }
        return super.getResourceAsStream(name);
    }
}
