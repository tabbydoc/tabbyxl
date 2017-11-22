package ru.icc.cells.ssdc.interpreeter;


import java.lang.ClassLoader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RuleClassLoader extends ClassLoader {

    private String classText;

    public RuleClassLoader(String classText, ClassLoader parent)
    {
        super(parent);
        this.classText = classText;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {

            // получаем байт-код из строк класса
        try {
            byte b[] = fetchClassFromString();
            return defineClass(className, b, 0, b.length);
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] fetchClassFromString() throws IOException
    {
            InputStream in = new ByteArrayInputStream(classText.getBytes());
            long length = classText.length();
            if (length > Integer.MAX_VALUE) {
                // File is too large
                System.out.println("File is too large");
                return null;
            }

            byte bytes[] = new byte[(int)classText.length()];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = in.read(bytes, offset, bytes.length-offset)) >= 0)
            {
                offset += numRead;
            }

            if (offset < bytes.length)
            {
                throw new IOException("Could not completely read text of class");
            }

            in.close();
            return bytes;
    }
}
