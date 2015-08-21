package org.units.units;

import org.units.Orientation;
import org.units.Position;
import org.units.commands.CommandAcceptable;

/**
 *
 */
public interface Unit extends CommandAcceptable {

    Orientation to();

    void setTo(Orientation orientation);

    Position at();

    void setAt(Position position);

}
