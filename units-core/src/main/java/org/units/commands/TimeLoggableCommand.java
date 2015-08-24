package org.units.commands;

import org.units.commands.results.CommandResult;
import org.units.commands.results.TimeLoggableCommandResult;
import org.units.units.Unit;

/**
 * Decorator for time measurement of wrapping command
 */
public class TimeLoggableCommand implements Command {

    private final Command measuredCommand;

    public TimeLoggableCommand(Command measuredCommand) {
        this.measuredCommand = measuredCommand;
    }

    public Command getMeasuredCommand() {
        return measuredCommand;
    }

    @Override
    public CommandResult execute(Unit unit) {
        final long start = System.currentTimeMillis();
        CommandResult commandResult = measuredCommand.execute(unit);
        return new TimeLoggableCommandResult(unit, this, commandResult,System.currentTimeMillis() - start);
    }

    @Override
    public Class[] getUnitTypes() {
        return measuredCommand.getUnitTypes();
    }


    @Override public String toString() {
        return "TimeLoggableCommand{" +
                        "measuredCommand=" + measuredCommand +
                        '}';
    }
}
