/*
 * Copyright 2015-18 Alexey O. Shigarov (shigarov@icc.ru)
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

package ru.icc.td.tabbyxl2.model.style;

public class CFont
{
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    private CColor color;

    public CColor getColor()
    {
        return this.color;
    }

    public void setColor( CColor color )
    {
        this.color = color;
    }

    // a font height in unit's of 1/20th of a point.
    private short height;

    public short getHeight()
    {
        return this.height;
    }

    // set the font height in unit's of 1/20th of a point.
    public void setHeight( short height )
    {
        this.height = height;
    }

    // a font height
    private short heightInPoints;

    public short getHeightInPoints()
    {
        return this.heightInPoints;
    }

    public void setHeightInPoints( short heightInPoints )
    {
        this.heightInPoints = heightInPoints;
    }

    public boolean isNormal()
    {
        return ! ( this.bold || this.italic || this.underline || this.doubleUnderline || this.strikeout );
    }

    private boolean bold;

    /**
     * @return the bold
     */
    public boolean isBold()
    {
        return this.bold;
    }

    /**
     * @param bold the bold to set
     */
    public void setBold( boolean bold )
    {
        this.bold = bold;
    }

    private boolean italic;

    public boolean isItalic()
    {
        return this.italic;
    }

    public void setItalic( boolean italic )
    {
        this.italic = italic;
    }

    private boolean strikeout;

    public boolean isStrikeout()
    {
        return this.strikeout;
    }

    public void setStrikeout( boolean strikeout )
    {
        this.strikeout = strikeout;
    }

    private boolean underline;

    public boolean getUnderline()
    {
        return this.underline;
    }

    public void setUnderline( boolean underline )
    {
        this.underline = underline;
    }

    private boolean doubleUnderline;

    /**
     * @return the doubleUnderline
     */
    public boolean isDoubleUnderline()
    {
        return this.doubleUnderline;
    }

    /**
     * @param doubleUnderline the doubleUnderline to set
     */
    public void setDoubleUnderline( boolean doubleUnderline )
    {
        this.doubleUnderline = doubleUnderline;
    }

    @Override
    public String toString()
    {
        String sName = "\"" + this.name + "\"";

        String sColor;
        if ( null != this.color )
            sColor = String.format( "C=%s", this.color.toHexRGBString() );
        else
            sColor = "C=none";

        String sHeight = String.format( "H=%s", Short.toString( this.height) );
        String sHeightInPoints = String.format( "Hp=%s", Short.toString( this.heightInPoints) );

        String sBold = String.format( "B=%b", this.bold );
        String sItalic = String.format( "I=%b", this.italic );
        String sStrikeout = String.format( "S=%b", this.strikeout );
        String sUnderline = String.format( "U=%b", this.underline );
        String sDoubleUnderline = String.format( "UU=%b", this.doubleUnderline );

        return String.format( "CFont [%s %s %s %s %s %s %s %s %s]",
                sName, sColor, sHeight, sHeightInPoints, sBold, sItalic, sStrikeout,
                sUnderline, sDoubleUnderline);
    }

}

