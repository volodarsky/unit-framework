package org.units;

import org.units.commands.*;

import static org.units.commands.CommandFactory.*;

/**
 *
 */
public class GameExt extends Game {

    public static final String HORSE_MOVE = "horse_move";
    public static final String AROUND = "around";
    public static final String SHOOT = "shoot";
    public static final String SHOOT_BACK = "shoot_back";

    static {
        //creating of composite commands
        registerCommand(HORSE_MOVE, new CompositeCommand(
                MoveCommand.of(), MoveCommand.of(), TurnCommand.of(), MoveCommand.of()));
        registerCommand(AROUND, new CompositeCommand(TurnCommand.of(), TurnCommand.of()));
        registerCommand(SHOOT, ShootCommand.of());
        registerCommand(SHOOT_BACK, new CompositeCommand(getCommand(AROUND), ShootCommand.of()));
    }

    public static void main(String[] args) {
        //todo:
    }

}
