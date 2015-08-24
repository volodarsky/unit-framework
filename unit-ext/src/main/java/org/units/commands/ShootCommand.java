package org.units.commands;

import org.units.ShootableUnit;
import org.units.commands.results.ShootCommandResult;

/**
 *
 */

public class ShootCommand implements Command<ShootableUnit, ShootCommandResult>{

    // stateless commands cached as singletons
    private static ShootCommand INSTANCE = new ShootCommand();
    public static ShootCommand of(){
        return INSTANCE;
    }

    private ShootCommand() {
    }

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
