package org.units.commands;


import org.units.units.Unit;

/**
 *
 */
public interface Command<U extends Unit,R> extends UnitVisitor<U>{

    void execute();

    void setResult(R result);

}
