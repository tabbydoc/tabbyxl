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

package ru.icc.cells.ssdc.model;

import java.util.*;

public final class CEntry extends CValue
{
    private Map<CCategory, CLabel> labels = new HashMap<CCategory, CLabel>();

    public Iterator<CLabel> getLabels()
    {
        return labels.values().iterator();
    }

    private Set<CLabel> candidates = new HashSet<CLabel>();

    public int numOfLabels()
    {
        return labels.size();
    }

    void categoryActivated( CLabel label )
    {
        if ( candidates.contains( label ) )
        {
            addLabel( label );
            candidates.remove( label );
        }
    }

    public void addLabel( CLabel label )
    {
        if ( null == label )
            throw new NullPointerException( "The adding label cannot be null" );

        CCategory category = label.getCategory();

        if ( null == category )
        {
            if ( candidates.add( label ) )
            {
                label.addListener( this );
            }
            else
            {
                // TODO generating the warning: "The label candidate set already contains this label"
            }
        }
        else
        {
            if ( labels.containsKey( category ) )
            {
                CLabel addedLabel = labels.get( category );
                throw new EntryAssociatingException( this, label, addedLabel, category );
            }
            else
            {
                labels.put( category, label );
            }
        }
    }

    // TODO testing is needed
    public void addLabel(String labelValue, CCategory category )
    {
        CLabel label  = category.findLabel( labelValue );

        if ( label == null )
        {
            label = category.newLabel( labelValue );
        }
        addLabel(label);
    }

    // TODO testing is needed
    public void addLabel( String labelValue, String categoryName )
    {
        LocalCategoryBox localCategoryBox = getOwner().getLocalCategoryBox();

        CCategory category = localCategoryBox.findCategory( categoryName );
        if ( category == null )
        {
            category = localCategoryBox.newCategory( categoryName );
        }
        addLabel( labelValue, category );
    }

    public CEntry( CTable owner, CCell cell, String value )
    {
        super( owner, cell, value );
    }

    public String trace()
    {
        final String separator = "; ";
        final StringBuilder sb = new StringBuilder();

        String s1 = String.format("entry=\"%s\"", getValue());
        sb.append(s1).append(separator);

        CCell c = this.getCell();
        String s2 = String.format("address=%s", c.address());
        sb.append(s2).append(separator);

        sb.append("labels={");
        Iterator<CLabel> labels = this.labels.values().iterator();
        while ( labels.hasNext() )
        {
            CLabel label = labels.next();
            sb.append('"').append(label.getValue()).append('"');
            if ( labels.hasNext() )
                sb.append(", ");
        }
        sb.append("}");

        return sb.toString();
    }
}
