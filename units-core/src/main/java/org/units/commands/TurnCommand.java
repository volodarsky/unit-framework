package org.units.commands;


import org.units.Orientation;
import org.units.commands.results.TurnableCommandResult;
import org.units.units.TurnableUnit;

/**
 * "
 */
public class TurnCommand implements Command<TurnableUnit,TurnableCommandResult> {

    // stateless commands cached as singletons
    private static final TurnCommand INSTANCE = new TurnCommand();
    public static TurnCommand of() {
        return INSTANCE;
    }

    private TurnCommand() {
    }

    @Override
    public TurnableCommandResult execute(TurnableUnit unit) {
        Orientation to = unit.to();
        unit.turn();
        return new TurnableCommandResult(unit, this, to, unit.to());
    }

    @Override
    public Class<TurnableUnit>[] getUnitTypes() {
        return new Class[]{TurnableUnit.class};
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
