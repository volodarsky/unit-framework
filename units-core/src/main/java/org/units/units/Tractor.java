package org.units.units;


import org.units.commands.UnitVisitor;

/**
 * Created on 20.08.2015.
 */
public class Tractor extends DefaultUnit implements MovableUnit, TurnableUnit {


    @Override
    public int speed() {
        return 2;
    }

    @Override
    public <U extends Unit> boolean accept(UnitVisitor<U> unitVisitor) {
        final Class<U> unitType = unitVisitor.getUnitType();
        return (unitType.isAssignableFrom(MovableUnit.class) ||  unitType.isAssignableFrom(TurnableUnit.class));
    }
}
