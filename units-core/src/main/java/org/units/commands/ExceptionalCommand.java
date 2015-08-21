package org.units.commands;

/**
 * Decorator for time measurement of wrapping command
 */
class ExceptionalCommand extends UnitDefaultCommand {

    private Command wrappedCommand;

    public void setWrappedCommand(Command wrappedCommand) {
        this.wrappedCommand = wrappedCommand;
    }

    @Override
    public void execute() {
        try {
            wrappedCommand.execute();
        } catch (Exception e) {
            //todo
            e.printStackTrace();
        }
    }

    @Override
    public void setResult(Object result) {

    }

    @Override
    public Class getUnitType() {
        return wrappedCommand.getUnitType();
    }
}
