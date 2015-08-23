package org.units.commands.interceptors;

import org.units.commands.Command;
import org.units.commands.UnknownCommand;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

/**
 */
@Repeatable(CommandInterceptors.class)
@Target({TYPE, ANNOTATION_TYPE  })
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInterceptor {

    Class<? extends Command> value() default UnknownCommand.class;

}
