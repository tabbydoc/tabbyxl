package ru.icc.cells.ssdc.interpreeter.AstModel;

public class RuleVariable {

    private Identifier identifier;
    private String type;

    public RuleVariable(String type, Identifier identifier) {

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

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }
}
