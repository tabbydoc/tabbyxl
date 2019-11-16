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

package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.tree.Tree;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

// TODO Нужно объяснение этого кода: зачем этот класс?
public class AstPrinter {

    private final char FIRST_CHAR, MIDDLE_CHAR, LAST_CHAR;

    public AstPrinter() {
        // TODO Нужно объяснение этого кода: почему кодировка CP866, зачем эти 3 символа, может сделать их статическими?
        Charset charSet = Charset.forName("CP866");
        CharBuffer charBuff = charSet.decode(ByteBuffer.wrap(new byte[]{(byte) 0xB3, (byte) 0xC3, (byte) 0xC0}));
        FIRST_CHAR = charBuff.charAt(0);
        MIDDLE_CHAR = charBuff.charAt(1);
        LAST_CHAR = charBuff.charAt(2);
    }

    private String getSubTree(Tree node, String id, boolean root) {
        
        final String lineSeparator = System.lineSeparator();
        if (node == null) return "";
        StringBuilder result = new StringBuilder(id);
        StringBuilder identifier = new StringBuilder(id);
        
        if (!root) {
            if (node.getChildIndex() < node.getParent().getChildCount() - 1) {
                result.append(MIDDLE_CHAR).append(" ");
                identifier.append(FIRST_CHAR).append(" ");
            } else {
                result.append(LAST_CHAR).append(" ");
                identifier.append(" ");
            }
        }
        
        result.append(node.getText()).append(lineSeparator);
        
        for (int i = 0; i < node.getChildCount(); i ++) {
            result.append(getSubTree(node.getChild(i), identifier.toString(), false));
        }
        
        return result.toString();
    }

    private String advancedGetSubTree(Tree node) {
        return getSubTree(node, "", true);
    }

    // TODO Нужно объяснение этого кода: откуда возьмется аргумент "node" при вызове метода?
    public String trace(Tree node) {
        return advancedGetSubTree(node);
    }
}
