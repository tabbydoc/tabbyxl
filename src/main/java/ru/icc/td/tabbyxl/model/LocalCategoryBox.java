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

import java.util.*;

public final class LocalCategoryBox extends COwned
{
    private Set<CCategory> categories = new HashSet<CCategory>();

    public Iterator<CCategory> getCategories()
    {
        return categories.iterator();
    }
    public List<CCategory> getCategoryList() {
        List<CCategory> res = new ArrayList();
        Iterator iterator = categories.iterator();
        while (iterator.hasNext())
            res.add((CCategory) iterator.next());
        return res;
    }

    int numOfCategories()
    {
        return this.categories.size();
    }

    CCategory newCategory( String categoryName )
    {
        CCategory category = new CCategory( getOwner(), categoryName );
        // TODO testing is needed: an adding category must have an unique name among all added categories
        if ( categories.add( category ) )
        {
            return category;
        }
        return null;
    }

    CCategory findCategory( String categoryName )
    {
        categoryName = categoryName.toLowerCase();

        for ( CCategory c : categories )
        {
            if ( c.getName().equalsIgnoreCase( categoryName ) )
            {
                return c;
            }
        }
        return null;
    }

    LocalCategoryBox( CTable owner )
    {
        super( owner );
    }
}
