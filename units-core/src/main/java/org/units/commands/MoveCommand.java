package org.units.commands;

import org.units.Position;
import org.units.commands.interceptors.CommandInterceptor;
import org.units.commands.interceptors.CommandInterceptors;
import org.units.commands.results.MoveCommandResult;
import org.units.units.MovableUnit;

/**
 *
 */
@CommandInterceptors({
        @CommandInterceptor(ExceptionalCommand.class),
        @CommandInterceptor(TimeLoggableCommand.class)
})
public class MoveCommand implements Command<MovableUnit, MoveCommandResult> {


    @Override
    public MoveCommandResult execute(MovableUnit unit) {
        Position at = unit.at();
        unit.move();
        return new MoveCommandResult(at, unit.at());
    }

    @Override
    public Class<MovableUnit>[] getUnitTypes() {
        return new Class[]{MovableUnit.class};
    }
}
