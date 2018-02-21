package ru.icc.cells.ssdc.engine.RuleObjectModel;

public class Variable {

    private String identifier;
    private String type;

    public Variable(String type, String identifier) {

        this.identifier = identifier;

        switch (type)
        {
            case "cell": this.type = "CCell"; break;
            case "entry": this.type = "CEntry"; break;
            case "category": this.type = "CCategory"; break;
            case "label": this.type = "CLabel"; break;
            default: this.type = type; break;
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }
}
