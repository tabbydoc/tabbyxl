# Copyright 2015 Alexey O. Shigarov (shigarov@icc.ru)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Keywords
[keyword][] rule #{number:\d+} = rule "#{number}" salience -{number}

#Cell querying
[condition][] cell\.entry\[{index}\] ${cell:\w+}\.${entry:\w+} : {constraints} = ${cell} : CCell( containsEntry(), {constraints}, ${entry} : getEntry( {index} ) )
[condition][] cell\.entry\[{index}\] ${cell:\w+}\.${entry:\w+} = ${cell} : CCell( containsEntry(), ${entry} : getEntry( {index} ) )
[condition][] cell\.entry ${cell:\w+}\.${entry:\w+} : {constraints} = ${cell} : CCell( containsEntry(), {constraints}, ${entry} : entry )
[condition][] cell\.entry ${cell:\w+}\.${entry:\w+} = ${cell} : CCell( containsEntry(), ${entry} : entry )
[condition][] cell\.entry ${cell:\w+} : {constraints} = ${cell} : CCell( containsEntry(), {constraints} )
[condition][] cell\.entry ${cell:\w+} = ${cell} : CCell( containsEntry() )
[condition][] cell\.label\[{index:\d+}\] ${cell:\w+}\.${label:\w+} : {constraints} = ${cell} : CCell( containsLabel(), {constraints}, ${label} : getLabel( {index} ) )
[condition][] cell\.label\[{index:\d+}\] ${cell:\w+}\.${label:\w+} = ${cell} : CCell( containsLabel(), ${label} : getLabel( {index} ) )
[condition][] cell\.label ${cell:\w+}\.${label:\w+} : {constraints} = ${cell} : CCell( containsLabel(), {constraints}, ${label} : label )
[condition][] cell\.label ${cell:\w+}\.${label:\w+} = ${cell} : CCell( containsLabel(), ${label} : label )
[condition][] cell\.label ${cell:\w+} : {constraints} = ${cell} : CCell( containsLabel(), {constraints} )
[condition][] cell\.label ${cell:\w+} = ${cell} : CCell( containsLabel() )
[condition][] cell@{mark:\w+} ${cell:\w+} : {constraints} = ${cell} : CCell( mark == "@{mark}", {constraints} )
[condition][] cell@{mark:\w+} ${cell:\w+} = ${cell} : CCell( mark == "@{mark}" )
[condition][] cell ${cell:\w+} : {constraints} = ${cell} : CCell( {constraints} )
[condition][] cell ${cell:\w+} = ${cell} : CCell()

#Entry querying
[condition][] entry ${entry:\w+} : {constraints} = ${entry} : CEntry( {constraints} )
[condition][] entry ${entry:\w+} = ${entry} : CEntry()

#Label querying
[condition][] label ${label:\w+} : {constraints} = ${label} : CLabel( {constraints} )
[condition][] label ${label:\w+} = ${label} : CLabel()

#Category querying
[condition][] category ${category:\w+} : "{name}" = ${category} : CCategory( name == "{name}" )
[condition][] category ${category:\w+} : {constraints} = ${category} : CCategory( {constraints} )
[condition][] category ${category:\w+} = ${category} : CCategory()

#Not exists
[condition][] no cells@{mark:\w+} : {constraints} = not ( exists CCell ( mark == "@{mark}", {constraints} ) )
[condition][] no cells : {constraints} = not ( exists CCell ( {constraints} ) )
[condition][] no entries : {constraints} = not ( exists CEntry ( {constraints} ) )
[condition][] no labels : {constraints} = not ( exists CLabel ( {constraints} ) )
[condition][] no categories : {constraints} = not ( exists CCategory ( {constraints} ) )

#Text editing
[consequence][] set text {string_expression} -> ${cell:\w+} = ${cell}.setText( {string_expression} );

#Indent editing
[consequence][] set indent {integer:\d+} -> ${cell:\w+} = ${cell}.setIndent( {integer} );

