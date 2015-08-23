package org.units.commands;

import org.units.commands.Command;
import org.units.commands.UnitDefaultCommand;
import org.units.commands.results.CommandResult;
import org.units.commands.results.TimeLoggableCommandResult;
import org.units.units.Unit;

/**
 * Decorator for time measurement of wrapping command
 */
class TimeLoggableCommand extends UnitDefaultCommand {

    private final Command measuredCommand;

    public TimeLoggableCommand(Command measuredCommand) {
        this.measuredCommand = measuredCommand;
    }


    @Override
    public CommandResult execute(Unit unit) {
        final long start = System.currentTimeMillis();
        CommandResult commandResult = measuredCommand.execute(unit);
        return new TimeLoggableCommandResult(commandResult,System.currentTimeMillis() - start);
    }

    @Override
    public Class[] getUnitTypes() {
        return measuredCommand.getUnitTypes();
    }


}
