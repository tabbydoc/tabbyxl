# Copyright 2015-18 Alexey O. Shigarov (shigarov@icc.ru)
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
[condition][] cell {cell:\S+}\s*: {constraints} = {cell}: CCell({constraints});
[condition][] cell {cell:\S+} = {cell} : CCell();

#Entry querying
[condition][] entry {entry:\S+}\s*: {constraints} = {entry}: CEntry({constraints});
[condition][] entry {entry:\S+} = {entry} : CEntry();

#Label querying
[condition][] label {label:\S+}\s*: {constraints} = {label}: CLabel({constraints});
[condition][] label {label:\S+} = {label} : CLabel();

#Category querying
[condition][] category {category:\S+}\s*: {constraints} = {category}: CCategory({constraints});
[condition][] category {category:\S+} = {category}: CCategory();

#Not exists
[condition][] no cells\s*: {constraints} = not (exists CCell ({constraints}));
[condition][] no entries\s*: {constraints} = not (exists CEntry ({constraints}));
[condition][] no labels\s*: {constraints} = not (exists CLabel ({constraints}));
[condition][] no categories\s*: {constraints} = not (exists CCategory ({constraints}));

#Text editing
[consequence][] set text {string_expression} to {cell:\S+} = {cell}.setText({string_expression});

#Indent editing
[consequence][] set indent {integer:\d+} to {cell:\S+} = {cell}.setIndent({integer});

#Cell splitting
[consequence][] split {cell:\S+} = for (CCell cell: {cell}.split()) \{ insert(cell); \}; retract({cell});

#Cell merging
[consequence][] merge {cell1:\S+} with {cell2:\S+} = {cell1}.merge({cell2}); retract({cell1});

#Cell tagging
[consequence][] set tag {string_expression} to {cell:\S+} = {cell}.setTag({string_expression});

#Entry creating 
[consequence][] new entry {cell:\S+} as {string_expression} = insert({cell}.newEntry({string_expression}));
[consequence][] new entry {cell:\S+} = insert({cell}.newEntry());

#Label creating
[consequence][] new label {cell:\S+} as {string_expression} = insert({cell}.newLabel({string_expression}));
[consequence][] new label {cell:\S+} = insert({cell}.newLabel());

#Value editing
[consequence][] set value {string_expression} to {cell:\S+}\.label\[{id:\d+}\] = {cell}.getLabel({id}).setValue({string_expression});
[consequence][] set value {string_expression} to {cell:\S+}\.label = {cell}.getLabel().setValue({string_expression}); 
[consequence][] set value {string_expression} to {cell:\S+}\.entry\[{id:\d+}\] = {cell}.getEntry({id}).setValue({string_expression});
[consequence][] set value {string_expression} to {cell:\S+}\.entry = {cell}.getEntry().setValue({string_expression}); 
[consequence][] set value {string_expression} to {valuable:\S+} = {valuable}.setValue({string_expression}); 

#Label categorizing
[consequence][] set category {category} to {cell:\S+}\.label\[{id:\d+}\] = {cell}.getLabel({id}).setCategory({category});
[consequence][] set category {category} to {cell:\S+}\.label = {cell}.getLabel().setCategory({category});
[consequence][] set category {category} to {label:\S+} = {label}.setCategory({category});

#Label-label associating
[consequence][] set parent {cell1:\S+}\.label\[{index1:\d+}\] to {cell2:\S+}\.label\[{index2:\d+}\] = {cell2}.getLabel({index2}).setParent({cell1}.getLabel({index1}));
[consequence][] set parent {cell1:\S+}\.label to {cell2:\S+}\.label = {cell2}.getLabel().setParent({cell1}.getLabel());
[consequence][] set parent {cell:\S+}\.label\[{id:\d+}\] to {label:\S+} = {label}.setParent({cell}.getLabel({id}));
[consequence][] set parent {cell:\S+}\.label to {label:\S+} = {label}.setParent({cell}.getLabel()); 
[consequence][] set parent {label:\S+} to {cell:\S+}\.label\[{id:\d+}\] = {cell}.getLabel({id}).setParent({label});
[consequence][] set parent {label:\S+} to {cell:\S+}\.label = {cell}.getLabel().setParent({label}); 
[consequence][] set parent {label1:\S+} to {label2:\S+} = {label2}.setParent({label1});

#Label grouping
[consequence][] group {cell1:\S+}\.label\[{index1:\d+}\] with {cell2:\S+}\.label\[{index2:\d+}\] = {cell2}.getLabel({index2}).group(${cell1}.getLabel({index1}));
[consequence][] group {cell1:\S+}\.label with {cell2:\S+}\.label = {cell2}.getLabel().group({cell1}.getLabel());
[consequence][] group {label:\S+} with {cell:\S+}\.label\[{id:\d+}\] = {cell}.getLabel({id}).group({label});
[consequence][] group {label:\S+} with {cell:\S+}\.label = {cell}.getLabel().group({label});
[consequence][] group {cell:\S+}\.label\[{id:\d+}\] with {label:\S+} = {label}.group({cell}.getLabel({id}));
[consequence][] group {cell:\S+}\.label with {label:\S+} = {label}.group({cell}.getLabel());
[consequence][] group {label1:\S+} with {label2:\S+} = {label2}.group({label1});

#Entry-label associating
[consequence][] add label {label_value} of {category} to {cell:\S+}\.entry = {cell}.getEntry().addLabel({label_value}, {category});
[consequence][] add label {label_value} of {category} to {entry:\S+} = {entry}.addLabel({label_value}, {category});
[consequence][] add label {cell1:\S+}\.label\[{index1:\d+}\] to {cell2:\S+}\.entry\[{index2:\d+}\] = {cell2}.getEntry({index2}).addLabel({cell1}.getLabel({index1}));
[consequence][] add label {label:\S+} to {cell:\S+}\.entry\[{id:\d+}\] = {cell}.getEntry({id}).addLabel({label});
[consequence][] add label {cell:\S+}\.label\[{id:\d+}\] to {entry:\S+} = {entry}.addLabel({cell}.getLabel({id}));
[consequence][] add label {cell1:\S+}\.label to {cell2:\S+}\.entry = {cell2}.getEntry().addLabel({cell1}.getLabel());
[consequence][] add label {label:\S+} to {cell:\S+}\.entry = {cell}.getEntry().addLabel({label});
[consequence][] add label {cell:\S+}\.label to {entry:\S+} = {entry}.addLabel({cell}.getLabel());
[consequence][] add label {label:\S+} to {entry:\S+} = {entry}.addLabel({label});

#Updating facts
[consequence][] update {cell:\S+}\.entry\[{id:\d+}\] = update({cell}.getEntry({id}));
[consequence][] update {cell:\S+}\.entry = update({cell}.getEntry());
[consequence][] update {cell:\S+}\.label\[{id:\d+}\] = update({cell}.getLabel({id}));
[consequence][] update {cell:\S+}\.label = update({cell}.getLabel());
[consequence][] update {variable:\S+} = update({variable});
[consequence][] update entry {entry:\S+} = update({entry}); update({entry}.getCell());
[consequence][] update label {label:\S+} = update({label}); update({label}.getCell());
[consequence][] update cell  {cell:\S+} = update({cell});\n
		for (Iterator<CLabel> labels = {cell}.labels(); labels.hasNext();) \{ update(labels.next()); \}\n
		for (Iterator<CEntry> enties = {cell}.entries(); entries.hasNext();) \{ update(entries.next()); \}

#Printing
[consequence][] print {string_expression} = System.out.println({string_expression});
[consequence][] printf {string_expression} = System.out.printf({string_expression});
