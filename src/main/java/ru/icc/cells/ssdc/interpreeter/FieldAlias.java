package ru.icc.cells.ssdc.interpreeter;

import java.util.HashMap;
import java.util.Map;

public class FieldAlias {
    private Map<String, String> aliases = new HashMap<>();

    public Map<String, String> getAliases() {
        return aliases;
    }

    public FieldAlias()
    {
        aliases.put("cl", "getCl");
        aliases.put("cr", "getCr");
        aliases.put("rt", "getRt");
        aliases.put("rb", "getRb");
        aliases.put("blank", "isBlank");
        aliases.put("marked", "isMarked");
        aliases.put("mark", "getMark");
        aliases.put("label", "getLabel");
        aliases.put("entry", "getEntry");
        aliases.put("text", "getText");
    }
}
