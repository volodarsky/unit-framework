package org.units;

import org.units.commands.Command;
import org.units.commands.CommandFactory;
import org.units.commands.MoveCommand;
import org.units.commands.TurnCommand;
import org.units.commands.results.CommandResult;
import org.units.commands.rollback.Rollbackable;
import org.units.units.Stone;
import org.units.units.Tractor;
import org.units.units.Unit;
import org.units.units.Wind;

import java.util.*;

/**
 *
 */
public class Game {


    protected Board board = new Board(5, 5);
    protected List<Command> commands = new ArrayList<>();
    protected Deque<CommandResult> history = new ArrayDeque<>();

    public static void main(String[] args) {

        Game game = new Game();
        for (String arg : args) {
            game.commands.add(CommandFactory.getCommand(arg));
        }
        game.play();

        game.printHistory();
        game.undo();

    }

    private void printHistory() {
        System.out.println("\n### Commands history ###\n");
        for (CommandResult commandResult : history) {
            System.out.println(commandResult);
        }
        System.out.println("\n###########################\n");
    }

    private void undo() {
        final CommandResult last = history.getLast();
        final Command command = last.getCommand();
        if(command instanceof Rollbackable){
            ((Rollbackable) command).rollback(last.getUnit(),last);
            history.removeLast();
        }else{
            System.out.println("Can't rollback : " + last);
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
                history.addLast(commandResult);
            }
        }
    }


}
