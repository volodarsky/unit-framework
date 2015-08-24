package org.units.units;

import org.units.CommandExecutionException;
import org.units.Orientation;
import org.units.Position;

/**
 *
 */
public interface MovableUnit extends Unit {

    int speed();

    boolean canMoveTo(int x, int y);

    default void move() {

        Orientation orientation = to();
        Position currentPosition = at();
        Position newPosition;

        switch (orientation) {
            case NORTH:
                newPosition = Position.of(currentPosition.X, currentPosition.Y + speed());
                break;
            case WEST:
                newPosition = Position.of(currentPosition.X + speed(), currentPosition.Y);
                break;
            case SOUTH:
                newPosition = Position.of(currentPosition.X, currentPosition.Y - speed());
                break;
            case EAST:
                newPosition = Position.of(currentPosition.X - speed(), currentPosition.Y);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown orientation [%s]", orientation));
        }

        if (canMoveTo(newPosition.X, newPosition.Y)) {
            setAt(newPosition);
        } else {
            throw new CommandExecutionException(String.format("[%s] can't move from [%s] to [%s]", this.getClass().getSimpleName(), currentPosition, newPosition));
        }
    }


}
