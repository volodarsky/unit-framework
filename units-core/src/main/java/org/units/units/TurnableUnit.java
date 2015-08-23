package org.units.units;

import org.units.Orientation;

/**
 *
 */
public interface TurnableUnit extends Unit {

    default void turn() {
        Orientation orientation = to();
        switch (orientation) {
            case NORTH:
                setTo(Orientation.WEST);
                break;
            case WEST:
                setTo(Orientation.SOUTH);
                break;
            case SOUTH:
                setTo(Orientation.EAST);
                break;
            case EAST:
                setTo(Orientation.NORTH);
                break;
        }
    }

    void setTo(Orientation orientation);

    Orientation to();

}
