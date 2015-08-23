package org.units.commands.results;

import org.units.units.Unit;

/**
 * Created on 23.08.2015.
 */
public class DefaultCommandResult implements CommandResult {

    private Unit unit;

    @Override
    public Unit getUnit() {
        return unit;
    }
}
