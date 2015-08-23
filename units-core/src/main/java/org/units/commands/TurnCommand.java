package org.units.commands;


import org.units.Orientation;
import org.units.commands.results.TurnableCommandResult;
import org.units.units.TurnableUnit;

/**
 * Created on 20.08.2015.
 */
public class TurnCommand extends UnitDefaultCommand<TurnableUnit,TurnableCommandResult> {


    @Override
    public TurnableCommandResult execute(TurnableUnit unit) {
        Orientation to = unit.to();
        unit.turn();
        return new TurnableCommandResult(to, unit.to());
    }

    @Override
    public Class<TurnableUnit>[] getUnitTypes() {
        return new Class[]{TurnableUnit.class};
    }
}
