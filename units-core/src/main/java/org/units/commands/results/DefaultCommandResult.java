package org.units.commands.results;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 * "
 */
public class DefaultCommandResult implements CommandResult {

    private final Unit unit;
    private final Command command;

    public DefaultCommandResult(Unit unit, Command command) {
        this.unit = unit;
        this.command = command;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public Command getCommand() {
        return command;
    }


    @Override
    public String toString() {
        return "DefaultCommandResult{" +
                        "unit=" + unit +
                        ", command=" + command +
                        '}';
    }
}
