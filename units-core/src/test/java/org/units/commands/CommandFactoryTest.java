package org.units.commands;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 */
public class CommandFactoryTest {

    public static final String MOVE_COMMAND_NAME = "move";

    @org.junit.Test
    public void testCommandInterceptorsChain() throws Exception {

        Command command = CommandFactory.getCommand(MOVE_COMMAND_NAME);

        assert command instanceof TimeLoggableCommand;
        assert (command = ((TimeLoggableCommand) command).getMeasuredCommand())  instanceof ExceptionalCommand;
        assert ((ExceptionalCommand) command).getWrappedCommand() instanceof MoveCommand;
    }


}