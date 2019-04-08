/*
 * Copyright 2018 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl.crl2j.synthesis;

import ru.icc.td.tabbyxl.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class RuleProgramPrototype implements RuleProgramInterface {

    private CTable table;

    public CTable getTable() {
        return table;
    }

    public RuleProgramPrototype(CTable table) { this.table = table; }

   /* @Override
    public String sayHello() { return null; }
    @Override
    public void evalLHS() { }
    @Override
    public void evalRHS() { }*/

   @Override
   public void eval() {}

    protected class SetTextAction {

        private CCell previousCell;
        //private List<Set> setList = new ArrayList<>();


        public SetTextAction() {
            previousCell = null;
        }


        public void add(CCell cell, String string) {
            if(previousCell != cell) {
                cell.setText(string);
                //setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        /*
        public void execute() {
            for(Set set:setList) {
                //if(set.cell != null)
                set.cell.setText(set.string);
            }
        }
        */
        /*
        private class Set {
            private CCell cell;
            private String string;

            public Set(CCell cell, String string) {
                this.cell = cell;
                this.string = string;
            }
        }
        */
    }

    protected class SetIndentAction {

        private CCell previousCell;
        //private List<Set> setList = new ArrayList<>();


        public SetIndentAction() {
            previousCell = null;
        }


        public void add(CCell cell, int value) {
            if (previousCell != cell) {
                cell.setIndent(value);
                //setList.add(new Set(cell, value));
                previousCell = cell;
            }
        }

        /*
        public void execute() {
            for(Set set:setList) {
                //if(set.cell != null)
                set.cell.setIndent(set.value);
            }
        }
        */
        /*
        private class Set {
            private CCell cell;
            private int value;

            public Set(CCell cell, int value) {
                this.cell = cell;
                this.value = value;
            }
        }
        */
    }

    protected class SplitAction {

        private CCell previousCell;
        //private List<Set> setList = new ArrayList<>();


        public SplitAction() {
            previousCell = null;
        }


        public void add(CCell cell){
            if (previousCell != cell) {
                for(CCell c:cell.split()) {
                    table.addCell(c);
                }
                table.removeCell(cell);
                //setList.add(new Set(cell));
                previousCell = cell;
            }
        }

        /*
        public void execute() {
            for(Set set:setList) {
                //if(set.cell != null) {
                    for (CCell c : set.cell.split()) {
                        getTable().addCell(c);
                    }
                    getTable().removeCell(set.cell);
                }
                //}
        }
        */
        /*
        private class Set {
            private CCell cell;
            public Set(CCell cell) {
                this.cell = cell;
            }
        }
        */
    }

    protected class MergeAction {

        private CCell previousCell1;
        private CCell previousCell2;
        //private List<Set> setList = new ArrayList<>();


        public MergeAction() {
            previousCell1 = null;
            previousCell2 = null;
        }


        public void add (CCell cell1, CCell cell2) {
            if (previousCell1 != cell1 || previousCell2 != cell2) {
                cell1.merge(cell2);
                table.removeCell(cell1);
                //setList.add(new Set(cell1, cell2));
                previousCell1 = cell1;
                previousCell2 = cell2;
            }
        }

        /*
        public void execute() {
            for(Set set:setList) {
                    //if(set.cell1 != null && set.cell2 != null) {
                    set.cell1.merge(set.cell2);
                    getTable().removeCell(set.cell1);

                }
                //}
        }
        */
        /*
        private class Set {
            private CCell cell1;
            private CCell cell2;

            public Set(CCell cell1, CCell cell2) {
                this.cell1 = cell1;
                this.cell2 = cell2;
            }
        }
        */
    }

    protected class SetMarkAction {

        private CCell previousCell;
        //private List<Set> setList = new ArrayList<>();


        public SetMarkAction() {
            previousCell = null;
        }


        public void add(CCell cell, String string) {
            if (previousCell != cell) {
                cell.setMark(string);
                //setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        /*
        public void execute() {
            for(Set set:setList) {
                    //if(set.cell!=null) {
                    set.cell.setMark(set.string);
                    previousCell = set.cell;
                //}
            }
        }
        */
        /*
        private class Set {
            private CCell cell;
            private String string;
            public Set(CCell cell, String string) {
                this.cell = cell;
                this.string = string;
            }
        }
        */
    }

    protected class NewEntryAction {

        private CCell previousCell;
        //private List<Set> setList = new ArrayList<>();


        public NewEntryAction() {
            previousCell = null;
        }


        public void add(CCell cell, String string) {
            if (previousCell != cell) {
                table.addEntry(cell.newEntry(string));
                //setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        public void add(CCell cell) {
            if (previousCell != cell) {
                table.addEntry(cell.newEntry());
                //setList.add(new Set(cell));
                previousCell = cell;
            }
        }

        /*
        public void execute() {
            previousCell = null;

            for(Set set:setList) {
                    //if(set.cell!=null) {
                    if (set.type == 2) {
                        table.addEntry(set.cell.newEntry(set.string));
                        //set.cell.newEntry(set.string);
                    } else if (set.type == 1) {
                        table.addEntry(set.cell.newEntry());
                        //set.cell.newEntry();
                    }
                    previousCell = set.cell;
                //}
            }
        }
        */
        /*
        private class Set {
            private CCell cell;
            private String string;
            private int type;

            public Set(CCell cell) {
                this.type = 1;
                this.cell = cell;
            }

            public Set(CCell cell, String string) {
                this.type = 2;
                this.cell = cell;
                this.string = string;
            }
        }
        */
    }

    protected class NewLabelAction {

        private CCell previousCell;
        //private List<Set> setList = new ArrayList<>();


        public NewLabelAction() {
            previousCell = null;
        }


        public void add(CCell cell, String string) {
            if (previousCell != cell) {
                table.addLabel(cell.newLabel(string));
                //cell.newLabel(string);
                //setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        public void add(CCell cell) {
            if (previousCell != cell) {
                table.addLabel(cell.newLabel());
                //cell.newLabel();
                //setList.add(new Set(cell));
                previousCell = cell;
            }
        }

        /*
        public void execute() {
            previousCell = null;

            for(Set set:setList) {
                    //if (set.cell != null) {
                    if (set.type == 2) {
                        table.addLabel(set.cell.newLabel(set.string));
                    } else if (set.type == 1) {
                        table.addLabel(set.cell.newLabel());
                    }
                //}
            }
        }
        */
        /*
        private class Set {
            private CCell cell;
            private String string;
            private int type;

            public Set(CCell cell) {
                this.type = 1;
                this.cell = cell;
            }

            public Set(CCell cell, String string) {
                this.type = 2;
                this.cell = cell;
                this.string = string;
            }
        }
        */
    }

    protected class SetValueAction {

        private CValue previousVar;
        //private List<Set> setList = new ArrayList<>();


        public SetValueAction() {
            previousVar = null;
        }


        public void add(CValue var, String value) {
            if (previousVar != var) {
                var.setValue(value);
                //setList.add(new Set(var, value));
                previousVar = var;
            }
        }

        /*
        public void execute() {
            for(Set set:setList) {
                    //if (set.var != null) {
                    set.var.setValue(set.value);
                    previousVar = set.var;
                //}
            }
        }
        */
        /*
        private class Set {
            private CValue var;
            private String value;

            public Set(CValue var, String value) {
                this.var = var;
                this.value = value;
            }
        }
        */
    }

    protected class SetCategoryAction {

        private CLabel previousLabel;
        //private List<Set> setList = new ArrayList<>();


        public SetCategoryAction() {
            previousLabel = null;
        }


        public void add(CLabel label, CCategory category) {
            if (previousLabel != label) {
                label.setCategory(category);
                //setList.add(new Set(label, category));
                previousLabel = label;
            }
        }

        public void add(CLabel label, String categoryName) {
            if (previousLabel != label) {
                label.setCategory(categoryName);
                //setList.add(new Set(label, categoryName));
                previousLabel = label;
            }
        }

        /*
        public void execute() {
            previousLabel = null;
            for(Set set:setList) {
                    //if (set.label != null) {
                    if (set.type == 1) {
                        set.label.setCategory(set.category);
                    } else if (set.type == 2) {
                        set.label.setCategory(set.categoryName);
                    }
                //}
            }
        }
        */

        /*
        private class Set {
            private CLabel label;
            private CCategory category;
            private String categoryName;
            private int type;

            public Set(CLabel label, CCategory category) {
                this.type = 1;
                this.label = label;
                this.category = category;
            }

            public Set(CLabel label, String categoryName) {
                this.type = 2;
                this.label = label;
                this.categoryName = categoryName;
            }
        }
        */
    }

    protected class SetParentAction {

        private CLabel previousLabel1;
        private CLabel previousLabel2;
        //private List<Set> sets = new ArrayList<>();


        public SetParentAction() {
            previousLabel1 = null;
            previousLabel2 = null;
        }


        public void add (CLabel label1, CLabel label2) {
            if(previousLabel1 != label1 || previousLabel2 != label2) {
                label2.setParent(label1);
                //sets.add(new Set(label1, label2));
                previousLabel1 = label1;
                previousLabel2 = label2;
            }
        }

        /*
        public void execute() {
            previousLabel1 = null;
            previousLabel2 = null;
            for(Set set:sets) {
                if(previousLabel1 != set.label1 || previousLabel2 != set.label2) {
                    //if(set.label1 != null && set.label2 != null)
                        set.label2.setParent(set.label1);

                    previousLabel1 = set.label1;
                    previousLabel2 = set.label2;
                }
            }
        }
        */

        /*
        private class Set {
            private CLabel label1;
            private CLabel label2;

            public Set(CLabel label1, CLabel label2) {
                this.label1 = label1;
                this.label2 = label2;
            }
        }
        */
    }

    public class GroupAction {

        private CLabel previousLabel1;
        private CLabel previousLabel2;
        //private List<Set> sets = new ArrayList<>();

        /*
        public GroupAction() {
            //previousLabel1 = null;
            //previousLabel2 = null;
        }
        */


        public void add(CLabel label1, CLabel label2) {
            if(previousLabel1 != label1 || previousLabel2 != label2) {
                label2.group(label1);
                //sets.add(new Set(label1, label2));
                previousLabel1 = label1;
                previousLabel2 = label2;
            }
        }

        /*
        public void execute() {

            for(Set set:sets) {
                    //if (set.label1 != null && set.label2 != null) {
                    set.label2.group(set.label1);

                  //}
            }
        }
        */
        /*
        private class Set {
            private CLabel label1;
            private CLabel label2;

            public Set(CLabel label1, CLabel label2) {
                this.label1 = label1;
                this.label2 = label2;
            }
        }
        */
    }

    protected class AddLabelAction {

        private CLabel previousLabel;
        private CEntry previousEntry;
        //private List<Set> sets = new ArrayList<>();


        public AddLabelAction() {
            previousEntry = null;
            previousLabel = null;
        }


        public void add(CLabel label, CEntry entry) {
            if(previousLabel != label || previousEntry != entry) {
                entry.addLabel(label);
                //sets.add(new Set(label, entry));
                previousLabel = label;
                previousEntry = entry;
            }
        }

        public void add(CLabel label, CEntry entry, CCategory category) {
            if(previousLabel != label || previousEntry != entry) {
                entry.addLabel(label.getValue(), category);
                //sets.add(new Set(label, entry, category));
                previousEntry = entry;
                previousLabel = label;
            }
        }

        public void add(CLabel label, CEntry entry, String categoryName) {
            if(previousLabel != label || previousEntry != entry) {
                entry.addLabel(label.getValue(), categoryName);
                //sets.add(new Set(label, entry, categoryName));
                previousEntry = entry;
                previousLabel = label;
            }
        }

        /*
        public void execute() {
            previousLabel = null;
            previousEntry = null;

            for(Set set:sets) {
                    //if(set.label != null && set.entry != null) {
                    switch (set.type) {
                        case 1:
                            set.entry.addLabel(set.label);
                            break;
                        case 2:
                            if (set.category != null) set.entry.addLabel(set.label.getValue(), set.category);
                            break;
                        case 3:
                            if (set.categoryName != null) set.entry.addLabel(set.label.getValue(), set.categoryName);
                            break;
                    }
                //}
            }
        }
        */

        /*
        private class Set {
            private CLabel label;
            private CEntry entry;
            private CCategory category;
            private String categoryName;
            private int type;

            public Set(CLabel label, CEntry entry) {
                this.type = 1;
                this.label = label;
                this.entry = entry;
            }

            public Set(CLabel label, CEntry entry, CCategory category) {
                this.type = 2;
                this.label = label;
                this.entry = entry;
                this.category = category;
            }

            public Set(CLabel label, CEntry entry, String categoryName) {
                this.type = 3;
                this.label = label;
                this.entry = entry;
                this.categoryName = categoryName;
            }
        }
        */
    }
}
