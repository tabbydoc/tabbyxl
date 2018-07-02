package ru.icc.cells.ssdc.crl2j.rulemodel.actions;

public interface ActionInterface {

    String getName();

    String fetchCode();

    String toString();

    //String generateCallingAction();

    String generateAddSet();

    String generateExecute();
}
