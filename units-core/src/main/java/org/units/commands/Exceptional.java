package org.units.commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * @author vladimir.romanov
 * @version 1.0
 * @since UP...
 */
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exceptional {


}
