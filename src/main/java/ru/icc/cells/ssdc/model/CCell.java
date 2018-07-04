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

import org.drools.core.util.StringUtils;
import ru.icc.cells.ssdc.model.style.CStyle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CCell extends COwned implements Cloneable
{
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    // a left column position
    private int cl;

    public int getCl()
    {
        return this.cl;
    }

    public void setCl( int cl )
    {
        this.cl = cl;
    }

    // a right column position
    private int cr;

    public int getCr()
    {
        return this.cr;
    }

    public void setCr( int cr )
    {
        this.cr = cr;
    }

    // a top row position
    private int rt;

    public int getRt()
    {
        return this.rt;
    }

    public void setRt( int rt )
    {
        this.rt = rt;
    }

    // a bottom row position
    private int rb;

    public int getRb()
    {
        return this.rb;
    }

    public void setRb( int rb )
    {
        this.rb = rb;
    }

    private int height;

    /**
     * @return the height
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight( int height )
    {
        this.height = height;
    }

    private int width;

    /**
     * @return the width
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth( int width )
    {
        this.width = width;
    }

    private CStyle style = new CStyle();

    public CStyle getStyle()
    {
        return this.style;
    }

    // a source raw text (a text) from the excel cell
    private String rawText;

    public String getRawText()
    {
        return this.rawText;
    }

    public void setRawText( String rawText )
    {
        this.rawText = rawText;
        setSpaceIndent( rawText );
        setIndent( getSpaceIndent() );
    }

    // a text ( a processed text )
    private String text;

    public String getText()
    {
        return this.text;
    }

    public void setText( String text )
    {
        this.text = null == text ? "" : text.replace('\u00A0', ' ').trim();
    }

    // a RTF object from the excel cell
    private Object rtf;

    // an image from the excel cell
    private Object image;

	//  an amount of spaces in the beginning of the excel cell's text
    private int spaceIndent;

	/*
	 * Возвращает количество пробелов в начале строки.
	 * Предназначена для случаев, когда иерархия заголовков
	 * выстраивается с помощью отступов в виде наборов пробелов.
	 * Возвращаемый тип данных должен быть int,
	 * если использовать short, то при исполнении правил возникает исключительная ситуация "Exception jitting"
	 */
    public int getSpaceIndent()
    {
        return spaceIndent;
    }

    private void setSpaceIndent( String rawText )
    {
        // TODO Checking: if rawText string contains only spaces, then spaceIndent equals 0
        spaceIndent = 0;

        if ( null != rawText )
        {
            char[] chars = rawText.toCharArray();

            for ( char ch : chars )
            {
                if ( ch == ' ' || ch == '\u00A0' ) spaceIndent ++;
                else break;
            }
        }
    }

    private int indent;

    public void setIndent( int indent )
    {
        this.indent = indent;
    }

    public int getIndent()
    {
        return this.indent;
    }

    // a data type from excel cell: числовой, текстовый, дата, денежный, формула
    private CellType type;

    public CellType getType()
    {
        return this.type;
    }

    public void setType(CellType type)
    {
        this.type = type;
    }

    private String mark;

    public String getMark()
    {
        return mark;
    }

    public void setMark( String mark )
    {
        if ( null == mark )
            throw new NullPointerException( "The mark cannot be null" );

        if ( mark.isEmpty() )
            throw new IllegalArgumentException( "The mark cannot be empty" );

        //if ( ! mark.matches( "@\\w+" ) )
            //throw new IllegalArgumentException( "The mark is not matched with \"@\\w+\"" );

        this.mark = mark;
    }

    public boolean isMarked()
    {
        return null != mark;
    }

    private boolean ignored;

    public boolean isIgnored()
    {
        return this.ignored;
    }

    public void setIgnored( boolean ignored )
    {
        this.ignored = ignored;
    }

    private CLabel label;

    private List<CLabel> labels = new ArrayList<CLabel>();

    private void setLabel( CLabel label )
    {
        if ( null == this.label )
            this.label = label;
    }

    public CLabel getLabel()
    {
        return label;
    }

    public CLabel getLabel( int index )
    {
        return labels.get( index );
    }

    public Iterator<CLabel> labels()
    {
        return labels.iterator();
    }

    public CLabel newLabel()
    {
        return newLabel( text );
    }

    public CLabel newLabel( String value )
    {
        // processing value parameter is not necessary because label constructor do it
        CLabel label = new CLabel( getOwner(), this, value );
        // checking label uniqueness is not necessary because a new label has always a unique state
        getOwner().addLabel( label );
        labels.add( label );
        setLabel( label );
        return label;
    }

    public boolean containsLabel()
    {
        return null != label;
    }

    private CEntry entry;

    private List<CEntry> entries = new ArrayList<CEntry>();

    private void setEntry( CEntry entry )
    {
        if ( null == this.entry )
            this.entry = entry;
    }

    public CEntry getEntry()
    {
        return entry;
    }

    // TODO implementation for the multivalued cell
    public CEntry getEntry( int index )
    {
        return entries.get( index );
    }

    public Iterator<CEntry> entries()
    {
        return entries.iterator();
    }

    public CEntry newEntry()
    {
        return newEntry( text );
    }

    public CEntry newEntry( String value )
    {
        // processing value parameter is not necessary because entry constructor do it
        CEntry entry = new CEntry( getOwner(), this, value );
        // checking label uniqueness is not necessary because a new label has always a unique state
        getOwner().addEntry( entry );
        entries.add( entry );
        setEntry( entry );
        return entry;
    }

    public boolean containsEntry()
    {
        return null != entry;
    }

    public boolean isBlank()
    {
        return null == text ? true : text.isEmpty();
    }

    private void setPosition( int c, int r )
    {
        cl = c;
        rt = r;
        cr = c;
        rb = r;
    }

    public CCell[] split()
    {
        int n = cr - cl + 1;
        int m = rb - rt + 1;
        int l = n * m;

        CCell[] splits = new CCell[l];

        try
        {
            int c = 0;

            for ( int i = 0; i < n; i ++ )
            {
                for ( int j = 0; j < m; j ++ )
                {
                    CCell cell = ( CCell ) this.clone();
                    cell.setPosition( cl + i, rt + j );
                    getOwner().addCell(cell);
                    splits[c] = cell;
                    c ++;
                }
            }
            getOwner().removeCell( this );
            return splits;
        }
        catch ( CloneNotSupportedException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    private boolean canMerge( CCell cell )
    {
        // TODO testing is needed
        if ( ( rt == cell.rt && rb == cell.rb ) && ( cl == cell.cr + 1 || cr == cell.cl - 1 ) ) return true;

        if ( ( cl == cell.cl && cr == cell.cr ) && ( rt == cell.rb + 1 || rb == cell.rt - 1 ) ) return true;

        return false;
    }

    public CCell merge( CCell cell )
    {
        if ( null == cell )
            throw new NullPointerException( "The merging cell is null" );

        if ( getOwner() != cell.getOwner() )
            throw new IllegalArgumentException();

        if ( getOwner().containsCell(cell) )
            throw new IllegalArgumentException();

        if ( ! canMerge( cell ) )
            return null;

        int l = Math.min( cl, cell.cl );
        int t = Math.min( rt, cell.rt );
        int r = Math.max( cr, cell.cr );
        int b = Math.max( rb, cell.rb );

        setCl(l);
        setRt( t );
        setCr( r );
        setRb( b );

        getOwner().removeCell( cell );

        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // TODO implementation
        return super.clone();
    }

    CCell( CTable owner )
    {
        super( owner );
    }

    public boolean isSingleOnRow()
    {
        return cl == 1 && cr == getOwner().numOfCols();
    }

    public boolean isSingleOnCol()
    {
        return rt == 1 && rb == getOwner().numOfRows();
    }

    public boolean isOnLastRow()
    {
        return rb == getOwner().numOfRows();
    }

    public boolean isOnLastCol()
    {
        return cr == getOwner().numOfCols();
    }

    public boolean isColored()
    {
        return null != style.getFgColor();
    }

    public boolean hasColor( String hexRGB )
    {
        if ( null == hexRGB )
            throw new NullPointerException( "The color cannot be null" );

        if ( ! hexRGB.matches( "#\\w{6}" ) )
            throw new IllegalArgumentException( "The hexRGB param does not match \"#\\w{6}]\"" );

        if ( null == style.getFgColor() ) return false;
        else return hexRGB.equalsIgnoreCase( style.getFgColor() );
    }

    /*
    public boolean isVertNextTo( CCell cell )
    {
        if ( this.rt == cell.rb + 1 )
            return true;
        else
            return false;
    }
    */
    public String trace()
    {
        return String.format( "%s%n%s%n", text, style.trace() );
    }

    private String provenance;

    public void setProvenance(String provenance)
    {
        this.provenance = provenance;
    }

    public String getProvenance()
    {
        return this.provenance;
    }

    public String address()
    {
        return String.format("L%dT%dR%dB%d", getCl(), getRt(), getCr(), getRb());
    }

    // methods for JassRules

    private int charAt0; // = null == text ? -1 : (int) text.charAt(0);
    public int getCharAt0()
    {
        return StringUtils.isEmpty(text) ? -1 : (int) text.charAt(0);
    }

    private boolean boldFlag = style.getFont().isBold();
    public boolean getBoldFlag()
    {
        return boldFlag;
    }

    /*private boolean labelIsTerminalFlag = label.isTerminal();
    public void setLabelIsTerminalFlag(boolean value)
    {
        labelIsTerminalFlag = value;
    }
    public boolean getLabelIsTerminalFlag() {
        return  labelIsTerminalFlag;
    }*/


    // *******************
}
