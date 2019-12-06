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

package ru.icc.td.tabbyxl.model.style;

public final class CColor
{
    private int r;
    private int g;
    private int b;

    public CColor( String hexRGB )
    {
        super();

        String hexR = String.format( "#%s", hexRGB.substring( 0, 2 ) );
        String hexG = String.format( "#%s", hexRGB.substring( 2, 4 ) );
        String hexB = String.format( "#%s", hexRGB.substring( 4, 6 ) );

        this.r = Integer.decode( hexR );
        this.g = Integer.decode( hexG );
        this.b = Integer.decode( hexB );
    }

    String toHexRGBString()
    {
        String hexR = Integer.toHexString( r );
        String hexG = Integer.toHexString( g );
        String hexB = Integer.toHexString( b );

        return String.format( "#%s%s%s", hexR, hexG, hexB );
    }

    public String toString()
    {
        return toHexRGBString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + b;
        result = prime * result + g;
        result = prime * result + r;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;

        CColor other = ( CColor ) obj;

        if ( b != other.b ) return false;
        if ( g != other.g ) return false;
        if ( r != other.r ) return false;

        return true;
    }
}
