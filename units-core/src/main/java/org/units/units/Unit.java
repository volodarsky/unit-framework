package org.units.units;

import org.units.Orientation;
import org.units.Position;
import org.units.UnitContainer;
import org.units.commands.CommandAcceptable;
import org.units.event.CommandEventListener;

/**
 *
 */
public interface Unit extends CommandAcceptable, CommandEventListener {

    Orientation to();
    void setTo(Orientation orientation);

    Position at();
    void setAt(Position position);

    UnitContainer getUnitContainer();
    void setUnitContainer(UnitContainer unitContainer);


}
