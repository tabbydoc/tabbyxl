package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

public interface ActionInterface {

    String getName();

    String fetchCode();

    String toString();

    String generateCallingAction();
}
