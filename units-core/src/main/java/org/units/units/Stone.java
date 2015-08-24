package org.units.units;


import org.units.commands.Command;
import org.units.commands.results.CommandResult;

/**
 * "
 */
public class Stone extends DefaultUnit {

    @Override
    public CommandResult accept(Command command) {
        System.out.println("I'm stone. Bye bye.");
        return super.accept(command);
    }
}
