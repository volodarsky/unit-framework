package org.units.event;

import org.units.commands.results.CommandResult;
import org.units.units.Unit;

/**
 * Created on 23.08.2015.
 */
public class UnitPutEvent extends DefaultCommandEvent{

    public UnitPutEvent(CommandResult commandResult) {
        super(commandResult);
    }

}
