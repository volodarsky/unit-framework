package org.units.commands.rollback;

/**
 *
 */
public class RollbackFailedException extends RuntimeException{

    public RollbackFailedException(String message) {
        super(message);
    }
}
