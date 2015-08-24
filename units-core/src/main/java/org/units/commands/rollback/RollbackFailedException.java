package org.units.commands.rollback;

/**
 * @author vladimir.romanov
 * @version 1.0
 * @since UP...
 */
public class RollbackFailedException extends RuntimeException{

    public RollbackFailedException(String message) {
        super(message);
    }
}
