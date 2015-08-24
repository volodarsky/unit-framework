package org.units.commands;

import org.units.Position;
import org.units.commands.interceptors.CommandInterceptor;
import org.units.commands.interceptors.CommandInterceptors;
import org.units.commands.results.MoveCommandResult;
import org.units.commands.rollback.RollbackFailedException;
import org.units.commands.rollback.Rollbackable;
import org.units.units.MovableUnit;

import java.util.Objects;

/**
 *
 */
@CommandInterceptors({
        @CommandInterceptor(ExceptionalCommand.class),
        @CommandInterceptor(TimeLoggableCommand.class)
})
public class MoveCommand implements Command<MovableUnit, MoveCommandResult>, Rollbackable<MovableUnit, MoveCommandResult> {

    // stateless commands cached as singletons
    private static MoveCommand INSTANCE = new MoveCommand();
    public static MoveCommand of(){
        return INSTANCE;
    }

    private MoveCommand() {
    }

    @Override
    public MoveCommandResult execute(MovableUnit unit) {
        Position at = unit.at();
        unit.move();
        return new MoveCommandResult(unit, this, at, unit.at());
    }

    @Override
    public Class<MovableUnit>[] getUnitTypes() {
        return new Class[]{MovableUnit.class};
    }


    @Override
    public void rollback(MovableUnit unit, MoveCommandResult commandResult) {
        final Position at = unit.at();
        final Position to = commandResult.getTo();
        if (!Objects.equals(at, to)) {
            throw new RollbackFailedException("Current user position differ from start rollbacked one.");
        }

        final Position from = commandResult.getFrom();
        if (unit.canMoveTo(from.X, from.Y)) {
            throw new RollbackFailedException("Can't pollback user position to " + from);
        }
        unit.setAt(from);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