#Cell splitting
[consequence][] split ${cell:\w+} = for ( CCell cell : ${cell}.split() ) \{ insert ( cell ); \}; retract ( ${cell} );

#Cell merging
[consequence][] merge ${cell1:\w+} -> ${cell2:\w+} = ${cell1}.merge( ${cell2} ); retract ( ${cell1} );

#Cell marking
[consequence][] set mark @{mark:\w+} -> ${cell:\w+} = ${cell}.setMark( "@{mark}" );

#Entry creating 
[consequence][] new entry {string_expression} -> ${cell:\w+} = insert ( ${cell}.newEntry( {string_expression} ) );
[consequence][] new entry ${cell:\w+} = insert ( ${cell}.newEntry() );

#Label creating
[consequence][] new label {string_expression} -> ${cell:\w+} = insert ( ${cell}.newLabel( {string_expression} ) );
[consequence][] new label ${cell:\w+} = insert ( ${cell}.newLabel() );

#Value editing
[consequence][] set value {string_expression} -> ${cell:\w+}\.label\[{index:\d+}\] = ${cell}.getLabel( {index} ).setValue( {string_expression} );
[consequence][] set value {string_expression} -> ${cell:\w+}\.label = ${cell}.getLabel().setValue( {string_expression} ); 
[consequence][] set value {string_expression} -> ${cell:\w+}\.entry\[{index:\d+}\] = ${cell}.getEntry( {index} ).setValue( {string_expression} ); 
[consequence][] set value {string_expression} -> ${cell:\w+}\.entry = ${cell}.getEntry().setValue( {string_expression} ); 
[consequence][] set value {string_expression} -> ${valuable:\w+} = ${valuable}.setValue( {string_expression} ); 

#Label categorizing
[consequence][] set category {string_expression} -> ${cell:\w+}\.label\[{index:\d+}\] = ${cell}.getLabel( {index} ).setCategory( {string_expression} );
[consequence][] set category {string_expression} -> ${cell:\w+}\.label = ${cell}.getLabel().setCategory( {string_expression} );
[consequence][] set category ${category:\w+} -> ${cell:\w+}\.label\[{index:\d+}\] = ${cell}.getLabel( {index} ).setCategory( ${category} );
[consequence][] set category ${category:\w+} -> ${cell:\w+}\.label = ${cell}.getLabel().setCategory( ${category} );
[consequence][] set category {string_expression} -> ${label:\w+} = ${label}.setCategory( {string_expression} );
[consequence][] set category ${category:\w+} -> ${label:\w+} = ${label}.setCategory( ${category} );

#Label-label associating
[consequence][] set parent label ${cell1:\w+}\.label\[{index1:\d+}\] -> ${cell2:\w+}\.label\[{index2:\d+}\] = ${cell2}.getLabel( {index2} ).setParent( ${cell1}.getLabel( {index1} ) );
[consequence][] set parent label ${cell1:\w+}\.label -> ${cell2:\w+}\.label = ${cell2}.getLabel().setParent( ${cell1}.getLabel() );
[consequence][] set parent label ${cell:\w+}\.label\[{index:\d+}\] -> ${label:\w+} = ${label}.setParent( ${cell}.getLabel( {index} ) ); 
[consequence][] set parent label ${cell:\w+}\.label -> ${label:\w+} = ${label}.setParent( ${cell}.getLabel() ); 
[consequence][] set parent label ${label:\w+} -> ${cell:\w+}\.label\[{index:\d+}\] = ${cell}.getLabel( {index} ).setParent( ${label} ); 
[consequence][] set parent label ${label:\w+} -> ${cell:\w+}\.label = ${cell}.getLabel().setParent( ${label} ); 
[consequence][] set parent label ${label1:\w+} -> ${label2:\w+} = ${label2}.setParent( ${label1} );

