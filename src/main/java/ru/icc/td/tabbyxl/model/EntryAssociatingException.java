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

public final class EntryAssociatingException extends IllegalStateException
{
    public EntryAssociatingException( CEntry entry, CLabel addingLabel, CLabel addedLabel, CCategory category )
    {
        super( String.format( "%s [entry: \"%s\"; adding label: \"%s\"; added label: \"%s\"; category: \"%s\"]",
               "The entry is already associated with a label from the same category",
               entry.getValue(), addingLabel.getValue(), addedLabel.getValue(), category.getName() ) );
    }
}
