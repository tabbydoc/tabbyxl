package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class RuleClassPrototype implements RuleClassInterface{
    private CTable table;

    public CTable getTable() {
        return table;
    }

    public RuleClassPrototype(CTable table) { this.table = table; }

   /* @Override
    public String sayHello() { return null; }
    @Override
    public void evalLHS() { }
    @Override
    public void evalRHS() { }*/

   @Override
   public void eval() {}

    protected class Set_text {

        private CCell previousCell;
        private List<Set> setList = new ArrayList<>();

        public Set_text() { previousCell = null; }

        public void add(CCell cell, String string) {
            if(previousCell != cell) {
                //cell.setText(string);
                setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if(set.cell != null)
                    set.cell.setText(set.string);
            }
        }

        private class Set {
            private CCell cell;
            private String string;

            public Set(CCell cell, String string) {
                this.cell = cell;
                this.string = string;
            }
        }
    }

    protected class Set_indent {

        private CCell previousCell;
        private List<Set> setList = new ArrayList<>();

        public Set_indent() { previousCell = null; }

        public void add(CCell cell, int value) {
            if(previousCell != cell) {
                //cell.setIndent(value);
                setList.add(new Set(cell, value));
                previousCell = cell;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if(set.cell != null) set.cell.setIndent(set.value);
            }
        }

        private class Set {
            private CCell cell;
            private int value;

            public Set(CCell cell, int value) {
                this.cell = cell;
                this.value = value;
            }
        }
    }

    protected class Split {

        private CCell previousCell;
        private List<Set> setList = new ArrayList<>();

        public Split() { previousCell = null; }

        public void add(CCell cell){
            if(previousCell != cell) {
                /*for(CCell c:cell.split()) {
                    table.addCell(c);
                }
                table.removeCell(cell);*/
                setList.add(new Set(cell));
                previousCell = cell;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if(set.cell != null) {
                    for (CCell c : set.cell.split()) {
                        table.addCell(c);
                    }
                    table.removeCell(set.cell);
                }
            }
        }

        private class Set {
            private CCell cell;
            public Set(CCell cell) {
                this.cell = cell;
            }
        }
    }

    protected class Merge {

        private CCell previousCell1;
        private CCell previousCell2;
        private List<Set> setList = new ArrayList<>();

        public Merge() {
            previousCell1 = null;
            previousCell2 = null;
        }

        public void add (CCell cell1, CCell cell2) {
            if(previousCell1 != cell1 || previousCell2 != cell2) {
                /*cell1.merge(cell2);
                table.removeCell(cell1);*/
                setList.add(new Set(cell1, cell2));
                previousCell1 = cell1;
                previousCell2 = cell2;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if(set.cell1 != null && set.cell2 != null) {
                    set.cell1.merge(set.cell2);
                    table.removeCell(set.cell1);
                }
            }
        }

        private class Set {
            private CCell cell1;
            private CCell cell2;
            public Set(CCell cell1, CCell cell2) {
                this.cell1 = cell1;
                this.cell2 = cell2;
            }
        }
    }

    protected class Set_mark {

        private CCell previousCell;
        private List<Set> setList = new ArrayList<>();

        public Set_mark() {
            previousCell = null;
        }

        public void add(CCell cell, String string) {
            if(previousCell != cell) {
                //cell.setMark(string);
                setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if(set.cell!=null) {
                    set.cell.setMark(set.string);
                }
            }
        }

        private class Set {
            private CCell cell;
            private String string;
            public Set(CCell cell, String string) {
                this.cell = cell;
                this.string = string;
            }
        }
    }

    protected class New_entry {

        private CCell previousCell;
        private List<Set> setList = new ArrayList<>();

        public New_entry() { previousCell = null; }

        public void add(CCell cell, String string) {
            if(previousCell != cell) {
                //table.addEntry(cell.newEntry(string));
                setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        public void add(CCell cell) {
            if(previousCell != cell) {
                //table.addEntry(cell.newEntry());
                setList.add(new Set(cell));
                previousCell = cell;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if(set.cell!=null) {
                    if (set.string != null) {
                        table.addEntry(set.cell.newEntry(set.string));
                        //set.cell.newEntry(set.string);
                    } else {
                        table.addEntry(set.cell.newEntry());
                        //set.cell.newEntry();
                    }
                }
            }
        }

        private class Set {
            private CCell cell;
            private String string;

            public Set(CCell cell) {
                this.cell = cell;
            }

            public Set(CCell cell, String string) {
                this.cell = cell;
                this.string = string;
            }
        }
    }

    protected class New_label {

        private CCell previousCell;
        private List<Set> setList = new ArrayList<>();

        public New_label() { previousCell = null; }

        public void add (CCell cell, String string) {
            if(previousCell != cell) {
                //table.addLabel(cell.newLabel(string));
                //cell.newLabel(string);
                setList.add(new Set(cell, string));
                previousCell = cell;
            }
        }

        public void add (CCell cell) {
            if(previousCell != cell) {
                //table.addLabel(cell.newLabel());
                //cell.newLabel();
                setList.add(new Set(cell));
                previousCell = cell;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if (set.cell != null) {
                    if (set.string != null) {
                        table.addLabel(set.cell.newLabel(set.string));
                    } else {
                        table.addLabel(set.cell.newLabel());
                    }
                }
            }
        }

        private class Set {
            private CCell cell;
            private String string;

            public Set(CCell cell) {
                this.cell = cell;
            }

            public Set(CCell cell, String string) {
                this.cell = cell;
                this.string = string;
            }
        }
    }

    protected class Set_value {

        private CValue previousVar;
        private List<Set> setList = new ArrayList<>();

        public Set_value() { previousVar = null; }

        public void add(CValue var, String value) {
            if(previousVar != var) {
                //var.setValue(string);
                setList.add(new Set(var, value));
                previousVar = var;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if (set.var != null) {
                    set.var.setValue(set.value);
                }
            }
        }

        private class Set {
            private CValue var;
            private String value;

            public Set(CValue var, String value) {
                this.var = var;
                this.value = value;
            }
        }
    }

    protected class Set_category {

        private CLabel previousLabel;
        private List<Set> setList = new ArrayList<>();

        public Set_category() { previousLabel = null; }

        public void add(CLabel label, CCategory category) {
            if(previousLabel != label) {
                //label.setCategory(category);
                setList.add(new Set(label, category));
                previousLabel = label;
            }
        }

        public void add (CLabel label, String categoryName) {
            if(previousLabel != label) {
                //label.setCategory(categoryName);
                setList.add(new Set(label, categoryName));
                previousLabel = label;
            }
        }

        public void execute() {
            for(Set set:setList) {
                if (set.label != null) {
                    if (set.type == 1) {
                        set.label.setCategory(set.category);
                    } else if (set.type == 2) {
                        set.label.setCategory(set.categoryName);
                    }
                }
            }
        }

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
    }

    protected class Set_parent {

        private CLabel previousLabel1;
        private CLabel previousLabel2;
        private List<Set> sets = new ArrayList<>();

        public Set_parent() {
            previousLabel1 = null;
            previousLabel2 = null;
        }

        public void add (CLabel label1, CLabel label2) {
            if(previousLabel1 != label1 || previousLabel2 != label2) {
                //label2.setParent(label1);
                sets.add(new Set(label1, label2));
                previousLabel1 = label1;
                previousLabel2 = label2;
            }
        }

        public void execute() {
            for(Set set:sets) {
                if(set.label1 != null && set.label2 != null)
                    set.label2.setParent(set.label1);
            }
        }

        private class Set {
            private CLabel label1;
            private CLabel label2;

            public Set(CLabel label1, CLabel label2) {
                this.label1 = label1;
                this.label2 = label2;
            }
        }
    }

    protected class Group {

        private CLabel previousLabel1;
        private CLabel previousLabel2;
        private List<Set> sets = new ArrayList<>();

        public Group() {
            previousLabel1 = null;
            previousLabel2 = null;
        }

        public void add(CLabel label1, CLabel label2) {
            if(previousLabel1 != label1 || previousLabel2 != label2) {
                //label2.group(label1);
                sets.add(new Set(label1, label2));
                previousLabel1 = label1;
                previousLabel2 = label2;
            }
        }

        public void execute() {
            for(Set set:sets) {
                if (set.label1 != null && set.label2 != null) {
                    set.label2.group(set.label1);
                }
            }
        }

        private class Set {
            private CLabel label1;
            private CLabel label2;

            public Set(CLabel label1, CLabel label2) {
                this.label1 = label1;
                this.label2 = label2;
            }
        }
    }

    protected class Add_label {

        private CLabel previousLabel;
        private CEntry previousEntry;
        private List<Set> sets = new ArrayList<>();

        public Add_label() {
            previousEntry = null;
            previousLabel = null;
        }

        public void add(CLabel label, CEntry entry) {
            if(previousLabel != label || previousEntry != entry) {
                //entry.addLabel(label);
                sets.add(new Set(label, entry));
                previousLabel = label;
                previousEntry = entry;
            }
        }

        public void add(CLabel label, CEntry entry, CCategory category) {
            if(previousLabel != label || previousEntry != entry) {
                //entry.addLabel(label.getValue(), category);
                sets.add(new Set(label, entry, category));
                previousEntry = entry;
                previousLabel = label;
            }
        }

        public void add(CLabel label, CEntry entry, String categoryName) {
            if(previousLabel != label || previousEntry != entry) {
                //entry.addLabel(label.getValue(), category);
                sets.add(new Set(label, entry, categoryName));
                previousEntry = entry;
                previousLabel = label;
            }
        }

        public void execute() {
            for(Set set:sets) {
                if(set.label != null && set.entry != null) {
                    switch (set.type) {
                        case 1:
                            set.entry.addLabel(set.label);
                        case 2:
                            if(set.category != null) set.entry.addLabel(set.label.getValue(), set.category);
                        case 3:
                            if(set.categoryName != null) set.entry.addLabel(set.label.getValue(), set.categoryName);
                    }
                }
            }
        }

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
    }
}
