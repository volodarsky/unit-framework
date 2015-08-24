package org.units.event;

import org.units.units.Unit;

/**
 *
 */
public interface CommandEventSupport {

    void fireEvent(Unit unit, CommandEvent commandEvent);



}
