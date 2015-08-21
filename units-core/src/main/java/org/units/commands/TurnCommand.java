package org.units.commands;


import org.units.units.TurnableUnit;

/**
 * Created on 20.08.2015.
 */
public class TurnCommand extends UnitDefaultCommand<TurnableUnit,Boolean> {

    @Override
    public void execute() {
        getUnit().turn();
        setResult(true);
    }
}
