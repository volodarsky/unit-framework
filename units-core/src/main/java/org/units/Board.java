package org.units;

import org.units.commands.Command;
import org.units.units.Unit;

/**
 *
 */
public interface Board {

    /**
     *
     * @param lefttop - left & top point of rectangle
     * @param rightbottom - right & botton point of rectangle
     * @return
     */
    Iterable<Unit> select(Position lefttop, Position rightbottom);

    Iterable<Command> getHistory();

}
