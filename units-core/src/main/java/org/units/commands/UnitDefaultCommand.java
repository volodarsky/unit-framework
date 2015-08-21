package org.units.commands;

import org.units.units.Unit;

/**
 *
 */
public abstract class UnitDefaultCommand<U extends Unit, R> implements Command<U, R> {

    private U unit;
    private R result;

    @Override
    public void visit(U unit) {
        this.unit = unit;
    }

    @Override
    public void setResult(R result) {
        this.result = result;
    }

    public U getUnit() {
        return unit;
    }

    public R getResult() {
        return result;
    }
}
