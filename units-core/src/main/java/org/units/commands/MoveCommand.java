package org.units.commands;

import org.units.units.MovableUnit;

/**
 *
 */
@TimeLoggable
@Exceptional
public class MoveCommand extends UnitDefaultCommand<MovableUnit, Boolean> {

    @Override
    public void execute() {
        getUnit().move();
    }

    @Override
    public Class<MovableUnit> getUnitType() {
        return MovableUnit.class;
    }
}
