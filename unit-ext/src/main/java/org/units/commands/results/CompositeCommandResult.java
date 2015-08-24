package org.units.commands.results;

import org.units.commands.Command;
import org.units.units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * "
 */
public class CompositeCommandResult extends DefaultCommandResult {

    private List<CommandResult> results = new ArrayList<>();

    public CompositeCommandResult(Unit unit, Command command) {
        super(unit, command);
    }

    public void addResult(CommandResult commandResult){
        results.add(commandResult);
    }

}
