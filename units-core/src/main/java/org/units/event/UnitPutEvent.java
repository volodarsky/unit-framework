package org.units.event;

import org.units.commands.results.CommandResult;

/**
 * "
 */
public class UnitPutEvent extends DefaultCommandEvent{

    public UnitPutEvent(CommandResult commandResult) {
        super(commandResult);
    }

}
