package org.units.units;


import org.units.UnitContainer;

/**
 * Created on 20.08.2015.
 */
public class Tractor extends DefaultUnit implements MovableUnit, TurnableUnit {


    @Override
    public int speed() {
        return 2;
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        final UnitContainer uc = getUnitContainer();
        return x <= uc.getX() && y <= uc.getY();
    }

    @Override
    public void move() {
        MovableUnit.super.move();
        System.out.println("Tractor -  go to : " + at());
    }

    @Override
    public void turn() {
        TurnableUnit.super.turn();
        System.out.println("Tractor - turn to " + to());
    }
}
