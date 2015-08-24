package org.units.commands;


import org.units.commands.results.CommandResult;
import org.units.units.Unit;

/**
 *
 */
public interface Command<U extends Unit, R extends CommandResult> {

    R execute(U unit);

    Class<U>[] getUnitTypes();

}
