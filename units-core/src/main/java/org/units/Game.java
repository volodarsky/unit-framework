package org.units;

import org.units.commands.Command;
import org.units.commands.CommandFactory;
import org.units.commands.results.CommandResult;
import org.units.commands.rollback.RollbackFailedException;
import org.units.event.DefaultCommandEvent;
import org.units.units.Stone;
import org.units.units.Tractor;
import org.units.units.Unit;
import org.units.units.Wind;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 */
public class Game {

    protected Board board = new Board(5, 5);
    protected List<Command> commands = new ArrayList<>();

    public static void main(String[] args) {

        Game game = new Game();

        // just run with params like :  move turn some move ...
        for (String arg : args) {
            game.commands.add(CommandFactory.getCommand(arg));
        }
        game.play();
        game.printHistory();
        // try to rollback last command - kind realization of pattern Memento for board
        // todo: think about command events invalidation model
        game.undo();

    }

    private void printHistory() {
        System.out.println("\n### Commands history ###\n");
        for (CommandResult commandResult : board.getCommandResults()) {
            System.out.println(commandResult);
        }
        System.out.println("\n###########################\n");
    }

    private void undo() {
        final Deque<CommandResult> history = board.getCommandResults();
        final CommandResult last = history.getLast();
        final Command command = last.getCommand();
        try {
            // try to rollback last command
            command.rollback(last.getUnit(), last);
            // remove last history element
            history.removeLast();
        } catch (RollbackFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void play() {

        board.putUnit(new Tractor(), 2, 3);
        board.putUnit(new Stone(), 4, 4);
        board.putUnit(new Wind(), 1, 1);

        final Iterable<Unit> units = board.select(Position.of(0, 0), Position.of(5, 5));
        for (Command command : commands) {
            for (Unit unit : units) {
                CommandResult commandResult = unit.accept(command);
                // fire command event
                //todo: don't fire unsuceesfull events
                board.fireEvent(unit, new DefaultCommandEvent(commandResult));
                // add result to history
                board.getCommandResults().addLast(commandResult);
            }
        }
    }


}
