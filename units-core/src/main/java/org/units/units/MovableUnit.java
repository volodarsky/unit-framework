package org.units.units;

import org.units.Orientation;
import org.units.Position;

/**
 *
 */
public interface MovableUnit extends Unit {

    int speed();

    default void move() {

        Orientation orientation = to();
        switch (orientation) {
            case NORTH:
                setAt(Position.of(at().X, at().Y + speed()));
                break;
            case WEST:
                setAt(Position.of(at().X + speed(), at().Y));
                break;
            case SOUTH:
                setAt(Position.of(at().X, at().Y - speed()));
                break;
            case EAST:
                setAt(Position.of(at().X - speed(), at().Y));
                break;
        }
    }




}
