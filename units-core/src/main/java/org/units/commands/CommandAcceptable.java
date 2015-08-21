package org.units.commands;

import org.units.units.Unit;

/**
 *
 *
 */
public interface CommandAcceptable {

    <U extends Unit> boolean accept(UnitVisitor<U> unitVisitor);

}
