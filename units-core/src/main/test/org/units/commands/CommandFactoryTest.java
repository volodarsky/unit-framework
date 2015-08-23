package org.units.commands;



/**
 * Created on 22.08.2015.
 */
public class CommandFactoryTest {

    public static final String MOVE_COMMAND_NAME = "move";

    @org.junit.Test
    public void testCreateCommand() throws Exception {

        CommandFactory.registerCommand(MOVE_COMMAND_NAME, new MoveCommand());
        Command command = CommandFactory.getCommand(MOVE_COMMAND_NAME);

        //command.execute();

        assert command instanceof TimeLoggableCommand;




    }
}