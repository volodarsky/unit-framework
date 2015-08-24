package org.units.commands.results;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 * Created on 23.08.2015.
 */
public interface CommandResult {

    Unit getUnit();

    Command getCommand();
}
