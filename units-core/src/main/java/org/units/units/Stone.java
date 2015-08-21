package org.units.units;

import org.units.commands.UnitVisitor;
import org.units.units.DefaultUnit;

/**
 * Created on 20.08.2015.
 */
public class Stone extends DefaultUnit {

    @Override
    public boolean accept(UnitVisitor unitVisitor) {
        System.out.println("I'm stone. Bye bye.");
        return false;
    }
}
