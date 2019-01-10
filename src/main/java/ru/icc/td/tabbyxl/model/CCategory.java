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

import java.net.URI;
import java.util.*;

public final class CCategory extends COwned implements Cloneable
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        if ( null == name )
            throw new NullPointerException( "The category name cannot be null" );

        name = name.trim();

        if ( name.isEmpty() )
            throw new IllegalArgumentException( "The category name cannot be empty" );

        this.name = name; //this.name = name.toUpperCase();
    }

    private URI reference;

    public URI getReference()
    {
        return reference;
    }

    public void setReference( URI reference ) {
        this.reference = reference;
    }

    private Set<CLabel> labels = new LinkedHashSet<CLabel>();

    public Iterator<CLabel> getLabels()
    {
        return this.labels.iterator();
    }

    public CLabel findLabel( String labelValue )
    {
        for ( CLabel l : labels )
        {
            if ( l.getValue().equalsIgnoreCase(labelValue) )
            {
                return l;
            }
        }
        return null;
    }

    public boolean hasLabel( String labelValue )
    {
        for ( CLabel l : labels )
        {
            if ( labelValue.equalsIgnoreCase(l.getValue()) )
                return true;
        }
        return false;
    }

    public boolean canHaveLabel( String labelValue )
    {
        // TODO Implementation
        return false;
    }

    public CLabel newLabel( String value )
    {
        CLabel label = new CLabel( getOwner(), value );
        label.setCategory( this );
        return label;
    }

    protected boolean addLabel( CLabel label )
    {
        if ( satisfy( label ) )
        {
            return this.labels.add(label);
        }
        else
        {
            return false;
        }
    }

    private boolean satisfy( CLabel label )
    {
        // TODO implementation: is a label satisfied to constraints
        return true;
    }

    private List<String> constraints = new ArrayList<String>();

    public void addConstraint( String constraint )
    {
        constraints.add( constraint );
    }

    public CCategory( CTable owner, String name )
    {
        super( owner );
        setName( name );
    }

    CCategory( String name )
    {
        this( null, name );
    }

    // TODO reading BLANK_PADDING from settings
    private static final String BLANK_PADDING = "null";

    public String trace()
    {
        final String separator = "; ";
        StringBuilder sb = new StringBuilder();

        String s1 = String.format("category=\"%s\"", getName());
        sb.append(s1).append(separator);

        sb.append("labels={");
        int i = 0;
        Iterator<CLabel> labels = this.labels.iterator();
        while ( labels.hasNext() )
        {
            String s = labels.next().getValue();
            if ( s.isEmpty() ) s = BLANK_PADDING;
            sb.append('"').append(s).append('"');
            if ( i < this.labels.size() - 1 )
            {
                sb.append(',').append(' ');
                i++;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // TODO implementation
        return super.clone();
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        CCategory category = ( CCategory ) o;

        if ( ! name.equals( category.name ) ) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
}
