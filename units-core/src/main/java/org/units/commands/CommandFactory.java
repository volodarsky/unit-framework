package org.units.commands;

import org.units.commands.interceptors.CommandInterceptor;
import org.units.commands.interceptors.CommandInterceptors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created on 22.08.2015.
 */
public class CommandFactory {

    private static Map<String, Command> commandRegistry = new HashMap<>();

    public static void registerCommand(String commandName, Command command) {
        CommandInterceptors[] annotationsByType =
                command.getClass().getAnnotationsByType(CommandInterceptors.class);
        commandRegistry.put(commandName, appendInterceptors(annotationsByType, command));
    }

    public static Command getCommand(String commandName) {
        Objects.requireNonNull(commandName, "Empty commandName");

        if (commandRegistry.containsKey(commandName)) {
            return commandRegistry.get(commandName);
        } else {
            UnknownCommand unknownCommand = new UnknownCommand(commandName);
            commandRegistry.put(commandName,unknownCommand);
            return unknownCommand;
        }
    }

    private static Command appendInterceptors(CommandInterceptors[] annotationsByType, Command commandInstance) {

        for (CommandInterceptors commandInterceptors : annotationsByType) {
            CommandInterceptor[] interceptors = commandInterceptors.value();
            for (CommandInterceptor interceptor : interceptors) {
                Class<? extends Command> interceptorClass = interceptor.value();
                commandInstance = createCommand(interceptorClass, Command.class, commandInstance);
            }
        }
        return commandInstance;
    }

    private static Command createCommand(Class<? extends Command> commandClass, Class<Command> paramClass, Command paramInstance) {
        try {
            Constructor<? extends Command> constructor = paramClass != null ? commandClass.getConstructor(paramClass) : commandClass.getConstructor();
            paramInstance = paramInstance != null ? constructor.newInstance(paramInstance) : constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot instantiate " + commandClass.getSimpleName(), e);
        }
        return paramInstance;
    }




}
