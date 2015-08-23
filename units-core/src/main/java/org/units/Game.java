package org.units;

import org.units.commands.Command;
import org.units.commands.results.CommandResult;
import org.units.units.Unit;

/**
 *
 */
public class Game {

    static {
    }

    private Board board = new Board(5,5);
    private Iterable<Command> commands;

    public static void main(String[] args) {

        Game game = new Game();

        Iterable<Unit> selectedUnits = game.board.select(Position.of(0, 0), Position.of(5, 5));
        final Iterable<Command> commands = game.commands;

        executeOnSelected(selectedUnits, commands);
    }

    private static void executeOnSelected(Iterable<Unit> selectedUnits, Iterable<Command> commands) {
        for (Command command : commands) {
            for (Unit selectedUnit : selectedUnits) {
                CommandResult commandResult = selectedUnit.accept(command);

            }
        }
    }
}
