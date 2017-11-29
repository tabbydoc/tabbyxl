package ru.icc.cells.ssdc.interpreeter.compiler;

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
