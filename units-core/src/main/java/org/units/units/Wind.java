package org.units.units;


/**
 * Created on 20.08.2015.
 */
public class Wind extends DefaultUnit implements TurnableUnit{

    @Override
    public void turn() {
        TurnableUnit.super.turn();
        System.out.println("Will blow to " + to());
    }
}
