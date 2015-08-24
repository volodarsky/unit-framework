package org.units;

import org.units.units.Tractor;

/**
 *
 */
public class Tank extends Tractor implements ShootableUnit {

    @Override
    public int damage() {
        return 3;
    }

    @Override
    public int speed() {
        return 3;
    }

    @Override
    public void shoot() {
    }

}
