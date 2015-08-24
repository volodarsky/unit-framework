package org.units;

import org.units.commands.CommandFactory;
import org.units.commands.CompositeCommand;
import org.units.commands.MoveCommand;
import org.units.commands.TurnCommand;

/**
 * @author vladimir.romanov
 * @version 1.0
 * @since UP...
 */
public class GameExt extends Game {

    static {
        CommandFactory.registerCommand("horse_move", new CompositeCommand(
                MoveCommand.of(), MoveCommand.of(), TurnCommand.of(), MoveCommand.of()));
    }


}
