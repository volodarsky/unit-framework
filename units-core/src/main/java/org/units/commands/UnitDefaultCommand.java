package org.units.commands;

import org.units.commands.results.CommandResult;
import org.units.units.Unit;

/**
 *
 */
public abstract class UnitDefaultCommand<U extends Unit, R extends CommandResult> implements Command<U, R> {

    public UnitDefaultCommand() {
    }

}
