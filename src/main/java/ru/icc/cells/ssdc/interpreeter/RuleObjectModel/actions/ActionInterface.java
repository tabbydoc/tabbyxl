package ru.icc.cells.ssdc.interpreeter.RuleObjectModel.actions;

public interface ActionInterface {

    String getName();

    String fetchCode();

    String toString();

    //String generateCallingAction();

    String generateAddSet();

    String generateExecute();
}
