package ru.icc.cells.ssdc.interpreeter.AstModel;

public class RuleVariable {
    private String name;
    private String type;
    public RuleVariable(String type, String name)
    {
        this.name = name;
        switch (type)
        {
            case "cell": this.type = "CCell"; break;
            case "entry": this.type = "CEntry"; break;
            case "category": this.type = "CCategory"; break;
            case "label": this.type = "CLabel"; break;
            default: this.type = type; break;
        }
    }
    public String getName() { return name; }
    public String getType() { return type; }
}
