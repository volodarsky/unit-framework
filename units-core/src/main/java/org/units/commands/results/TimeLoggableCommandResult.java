package org.units.commands.results;

/**
 * Created on 23.08.2015.
 */
public class TimeLoggableCommandResult implements CommandResult {

    private final CommandResult commandResult;
    private final long timeExecuted;

    public TimeLoggableCommandResult(CommandResult commandResult, long timeExecuted) {
        this.commandResult = commandResult;
        this.timeExecuted = timeExecuted;
    }

    public CommandResult getCommandResult() {
        return commandResult;
    }

    public long getTimeExecuted() {
        return timeExecuted;
    }
}
