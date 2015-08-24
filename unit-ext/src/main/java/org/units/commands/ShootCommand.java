package org.units.commands;

import org.units.ShootableUnit;
import org.units.commands.results.ShootCommandResult;

/**
 * Created on 23.08.2015.
 */
public class ShootCommand implements Command<ShootableUnit, ShootCommandResult>{

    @Override
    public ShootCommandResult execute(ShootableUnit unit) {
        unit.shoot();
        return new ShootCommandResult(unit,this);
    }

    @Override
    public Class<ShootableUnit>[] getUnitTypes() {
        return new Class[]{ShootableUnit.class};
    }
}
