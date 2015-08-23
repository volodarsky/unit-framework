package org.units.event;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 * Created on 22.08.2015.
 */
public interface CommandEventSupport {

    void fireEvent(Unit unit, CommandEvent commandEvent);



}
