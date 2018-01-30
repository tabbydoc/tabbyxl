package ru.icc.cells.ssdc.interpreeter.RuleObjectModel.actions;

import ru.icc.cells.ssdc.interpreeter.RuleObjectModel.Identifier;

public class AddLabel extends Action {

    public AddLabel(int id, String name) {
        super(id, name);
    }

    private Identifier labelIdentifier;

    public void setLabelIdentifier(Identifier labelIdentifier) {
        this.labelIdentifier = labelIdentifier;
    }

    public Identifier getLabelIdentifier() {
        return labelIdentifier;
    }

    private Identifier categoryIdentifier;

    public void setCategoryIdentifier(Identifier categoryIdentifier) {
        this.categoryIdentifier = categoryIdentifier;
    }

    public Identifier getCategoryIdentifier() {
        return categoryIdentifier;
    }

    private Identifier destinationIdentifier;

    public void setDestinationIdentifier(Identifier destinationIdentifier) {
        this.destinationIdentifier = destinationIdentifier;
    }

    public Identifier getDestinationIdentifier() {
        return destinationIdentifier;
    }

    @Override
    public String toString() {

        if(categoryIdentifier != null) return String.format("[ %s ( %s, %s, %s ) ]", getName(), labelIdentifier.toString(), categoryIdentifier.toString(), destinationIdentifier.toString());
        else return String.format("[ %d %s ( %s, %s ) ]", getId(), getName(), labelIdentifier.toString(), destinationIdentifier.toString());

    }

    @Override
    public String generateAddSet () {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(labelIdentifier.getNormalForm()).append(", ").append(destinationIdentifier.getNormalForm());

        if(categoryIdentifier != null) code.append(", ").append(categoryIdentifier.getNormalForm());

        code.append(" )");

        return code.toString();
    }
}
