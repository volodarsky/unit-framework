package org.units.commands;

import org.units.commands.results.FailedCommandResult;
import org.units.units.Unit;

/**
 *
 */
public class UnknownCommand extends UnitDefaultCommand<Unit, FailedCommandResult> {

    private final String name;

    public UnknownCommand(String name) {
        this.name = name;
    }

    @Override
    public FailedCommandResult execute(Unit unit) {
        String msg = String.format("Unknown command %s executed on % unit", name, unit);
        System.out.println(msg);
        return new FailedCommandResult(msg);
    }

    @Override
    public Class[] getUnitTypes() {
        return new Class[]{};
    }

    @Override
    public String toString() {
        return "UnknownCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}

