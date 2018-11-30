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

import java.util.ArrayList;
import java.util.List;

public final class CLabel extends CValue
{
    // TODO reading SEPARATOR value from settings is needed
    private final static String SEPARATOR = "|";

    // TODO testing for this method is needed
    public String getCompoundValue()
    {
        if ( null == parent )
        {
            return getValue();
        }
        else
        {
            return String.format( "%s %s %s", parent.getCompoundValue(), SEPARATOR, getValue() );
        }
    }

    private CCategory category;

    public CCategory getCategory()
    {
        return category;
    }

    public boolean hasCategory()
    {
        return null != category;
    }

    private boolean blocked = false;

    public void setCategory( CCategory category )
    {
        if ( blocked )
        {
            // TODO generating the warning: "The label is already associated with a category"
        }
        else
        {
            if ( category.addLabel( this ) )
            {
                this.category = category;
                // TODO checking category conflicts in label hierarchy, setting category in label hierarchy

                for ( CEntry entry : listeners )
                {
                    entry.categoryActivated( this );
                }
                listeners = null;
                blocked = true;
            }
        }
    }

    // TODO testing is needed
    public void setCategory( String categoryName )
    {
        if ( null == categoryName )
            throw new NullPointerException( "The category name cannot be null" );

        categoryName = categoryName.trim();

        if ( categoryName.isEmpty() )
            new IllegalArgumentException( "The category name cannot be empty" );

        LocalCategoryBox localCategoryBox = getOwner().getLocalCategoryBox();
        CCategory category = localCategoryBox.findCategory( categoryName );
        if ( category == null )
        {
            category = localCategoryBox.newCategory( categoryName );
        }
        setCategory( category );
    }

    public void group( CLabel label )
    {
        getOwner().getLabelGroupBox().group( this, label );
    }

    public CLabel( CTable owner, CCell cell, String value )
    {
        super( owner, cell, value );
    }

    public CLabel( CTable owner, String value )
    {
        this( owner, null, value );
    }

    private CLabel parent;

    public CLabel getParent()
    {
        return parent;
    }

    public boolean hasParent()
    {
        return null != parent;
    }

    private List<CLabel> children = new ArrayList<CLabel>();

    private void addChild( CLabel child )
    {
        children.add(child);
    }

    // return true if the label nas no child label
    public boolean isTerminal()
    {
        return children.size() == 0;
    }

    // TODO testing for this method is needed
    private boolean isDescendant( CLabel label )
    {
        for ( CLabel child : children )
        {
            if ( child.equals( label ) || child.isDescendant( label ) )
            {
                return true;
            }
        }
        return false;
    }

    // TODO changing exception type is needed
    public void setParent( CLabel parent ) //throws NotAllowedParentCycleException, NotAllowedParentChangeException
    {
        if ( null == parent )
            throw new NullPointerException( "The parent label cannot be null" );

        try
        {
            // parent change is not allowed
            if ( null == this.parent )
            {
                // label cycles are not allowed
                if ( this.equals( parent ) || isDescendant( parent ) )
                {
                    throw new NotAllowedParentCycleException( this, this.getParent(), parent );
                }
                else
                {
                    // TODO checking category conflicts in label hierarchy, setting category in label hierarchy
                    parent.addChild( this );
                    this.parent = parent;
                }
            }
            else
            {
                throw new NotAllowedParentChangeException( this, this.getParent(), parent );
            }
        }
        catch ( ParentAssociatingException e )
        {
            System.out.println( "The label parent candidate has been declined: " + e.getMessage() );
        }
    }

    private List<CEntry> listeners = new ArrayList<CEntry>();

    void addListener( CEntry entry )
    {
        listeners.add(entry);
    }

    public String trace()
    {
        final String separator = "; ";
        final StringBuilder sb = new StringBuilder();
        final String nil = "null";

        String s1 = String.format("label=\"%s\"", getValue());
        sb.append(s1).append(separator);

        CCell c = this.getCell();
        String s2 = String.format("address=%s", c.address());
        sb.append(s2).append(separator);

        sb.append("parent=");
        if ( null == parent )
            sb.append( nil );
        else
            sb.append('"').append(parent.getValue()).append('"');
        sb.append(separator);

        sb.append("category=");
        if ( null == category )
            sb.append( nil );
        else
            sb.append('"').append(category.getName()).append('"');

        return sb.toString();
    }
}
