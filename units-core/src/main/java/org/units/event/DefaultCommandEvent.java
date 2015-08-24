package org.units.event;

import org.units.commands.results.CommandResult;

/**
 * @author vladimir.romanov
 * @version 1.0
 * @since UP...
 */
public class DefaultCommandEvent implements CommandEvent {

    private final CommandResult commandResult;

    public DefaultCommandEvent(CommandResult commandResult) {
        this.commandResult = commandResult;
    }

    @Override
    public CommandResult getCommandResult() {
        return commandResult;
    }
}
