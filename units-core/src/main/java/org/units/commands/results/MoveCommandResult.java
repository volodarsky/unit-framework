package org.units.commands.results;

import org.units.Position;
import org.units.commands.Command;
import org.units.units.Unit;

/**
 * "
 */
public class MoveCommandResult extends DefaultCommandResult {

    private final Position from;
    private final Position to;

    public MoveCommandResult(Unit unit, Command command, Position from, Position to) {
        super(unit, command);
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
