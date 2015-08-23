package org.units.commands.results;

/**
 * Created on 23.08.2015.
 */
public class FailedCommandResult implements CommandResult{

    private final String cause;
    private Exception exception;

    public FailedCommandResult(String cause) {
        this.cause = cause;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
