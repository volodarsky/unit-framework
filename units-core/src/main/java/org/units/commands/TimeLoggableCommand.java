package org.units.commands;

/**
 * Decorator for time measurement of wrapping command
 */
class TimeLoggableCommand extends UnitDefaultCommand {

    private Command measuredCommand;
    private long timeExecuted = -1;

    public void setMeasuredCommand(Command measuredCommand) {
        this.measuredCommand = measuredCommand;
    }

    public long getTimeExecuted() {
        return timeExecuted;
    }

    @Override
    public void execute() {
        final long start = System.currentTimeMillis();
        measuredCommand.execute();
        timeExecuted = System.currentTimeMillis() - start;
    }

    @Override
    public Class getUnitType() {
        return measuredCommand.getUnitType();
    }


}
