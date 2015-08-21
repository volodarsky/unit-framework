package org.units.units;

import org.units.Orientation;
import org.units.Position;

/**
 *
 */
public abstract class DefaultUnit implements Unit {

    private Orientation orientation;
    private Position position;

    @Override
    public Orientation to() {
        return orientation;
    }

    @Override
    public Position at() {
        return position;
    }

    @Override
    public void setTo(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void setAt(Position position) {
        this.position = position;
    }


}
