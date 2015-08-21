package org.units.commands;

import org.units.units.Unit;

/**
 *
 */
public interface UnitVisitor<U extends Unit> {

    void visit(U unit);

    Class<U> getUnitType();
}
