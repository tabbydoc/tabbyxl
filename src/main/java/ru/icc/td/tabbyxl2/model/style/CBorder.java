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

public class CBorder
{
    private BorderType type;

    public BorderType getType()
    {
        return this.type;
    }

    public void setType( BorderType type )
    {
        this.type = type;
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

    public CBorder( BorderType type, CColor color )
    {
        this.setType( type );
        this.setColor( color );
    }

    public CBorder()
    {
        this( BorderType.NONE, null );
    }
}
