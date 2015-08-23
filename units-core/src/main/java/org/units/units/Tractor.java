package org.units.units;


/**
 * Created on 20.08.2015.
 */
public class  Tractor extends DefaultUnit implements MovableUnit, TurnableUnit {


    @Override
    public int speed() {
        return 2;
    }


}
