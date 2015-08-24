package org.units.commands.results;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 * "
 */
public interface CommandResult {

    Unit getUnit();

    Command getCommand();
}