#Label grouping
[consequence][] group ${cell1:\w+}\.label\[{index1:\d+}\] -> ${cell2:\w+}\.label\[{index2:\d+}\] = ${cell2}.getLabel( {index2} ).group( ${cell1}.getLabel( {index1} ) );
[consequence][] group ${cell1:\w+}\.label -> ${cell2:\w+}\.label = ${cell2}.getLabel().group( ${cell1}.getLabel() );
[consequence][] group ${label:\w+} -> ${cell:\w+}\.label\[{index:\d+}\] = ${cell}.getLabel( {index} ).group( ${label} );
[consequence][] group ${label:\w+} -> ${cell:\w+}\.label = ${cell}.getLabel().group( ${label} );
[consequence][] group ${cell:\w+}\.label\[{index:\d+}\] -> ${label:\w+} = ${label}.group( ${cell}.getLabel( {index} ) );
[consequence][] group ${cell:\w+}\.label -> ${label:\w+} = ${label}.group( ${cell}.getLabel() );
[consequence][] group ${label1:\w+} -> ${label2:\w+} = ${label2}.group( ${label1} );

#Entry-label associating
[consequence][] add label {label_value} from {category_name} -> ${cell:\w+}\.entry = ${cell}.getEntry().addLabel( {label_value}, {category_name} );
[consequence][] add label {label_value} from ${category} -> ${cell:\w+}\.entry = ${cell}.getEntry().addLabel( {label_value}, ${category} );
[consequence][] add label {label_value} from {category_name} -> ${entry:\w+} = ${entry}.addLabel( {label_value}, {category_name} );
[consequence][] add label {label_value} from ${category} -> ${entry:\w+} = ${entry}.addLabel( {label_value}, ${category} );
[consequence][] add label ${cell1:\w+}\.label\[{index1:\d+}\] -> ${cell2:\w+}\.entry\[{index2:\d+}\] = ${cell2}.getEntry( {index2} ).addLabel( ${cell1}.getLabel( {index1} ) );
[consequence][] add label ${label:\w+} -> ${cell:\w+}\.entry\[{index:\d+}\] = ${cell}.getEntry( {index} ).addLabel( ${label} );
[consequence][] add label ${cell:\w+}\.label\[{index:\d+}\] -> ${entry:\w+} = ${entry}.addLabel( ${cell}.getLabel( {index} ) );
[consequence][] add label ${cell1:\w+}\.label -> ${cell2:\w+}\.entry = ${cell2}.getEntry().addLabel( ${cell1}.getLabel() );
[consequence][] add label ${label:\w+} -> ${cell:\w+}\.entry = ${cell}.getEntry().addLabel( ${label} );
[consequence][] add label ${cell:\w+}\.label -> ${entry:\w+} = ${entry}.addLabel( ${cell}.getLabel() );
[consequence][] add label ${label:\w+} -> ${entry:\w+} = ${entry}.addLabel( ${label} );

#Updating facts
[consequence][] update ${cell:\w+}\.entry\[{index:\d+}\] = update ( ${cell}.getEntry( {index} ) );
[consequence][] update ${cell:\w+}\.entry = update ( ${cell}.getEntry() );
[consequence][] update ${cell:\w+}\.label\[{index:\d+}\] = update ( ${cell}.getLabel( {index} ) );
[consequence][] update ${cell:\w+}\.label = update ( ${cell}.getLabel() );
[consequence][] update ${variable:\w+} = update ( ${variable} );
[consequence][] update entry ${entry:\w+} = update ( ${entry} ); update ( ${entry}.getCell() );
[consequence][] update label ${label:\w+} = update ( ${label} ); update ( ${label}.getCell() );
[consequence][] update cell  ${cell:\w+} = 
		update ( ${cell} );\n
		for ( Iterator<CLabel> labels = ${cell}.labels(); labels.hasNext(); ) \{ update( labels.next() ); \}\n
		for ( Iterator<CEntry> enties = ${cell}.entries(); entries.hasNext(); ) \{ update( entries.next() ); \}

#Printing
[consequence][] print {string_expression} = System.out.println( {string_expression} );
[consequence][] printf {string_expression} = System.out.printf( {string_expression} );
