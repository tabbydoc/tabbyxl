package ru.icc.cells.ssdc.writers;

import ru.icc.cells.ssdc.model.CTable;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alexey Shigarov on 28.06.2016.
 */
public abstract class Writer
{
    protected File outputFile;

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public abstract void write(CTable table) throws IOException;

    public Writer(File outputFile)
    {
        setOutputFile(outputFile);
    }
}
