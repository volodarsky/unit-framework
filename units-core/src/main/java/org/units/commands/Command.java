package org.units.commands;


import org.units.commands.results.CommandResult;
import org.units.commands.rollback.Rollbackable;
import org.units.units.Unit;

/**
 * Stateless command that realize pattern Visitor (not Command!)
 */
public interface Command<U extends Unit, R extends CommandResult> extends Rollbackable<U,R>{

    /**
     * Analog of 'visit' method of pattern Visitor
     * @param unit
     * @return CommandResult subclass of this command executed on <param>unit<param/>
     */
    R execute(U unit);

    /**
     *
     * @return units classes on which this command can be executed
     */
    Class<U>[] getUnitTypes();

}
