package org.units.units;


import org.units.commands.UnitVisitor;

/**
 * Created on 20.08.2015.
 */
public class Wind extends DefaultUnit implements TurnableUnit{

    @Override
    public <U extends Unit> boolean accept(UnitVisitor<U> unitVisitor) {
        return TurnableUnit.super.accept(unitVisitor);
    }
}
