package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class AddLabel extends Action {

    public AddLabel(String name) {
        super(name);
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
        else return String.format("[ %s ( %s, %s ) ]", getName(), labelIdentifier.toString(), destinationIdentifier.toString());

    }
}
