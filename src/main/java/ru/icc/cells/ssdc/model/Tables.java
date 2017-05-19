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

package ru.icc.cells.ssdc.model;

import ru.icc.cells.ssdc.model.style.BorderType;
import ru.icc.cells.ssdc.model.style.CBorder;
import ru.icc.cells.ssdc.model.style.CStyle;

import java.util.Iterator;

/**
 * Created by Alexey Shigarov (shigarov@gmail.com) on 13.02.2015.
 */

public final class Tables
{
    // Восстановление границ ячеек.
    // Этот метод восстанавливает физ. границы ячеек в соответствии с ее видимыми границами
    public static CTable recoverCellBorders( CTable table )
    {
        int numOfCols = table.numOfCols();
        int numOfRows = table.numOfRows();

        CCell[][] cellMatrix = new CCell[ numOfCols + 1 ][ numOfRows + 1 ];

        Iterator<CCell> cells = table.getCells();

        while ( cells.hasNext() )
        {
            CCell cell = cells.next();
            for ( int i = cell.getCl(); i <= cell.getCr(); i++ )
            {
                for ( int j = cell.getRt(); j <= cell.getRb(); j++ )
                {
                    cellMatrix[ i ][ j ] = cell;
                }
            }
        }

        cells = table.getCells();

        while ( cells.hasNext() )
        {
            CCell cell = cells.next();
            CStyle sty = cell.getStyle();
            CCell neighbor;
            CStyle neighborSty;
            BorderType recoveredBorderType;

            // Left
            CBorder leftBorder = sty.getLeftBorder();
            if ( leftBorder.getType() == BorderType.NONE && cell.getCl() > 1 )
            {
                recoveredBorderType = BorderType.NONE;

                for ( int j = cell.getRt(); j <= cell.getRb(); j++ )
                {
                    neighbor = cellMatrix[ cell.getCl() - 1 ][ j ];
                    if ( null == neighbor ) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getRightBorder().getType();
                    if ( recoveredBorderType == BorderType.NONE )
                        break;
                }

                if ( recoveredBorderType != BorderType.NONE )
                    leftBorder.setType(recoveredBorderType);
            }

            // Right
            CBorder rightBorder = sty.getRightBorder();
            if ( rightBorder.getType() == BorderType.NONE && cell.getCr() < numOfCols )
            {
                recoveredBorderType = BorderType.NONE;

                for ( int j = cell.getRt(); j <= cell.getRb(); j++ )
                {
                    neighbor = cellMatrix[ cell.getCr() + 1 ][ j ];
                    if ( null == neighbor ) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getLeftBorder().getType();
                    if ( recoveredBorderType == BorderType.NONE )
                        break;
                }

                if ( recoveredBorderType != BorderType.NONE )
                    rightBorder.setType(recoveredBorderType);
            }

            // Top
            CBorder topBorder = sty.getTopBorder();
            if ( topBorder.getType() == BorderType.NONE && cell.getRt() > 1 )
            {
                recoveredBorderType = BorderType.NONE;

                for ( int i = cell.getCl(); i <= cell.getCr(); i++ )
                {
                    neighbor = cellMatrix[ i ][ cell.getRt() - 1 ];
                    if ( null == neighbor ) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getBottomBorder().getType();
                    if ( recoveredBorderType == BorderType.NONE )
                        break;
                }

                if ( recoveredBorderType != BorderType.NONE )
                    topBorder.setType(recoveredBorderType);
            }

            // Bottom
            CBorder bottomBorder = sty.getBottomBorder();
            if ( bottomBorder.getType() == BorderType.NONE && cell.getRb() < numOfRows )
            {
                recoveredBorderType = BorderType.NONE;

                for ( int i = cell.getCl(); i <= cell.getCr(); i++ )
                {
                    neighbor = cellMatrix[ i ][ cell.getRb() + 1 ];
                    if ( null == neighbor ) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getTopBorder().getType();
                    if ( recoveredBorderType == BorderType.NONE )
                        break;
                }

                if ( recoveredBorderType != BorderType.NONE )
                    bottomBorder.setType(recoveredBorderType);
            }
        }
        return table;
    }
}
