package org.units.units;

import org.units.Orientation;
import org.units.commands.UnitVisitor;

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

    @Override
    default <U extends Unit> boolean accept(UnitVisitor<U> unitVisitor){
        return unitVisitor.getUnitType().isAssignableFrom(TurnableUnit.class);
    }
}
