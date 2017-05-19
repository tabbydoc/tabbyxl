/*
 * Copyright 2015 Alexey O. Shigarov (shigarov@icc.ru)
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

package ru.icc.cells.ssdc.util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import org.drools.compiler.compiler.DrlParser;

/**
 * Created by Alexey Shigarov on 24.01.2015.
 */

public final class CRL2DRLConverter
{
    private static final String DSL_PATH = "./crl/crl.dsl";

    public static void main( String[] args )
    {
        CRL2DRLConverter converter = new CRL2DRLConverter();
        try
        {
            System.out.println(converter.expandDRL(args[0]));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String expandDRL(String drlFilePath) throws Exception
    {
        Reader dslReader = new FileReader( DSL_PATH );
        String drl = new Scanner( new File( drlFilePath ), "UTF-8" ).useDelimiter( "\\A" ).next();
        DrlParser parser = new DrlParser();
        return parser.getExpandedDRL( drl, dslReader );
    }
}