package org.units.commands.results;

import org.units.Position;

/**
 * Created on 23.08.2015.
 */
public class MoveCommandResult extends DefaultCommandResult {

    private final Position from;
    private final Position to;

    public MoveCommandResult(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }
}
