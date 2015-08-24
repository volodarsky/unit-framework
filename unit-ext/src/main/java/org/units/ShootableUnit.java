package org.units;

import org.units.commands.ExceptionalCommand;
import org.units.commands.TimeLoggableCommand;
import org.units.commands.interceptors.CommandInterceptor;
import org.units.commands.interceptors.CommandInterceptors;
import org.units.units.Unit;

/**
 *
 */
@CommandInterceptors({
        @CommandInterceptor(ExceptionalCommand.class),
        @CommandInterceptor(TimeLoggableCommand.class)
})
public interface ShootableUnit extends Unit{

    int damage();

    void shoot();


}
