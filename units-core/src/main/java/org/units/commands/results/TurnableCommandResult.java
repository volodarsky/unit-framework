package org.units.commands.results;

import org.units.Orientation;
import org.units.commands.Command;
import org.units.units.Unit;

/**
 * Created on 23.08.2015.
 */
public class TurnableCommandResult extends DefaultCommandResult{

    private final Orientation from;
    private final Orientation to;

    public TurnableCommandResult(Unit unit, Command command, Orientation from, Orientation to) {
        super(unit, command);
        this.from = from;
        this.to = to;
    }

    public Orientation getFrom() {
        return from;
    }

    public Orientation getTo() {
        return to;
    }
}
