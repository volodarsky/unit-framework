package org.units.commands;

import org.units.commands.results.CommandResult;

/**
 *
 *
 */
public interface CommandAcceptable {

    CommandResult accept(Command commandVisitor);

    default boolean acceptCommand(Class[] unitTypes) {
        for (Class unitType : unitTypes) {
            if(!this.getClass().isAssignableFrom(unitType)){
                return false;
            }
        }
        return true;
    }

}
