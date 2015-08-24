package org.units.commands.results;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 * Created on 23.08.2015.
 */
public class FailedCommandResult extends DefaultCommandResult{

    private final String cause;
    private Exception exception;

    public FailedCommandResult(Unit unit, Command command, String cause) {
        super(unit, command);
        this.cause = cause;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }


    @Override
    public String toString() {
        return "FailedCommandResult{" +
                        "cause='" + cause + '\'' +
                        ", exception=" + exception +
                        '}';
    }
}
