package org.units.commands;

import org.units.commands.results.CommandResult;
import org.units.commands.results.CompositeCommandResult;
import org.units.commands.results.FailedCommandResult;
import org.units.units.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class CompositeCommand extends UnitDefaultCommand<Unit, CompositeCommandResult> {

    private List<Command> commands = new ArrayList<>();

    public CompositeCommand() {
    }

    public CompositeCommand(Command... commands) {
        for (Command command : commands) {
            addCommand(command);
        }
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public CompositeCommandResult execute(Unit unit) {
        CompositeCommandResult compositeCommandResult = new CompositeCommandResult();
        for (Command command : commands) {
            CommandResult commandResult = command.execute(unit);
            compositeCommandResult.addResult(commandResult);
            if (commandResult instanceof FailedCommandResult) {
                break;
            }
        }
        return compositeCommandResult;
    }

    public Class[] getUnitTypes() {
        ArrayList<Class> types = new ArrayList<>();
        for (Command command : commands) {
            Collections.addAll(types, command.getUnitTypes());
        }
        return types.toArray(new Class[types.size()]);
    }
}
