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

package ru.icc.td.tabbyxl.crl2j.compiler;

import javax.tools.*;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.tools.ForwardingJavaFileManager;

final class FileManagerImpl extends ForwardingJavaFileManager<JavaFileManager> {
    private ClassLoaderImpl classLoader;

    private Map<URI, JavaFileObject> fileObjects = new HashMap<>();

    public FileManagerImpl(JavaFileManager fileManager, ClassLoaderImpl classLoader)
    {
        super(fileManager);
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() { return classLoader; }

    @Override
    public FileObject getFileForInput(Location location, String packageName, String name) throws IOException
    {
        FileObject object = fileObjects.get(uri(location, packageName, name));
        if(object != null) return object;
        return super.getFileForInput(location, packageName, name);
    }

    public void putFileForInput(StandardLocation location, String packageName, String name, JavaFileObject fileObject)
    {
        fileObjects.put(uri(location, packageName, name), fileObject);
    }

    private URI uri(Location location, String packageName, String name)
    {
        return CharSequenceCompiler.toURI(location.getName() + '/' + packageName + '/' + name);
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String fileName, JavaFileObject.Kind kind, FileObject outputFile)
            throws IOException
    {
        JavaFileObject file = new FileObjectImpl(fileName, kind);
        classLoader.add(fileName, file);
        return file;
    }

    @Override
    public ClassLoader getClassLoader(JavaFileManager.Location location) { return classLoader; }

    @Override
    public String inferBinaryName(Location location, JavaFileObject file)
    {
        String res;
        if(file instanceof FileObjectImpl) res = file.getName();
        else res = super.inferBinaryName(location, file);
        return res;
    }

    @Override
    public Iterable<JavaFileObject> list(Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse)
            throws IOException
    {
        Iterable<JavaFileObject> res = super.list(location, packageName, kinds, recurse);
        ArrayList<JavaFileObject> files = new ArrayList<>();
        if(location == StandardLocation.CLASS_PATH && kinds.contains(JavaFileObject.Kind.CLASS))
        {
            for(JavaFileObject file : fileObjects.values())
            {
                if(file.getKind() == JavaFileObject.Kind.CLASS && file.getName().startsWith(packageName))
                    files.add(file);
            }
            files.addAll(classLoader.files());
        }
        else if(location == StandardLocation.SOURCE_PATH && kinds.contains(JavaFileObject.Kind.SOURCE))
        {
            for(JavaFileObject file : fileObjects.values())
            {
                if(file.getKind() == JavaFileObject.Kind.SOURCE && file.getName().startsWith(packageName))
                    files.add(file);
            }
        }
        for(JavaFileObject file : res) files.add(file);
        return files;
    }
}
