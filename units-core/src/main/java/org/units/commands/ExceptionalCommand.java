package org.units.commands;

import org.units.commands.results.CommandResult;
import org.units.commands.results.FailedCommandResult;
import org.units.units.Unit;

/**
 * Decorator for time measurement of wrapping command
 */
class ExceptionalCommand implements Command {

    private Command wrappedCommand;

    public ExceptionalCommand(Command wrappedCommand) {
        this.wrappedCommand = wrappedCommand;
    }

    public Command getWrappedCommand() {
        return wrappedCommand;
    }

    @Override
    public CommandResult execute(Unit unit) {
        try {
            return wrappedCommand.execute(unit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FailedCommandResult failedCommandResult = new FailedCommandResult(unit, this, e.getMessage());
            failedCommandResult.setException(e);
            return failedCommandResult;
        }
    }

    @Override
    public Class[] getUnitTypes() {
        return wrappedCommand.getUnitTypes();
    }


    @Override
    public String toString() {
        return "ExceptionalCommand{" +
                        "wrappedCommand=" + wrappedCommand +
                        '}';
    }
}
