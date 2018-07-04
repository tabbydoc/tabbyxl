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

package ru.icc.cells.ssdc.model.style;

public class CStyle
{
    private boolean hidden;

    public boolean isHidden()
    {
        return this.hidden;
    }

    public void setHidden( boolean hidden )
    {
        this.hidden = hidden;
    }

    private boolean locked;

    public boolean isLocked()
    {
        return this.locked;
    }

    public void setLocked( boolean locked )
    {
        this.locked = locked;
    }

    private boolean wrapped;

    public boolean isWrapped()
    {
        return this.wrapped;
    }

    public void setWrapped( boolean wrapped )
    {
        this.wrapped = wrapped;
    }

    private CFont font = new CFont();

    public CFont getFont()
    {
        return this.font;
    }

    /*
	public void setFont( CFont font )
	{
		this.font = font;
	}
    */

    private HorzAlignment horzAlignment;

    public HorzAlignment getHorzAlignment()
    {
        return horzAlignment;
    }

    public void setHorzAlignment( HorzAlignment horzAlignment )
    {
        this.horzAlignment = horzAlignment;
    }

    private VertAlignment vertAlignment;

    public VertAlignment getVertAlignment()
    {
        return this.vertAlignment;
    }

    public void setVertAlignment( VertAlignment vertAlignment )
    {
        this.vertAlignment = vertAlignment;
    }

    private short rotation;

    public short getRotation()
    {
        return rotation;
    }

    public void setRotation( short rotation )
    {
        this.rotation = rotation;
    }

    private short indention;

    public short getIndention()
    {
        return indention;
    }

    public void setIndention( short indention )
    {
        this.indention = indention;
    }

    private FillPattern fillPattern;

	public FillPattern getFillPattern()
	{
		return fillPattern;
	}

	public void setFillPattern( FillPattern fillPattern )
	{
		this.fillPattern = fillPattern;
	}

    private CColor bgColor;

    public String getBgColor()
    {
        if ( null == this.bgColor ) return null;
        return this.bgColor.toHexRGBString();
    }

    public void setBgColor( CColor bgColor )
    {
        this.bgColor = bgColor;
    }

    private CColor fgColor;

    public String getFgColor()
    {
        if ( null == this.fgColor ) return null;
        return this.fgColor.toHexRGBString();
    }

    public void setFgColor( CColor fgColor )
    {
        this.fgColor = fgColor;
    }

    private CBorder leftBorder = new CBorder();

    public CBorder getLeftBorder()
    {
        return this.leftBorder;
    }

    public void setLeftBorder( CBorder leftBorder )
    {
        this.leftBorder = leftBorder;
    }

    private CBorder rightBorder = new CBorder();

    public CBorder getRightBorder()
    {
        return this.rightBorder;
    }

    public void setRightBorder( CBorder rightBorder )
    {
        this.rightBorder = rightBorder;
    }

    private CBorder topBorder = new CBorder();

    public CBorder getTopBorder()
    {
        return this.topBorder;
    }

    private CBorder bottomBorder = new CBorder();

    public void setTopBorder( CBorder topBorder )
    {
        this.topBorder = topBorder;
    }

    public CBorder getBottomBorder()
    {
        return this.bottomBorder;
    }

    public void setBottomBorder( CBorder bottomBorder )
    {
        this.bottomBorder = bottomBorder;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public String trace()
    {
        String sFont = String.format( "F=%s", font.toString() );

        String sBgColor;
        if ( null != bgColor )
            sBgColor = String.format( "bC=%s", bgColor.toHexRGBString() );
        else
            sBgColor = "bC=none";

        String sFgColor;
        if ( null != fgColor )
            sFgColor = String.format( "fC=%s", fgColor.toHexRGBString() );
        else
            sFgColor = "fC=none";

        String sHzAlignment = String.format( "hA=%s", horzAlignment );
        String sVtAlignment  = String.format( "vA=%s", vertAlignment );

        String sRotation  = String.format( "R=%d", rotation );
        String sIndention = String.format( "I=%d", indention );

        String sHidden  = String.format( "H=%b", hidden );
        String sLocked  = String.format( "L=%b", locked );
        String sWrapped = String.format( "W=%b", wrapped );

        String sLfBorder = String.format( "lB=%s", leftBorder );
        String sRgBorder = String.format( "rB=%s", rightBorder );
        String sTpBorder = String.format( "tB=%s", topBorder );
        String sBtBorder = String.format( "bB=%s", bottomBorder );

        return String.format( "CCellStyle [%s %s %s %s %s %s %s %s %s %s %s %s %s %s]",
                sFont, sBgColor, sFgColor, sHzAlignment, sVtAlignment, sRotation, sIndention,
                sHidden, sLocked, sWrapped, sLfBorder, sRgBorder, sTpBorder, sBtBorder);
    }
}
