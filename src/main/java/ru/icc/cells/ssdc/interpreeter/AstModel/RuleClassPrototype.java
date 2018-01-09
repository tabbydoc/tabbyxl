package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.model.*;

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

        public Set_text() { previousCell = null; }

        public void eval(CCell cell, String string) {
            if(previousCell != cell) {
                cell.setText(string);
                previousCell = cell;
            }
        }
    }

    protected class Set_indent {

        private CCell previousCell;

        public Set_indent() { previousCell = null; }

        public void eval(CCell cell, int value) {
            if(previousCell != cell) {
                cell.setIndent(value);
                previousCell = cell;
            }
        }
    }

    protected class Split {

        private CCell previousCell;

        public Split() { previousCell = null; }

        public void eval(CCell cell, CTable table){
            if(previousCell != cell) {
                for(CCell c:cell.split()) {
                    table.addCell(c);
                }
                table.removeCell(cell);
                previousCell = cell;
            }
        }
    }

    protected class Merge {

        private CCell previousCell1;
        private CCell previousCell2;

        public Merge() {
            previousCell1 = null;
            previousCell2 = null;
        }

        public void eval (CCell cell1, CCell cell2, CTable table) {
            if(previousCell1 != cell1 || previousCell2 != cell2) {
                cell1.merge(cell2);
                table.removeCell(cell1);
                previousCell1 = cell1;
                previousCell2 = cell2;
            }
        }
    }

    protected class Set_mark {

        private CCell previousCell;

        public Set_mark() {
            previousCell = null;
        }

        public void eval(CCell cell, String string) {
            if(previousCell != cell) {
                cell.setMark(string);
                previousCell = cell;
            }
        }
    }

    protected class New_entry {

        private CCell previousCell;

        public New_entry() { previousCell = null; }

        public void eval(CCell cell, String string, CTable table) {
            if(previousCell != cell) {
                table.addEntry(cell.newEntry(string));
                previousCell = cell;
            }
        }

        public void eval(CCell cell, CTable table) {
            if(previousCell != cell) {
                table.addEntry(cell.newEntry());
                previousCell = cell;
            }
        }
    }

    protected class New_label {

        private CCell previousCell;

        public New_label() { previousCell = null; }

        public void eval (CCell cell, String string, CTable table) {
            if(previousCell != cell) {
                table.addLabel(cell.newLabel(string));
                previousCell = cell;
            }
        }

        public void eval (CCell cell, CTable table) {
            if(previousCell != cell) {
                table.addLabel(cell.newLabel());
                previousCell = cell;
            }
        }
    }

    protected class Set_value {

        private CValue previousVar;

        public Set_value() { previousVar = null; }

        public void eval(CValue var, String string) {
            if(previousVar != var) {
                var.setValue(string);
                previousVar = var;
            }
        }
    }

    protected class Set_category {

        private CLabel previousLabel;

        public Set_category() { previousLabel = null; }

        public void eval(CLabel label, CCategory category) {
            if(previousLabel != label) {
                label.setCategory(category);
                previousLabel = label;
            }
        }

        public void eval (CLabel label, String categoryName) {
            if(previousLabel != label) {
                label.setCategory(categoryName);
                previousLabel = label;
            }
        }
    }

    protected class Set_parent {

        private CLabel previousLabel1;
        private CLabel previousLabel2;

        public Set_parent() {
            previousLabel1 = null;
            previousLabel2 = null;
        }

        public void eval (CLabel label1, CLabel label2) {
            if(previousLabel1 != label1 || previousLabel2 != label2) {
                label2.setParent(label1);
                previousLabel1 = label1;
                previousLabel2 = label2;
            }
        }
    }

    protected class Group {

        private CLabel previousLabel1;
        private CLabel previousLabel2;

        public Group() {
            previousLabel1 = null;
            previousLabel2 = null;
        }

        public void eval(CLabel label1, CLabel label2) {
            if(previousLabel1 != label1 || previousLabel2 != label2) {
                label2.group(label1);
                previousLabel1 = label1;
                previousLabel2 = label2;
            }
        }
    }

    protected class Add_label {

        private CLabel previousLabel;
        private CEntry previousEntry;

        public Add_label() {
            previousEntry = null;
            previousLabel = null;
        }

        public void eval(CLabel label, CEntry entry) {
            if(previousLabel != label || previousEntry != entry) {
                entry.addLabel(label);
                previousLabel = label;
                previousEntry = entry;
            }
        }

        public void eval(CLabel label, CEntry entry, CCategory category) {
            if(previousLabel != label || previousEntry != entry) {
                entry.addLabel(label.getValue(), category);
                previousEntry = entry;
                previousLabel = label;
            }
        }

        public void eval(CLabel label, CEntry entry, String category) {
            if(previousLabel != label || previousEntry != entry) {
                entry.addLabel(label.getValue(), category);
                previousEntry = entry;
                previousLabel = label;
            }
        }
    }
}
