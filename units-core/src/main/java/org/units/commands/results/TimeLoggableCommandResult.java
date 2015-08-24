package org.units.commands.results;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 * Created on 23.08.2015.
 */
public class TimeLoggableCommandResult extends DefaultCommandResult {

    private final CommandResult commandResult;
    private final long timeExecuted;

    public TimeLoggableCommandResult(Unit unit, Command command, CommandResult commandResult, long timeExecuted) {
        super(unit, command);
        this.commandResult = commandResult;
        this.timeExecuted = timeExecuted;
    }

    public CommandResult getCommandResult() {
        return commandResult;
    }

    public long getTimeExecuted() {
        return timeExecuted;
    }

    @Override
    public String toString() {
        return "TimeLoggableCommandResult{" +
                "commandResult=" + commandResult +
                ", timeExecuted=" + timeExecuted +
                '}';
    }
}
