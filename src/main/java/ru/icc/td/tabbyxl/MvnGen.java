/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@gmail.com) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl;

import org.antlr.runtime.RecognitionException;
import ru.icc.td.tabbyxl.crl2j.mvngen.MvnProjectGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class MvnGen {

    public static void main(String[] args) {
        try {

            File crlFile = new File(args[0]);
            Path resultDirectory = Paths.get(args[1]);
            MvnProjectGenerator.generate(crlFile, resultDirectory);

        } catch (IOException | RecognitionException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
