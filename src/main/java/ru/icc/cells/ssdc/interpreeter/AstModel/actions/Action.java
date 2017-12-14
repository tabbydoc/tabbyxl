package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import java.util.ArrayList;
import java.util.List;

public class Action implements ActionInterface {
    private String name;

    public Action(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String fetchCode() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("[ %s ]", name);
    }
}
