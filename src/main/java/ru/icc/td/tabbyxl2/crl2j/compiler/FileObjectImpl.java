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

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileObjectImpl extends SimpleJavaFileObject {
    private ByteArrayOutputStream byteCode;

    private CharSequence source;

    public FileObjectImpl(String baseName, CharSequence source)
    {
        super(CharSequenceCompiler.toURI(baseName + ".java"), Kind.SOURCE);
        this.source = source;
    }

    public FileObjectImpl(String name, Kind kind)
    {
        super(CharSequenceCompiler.toURI(name), kind);
        this.source = null;
    }

    @Override
    public CharSequence getCharContent(final boolean ignoredEncodingErrors)
            throws UnsupportedOperationException
    {
        if(source == null)
            throw new UnsupportedOperationException();
        return source;
    }

    @Override
    public InputStream openInputStream()
    {
        return new ByteArrayInputStream(getByteCode());
    }

    public byte[] getByteCode() { return byteCode.toByteArray(); }

    @Override
    public OutputStream openOutputStream()
    {
        byteCode = new ByteArrayOutputStream();
        return byteCode;
    }
}
