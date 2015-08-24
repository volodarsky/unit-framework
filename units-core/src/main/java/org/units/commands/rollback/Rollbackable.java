package org.units.commands.rollback;

import org.units.commands.results.CommandResult;
import org.units.units.Unit;

/**
 * @author vladimir.romanov
 * @version 1.0
 * @since UP...
 */
public interface Rollbackable<U extends Unit, R extends CommandResult> {

    void rollback(U unit, R commandResult);

}
