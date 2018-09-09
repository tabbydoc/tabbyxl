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

package ru.icc.td.tabbyxl2.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CCellBox extends COwned
{
    // TODO М.б. переделать на Set<CCell>
    private List<CCell> cells = new ArrayList<CCell>();

    private int index;

    public CCell getCell( int index )
    {
        return this.cells.get( index );
    }

    public Iterator<CCell> getCells()
    {
        return this.cells.iterator();
    }

    public void addCell( CCell cell )
    {
        this.cells.add( cell );
    }

    public int getIndex()
    {
        return this.index;
    }

    public void setIndex( int order )
    {
        this.index = order;
    }

    public boolean isBlank()
    {
        for ( CCell c : this.cells )
        {
            String s = c.getText();
            if ( null != s )
            {
                s = s.trim();
                if ( ! s.isEmpty() )
                    return false;
            }
        }
        return true;
    }

    protected CCellBox( CTable owner, int index )
    {
        super( owner );
        this.setIndex( index );
    }

    @Override
    public String toString()
    {
        return "CCellContainer [index = " + index + ", isBlank = " + this.isBlank() + "]";
    }
}
