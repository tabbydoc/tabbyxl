/*
 * Copyright 2015-18 Alexey O. Shigarov (shigarov@gmail.com)
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

package ru.icc.td.tabbyxl2.util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import org.drools.compiler.compiler.DrlParser;

public final class CRL2DRLMapper {
    public static void main(String[] args) {
        CRL2DRLMapper mapper = new CRL2DRLMapper();
        try {
            String crlRulesetPath = args[0];
            String dslPath = args[1];
            String drlRuleset = mapper.expandDRL(crlRulesetPath, dslPath);
            System.out.println(drlRuleset);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String expandDRL(String crlRulesetPath, String dslPath) throws Exception {
        Reader dslReader = new FileReader(dslPath);
        String drl = new Scanner(new File( crlRulesetPath), "UTF-8").useDelimiter("\\A").next();
        DrlParser parser = new DrlParser();
        return parser.getExpandedDRL(drl, dslReader);
    }
}