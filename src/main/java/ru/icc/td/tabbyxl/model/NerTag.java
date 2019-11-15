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

package ru.icc.td.tabbyxl.model;

public enum NerTag {
    // 12 entity classes provided by Stanford NLP for English, by default

    PERSON, LOCATION, ORGANIZATION, MISC, // Named entity classes
    MONEY, NUMBER, ORDINAL, PERCENT, // Numerical entity classes
    DATE, TIME, DURATION, SET, // Temporal entity classes

    // Additional entity classes provided by Stanford NLP for English

    EMAIL, URL, CITY, STATE_OR_PROVINCE, COUNTRY, NATIONALITY, RELIGION, TITLE, IDEOLOGY, CRIMINAL_CHARGE, CAUSE_OF_DEATH,

    // A class of named entities for all rest cases

    NONE;
}