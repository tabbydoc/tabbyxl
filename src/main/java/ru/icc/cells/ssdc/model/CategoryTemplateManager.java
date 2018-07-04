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

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class CategoryTemplateManager
{
    private static Yaml yaml;

    static
    {
        Constructor constructor = new Constructor( CategoryTemplate.class );
        TypeDescription typeDesc = new TypeDescription( CategoryTemplate.class );
        typeDesc.putListPropertyType( "constraints", String.class );
        typeDesc.putListPropertyType( "labels", String.class );
        constructor.addTypeDescription(typeDesc);
        yaml = new Yaml( constructor );
    }

    private final List<CategoryTemplate> templates = new ArrayList<CategoryTemplate>();

    public void load( File categoryDescFile ) throws FileNotFoundException, IOException
    {
        Reader reader = new FileReader( categoryDescFile );

        for ( Object template : yaml.loadAll( reader ) )
            templates.add( (CategoryTemplate) template );


        reader.close();
    }

    public void createCategories( CTable table ) throws Exception
    {
        final LocalCategoryBox localCategoryBox = table.getLocalCategoryBox();
        for ( CategoryTemplate desc : templates)
        {
            CCategory category = localCategoryBox.newCategory( desc.getName() );

            for ( String constraint : desc.getConstraints() )
                category.addConstraint( constraint );

            for ( String labelValue : desc.getLabels() )
                category.newLabel( labelValue );
        }
    }

    public boolean hasAtLeastOneCategoryTemplate()
    {
        return templates.size() > 0;
    }

    private static final CategoryTemplateManager INSTANCE = new CategoryTemplateManager();

    private CategoryTemplateManager() {}

    public static CategoryTemplateManager getInstance()
    {
        return INSTANCE;
    }

    public void release()
    {
        templates.clear();
    }

    public static class CategoryTemplate
    {
        private String name;

        public String getName()
        {
            return name;
        }

        public void setName( String name )
        {
            this.name = name;
        }

        private List<String> constraints;

        public List<String> getConstraints()
        {
            return constraints;
        }

        public void setConstraints( List<String> constraints )
        {
            this.constraints = constraints;
        }

        private List<String> labels;

        public List<String> getLabels()
        {
            return labels;
        }

        public void setLabels( List<String> labels )
        {
            this.labels = labels;
        }

        public CategoryTemplate() {};
    }

}
