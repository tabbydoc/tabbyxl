/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@gmail.com) and Viacheslav V. Paramonov
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

package ru.icc.td.tabbyxl.preprocessing.headrecog;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.preprocessing.Preprocessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class HeadRecogPreprocessor implements Preprocessor {

    private File outputFile;
    private Workbook workbook;

    public HeadRecogPreprocessor(File outputFile) throws IOException {
        this.outputFile = outputFile;
        workbook = getWorkbook(outputFile);
    }


    private Workbook getWorkbook(File srcFile) throws IOException {
        Workbook workbook;
        FileInputStream fin = new FileInputStream(srcFile);
        workbook = new XSSFWorkbook(fin);
        return workbook;
    }

    @Override
    public void process(CTable table) {
        HeadRecogAlgorithms algo;

        algo = new HeadRecogAlgorithms(table, workbook);
        algo.analyze();
    }

    public void saveWorkbook() {
        String path = outputFile.getAbsolutePath();
        try {
            try (FileOutputStream out = new FileOutputStream(new File(path))) {
                workbook.write(out);
                System.out.println("All changes were written successfully");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
