package org.units.commands.rollback;

import org.units.commands.results.CommandResult;
import org.units.units.Unit;

/**
 *
 */
public interface Rollbackable<U extends Unit, R extends CommandResult> {

    default void rollback(U unit, R commandResult){
        throw new RollbackFailedException("Rollback not supported for : " + getClass().getSimpleName());
    }

}
