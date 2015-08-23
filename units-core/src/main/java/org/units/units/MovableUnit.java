package org.units.units;

import org.units.Orientation;
import org.units.Position;

/**
 *
 */
public interface MovableUnit extends Unit {

    int speed();

    boolean canMoveTo(int x, int y);

    default void move() {

        Position at = at();
        Orientation orientation = to();
        if (orientation == Orientation.NORTH ) {
            if (canMoveTo(at.X, at.Y + speed())) {
                setAt(Position.of(at.X, at.Y + speed()));
            }
        } else if (orientation == Orientation.WEST) {
            if (canMoveTo(at.X + speed(), at.Y)) {
                setAt(Position.of(at.X + speed(), at.Y));
            }
        } else if (orientation == Orientation.SOUTH) {
            if (canMoveTo(at.X, at.Y - speed())) {
                setAt(Position.of(at.X, at.Y - speed()));
            }
        } else if (orientation == Orientation.EAST) {
            if (canMoveTo(at.X - speed(), at.Y)) {
                setAt(Position.of(at.X - speed(), at.Y));
            }
        }
    }






}
