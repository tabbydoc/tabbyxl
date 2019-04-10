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

package ru.icc.td.tabbyxl.crl2j.rulemodelold;

public class Variable {

    private String identifier;
    private String type;

    public Variable(String type, String identifier) {

        this.identifier = identifier;

        switch (type)
        {
            case "cell": this.type = "CCell"; break;
            case "entry": this.type = "CEntry"; break;
            case "category": this.type = "CCategory"; break;
            case "label": this.type = "CLabel"; break;
            default: this.type = type; break;
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }
}
