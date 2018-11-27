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

package ru.icc.td.tabbyxl.model;

import java.util.HashMap;
import java.util.Map;

public final class StatisticsManager
{
    private static final StatisticsManager INSTANCE = new StatisticsManager();

    private int numOfTables;
    private int numOfCells;
    private int numOfNotEmptyCells;
    private int numOfEntries;
    private int numOfLabels;

    private int numOfLL;
    private int numOfEL;
    private int numOfCL;

    private int numOfCategories;
    private int numOfLabelGroups;

    private final Map<CTable, Statistics> map = new HashMap<CTable, Statistics>();

    public Statistics collect( CTable table )
    {
        Statistics statistics = new Statistics();
        statistics.collect( table );
        map.put( table, statistics );
        numOfTables ++;

        // Incrementing statistics using the table
        numOfCells += statistics.numOfCells;
        numOfNotEmptyCells += statistics.numOfNotEmptyCells;
        numOfEntries += statistics.numOfEntries;
        numOfLabels += statistics.numOfLabels;

        numOfLL += statistics.numOfLL;
        numOfEL += statistics.numOfEL;
        numOfCL += statistics.numOfCL;

        numOfCategories += statistics.numOfCategories;
        numOfLabelGroups += statistics.numOfLabelGroups;

        return statistics;
    }

    public String trace()
    {
        final StringBuilder sb = new StringBuilder();
        final String eol = "\r\n";
        final String tab = "\t";

        sb.append("Total number of").append( eol );
        sb.append( tab ).append( "tables: " ).append( numOfTables ).append( eol );
        sb.append( tab ).append( "cells: " ).append( numOfCells ).append( eol );
        sb.append( tab ).append( "not empty cells: " ).append( numOfNotEmptyCells ).append( eol );
        sb.append( tab ).append( "labels: " ).append( numOfLabels ).append( eol );
        sb.append( tab ).append( "entries: " ).append( numOfEntries ).append( eol );

        sb.append( tab ).append( "label-label pairs: " ).append( numOfLL ).append( eol );
        sb.append( tab ).append( "entry-label pairs: " ).append( numOfEL ).append( eol );
        sb.append( tab ).append( "category-label pairs: " ).append( numOfCL ).append( eol );

        sb.append( tab ).append( "categories: " ).append( numOfCategories ).append( eol );
        sb.append( tab ).append( "label groups: " ).append(numOfLabelGroups).append( eol );

        return sb.toString();
    }

    public String trace( CTable table )
    {
        Statistics statistics = map.get( table );
        if ( null != statistics) return statistics.trace();
        else return null;
    }

    private StatisticsManager() {}

    public static StatisticsManager getInstance()
    {
        return INSTANCE;
    }

    public class Statistics
    {
        private CTable table;
        private StatisticsManager manager;

        private int numOfCells;
        private int numOfNotEmptyCells;
        private int numOfEntries;
        private int numOfLabels;

        private int numOfLL;
        private int numOfEL;
        private int numOfCL;

        private int numOfCategories;
        private int numOfLabelGroups;

        public void collect( CTable table )
        {
            this.table = table;
            // Collecting statistics from the table
            numOfCells = table.numOfCells();
            numOfNotEmptyCells = table.numOfNotEmptyCells();
            numOfEntries = table.numOfEntries();
            numOfLabels = table.numOfLabels();

            numOfLL = table.numOfLL();
            numOfEL = table.numOfEL();
            numOfCL = table.numOfCL();

            numOfCategories = table.numOfCategories();
            numOfLabelGroups = table.numOfLabelGroups();
        }

        public String trace()
        {
            final StringBuilder sb = new StringBuilder();
            final String eol = "\r\n";
            final String tab = "\t";

            sb.append( "Number of" ).append( eol );
            sb.append( tab ).append( "cells: " ).append( numOfCells ).append( eol );
            sb.append( tab ).append( "not empty cells: " ).append( numOfNotEmptyCells ).append( eol );
            sb.append( tab ).append( "labels: " ).append( numOfLabels ).append( eol );
            sb.append( tab ).append( "entries: " ).append( numOfEntries ).append( eol );

            sb.append( tab ).append( "label-label pairs: " ).append( numOfLL ).append( eol );
            sb.append( tab ).append( "entry-label pairs: " ).append( numOfEL ).append( eol );
            sb.append( tab ).append( "category-label pairs: " ).append( numOfCL).append( eol );

            sb.append( tab ).append( "categories: " ).append( numOfCategories ).append( eol );
            sb.append( tab ).append( "label groups: " ).append(numOfLabelGroups).append( eol );

            return sb.toString();
        }

        private Statistics() {};
    }
}
