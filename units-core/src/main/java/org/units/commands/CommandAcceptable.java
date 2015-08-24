package org.units.commands;

import org.units.commands.results.CommandResult;

/**
 *  Unit acceptable in Visitor pattern
 *
 */
public interface CommandAcceptable {

    CommandResult accept(Command commandVisitor);

    default boolean acceptCommand(Class[] unitTypes) {
        for (Class unitType : unitTypes) {
            if(!unitType.isAssignableFrom(this.getClass())){
                return false;
            }
        }
        return true;
    }

}
