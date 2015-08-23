package org.units.commands.results;

import org.units.Orientation;

/**
 * Created on 23.08.2015.
 */
public class TurnableCommandResult extends DefaultCommandResult{

    private final Orientation from;
    private final Orientation to;

    public TurnableCommandResult(Orientation from, Orientation to) {
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
