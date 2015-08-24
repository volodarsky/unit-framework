package org.units.units;


/**
 *
 */
public class Wind extends DefaultUnit implements TurnableUnit{

    @Override
    public void turn() {
        TurnableUnit.super.turn();
        System.out.println("Will blow to " + to());
    }
}
