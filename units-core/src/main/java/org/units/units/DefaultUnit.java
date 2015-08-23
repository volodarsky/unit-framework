package org.units.units;

import org.units.Orientation;
import org.units.Position;
import org.units.commands.Command;
import org.units.commands.results.CommandResult;
import org.units.commands.results.FailedCommandResult;
import org.units.event.CommandEvent;
import org.units.event.CommandEventSupport;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public abstract class DefaultUnit implements Unit {

    private Orientation orientation;
    private Position position;
    private Queue<CommandEvent> eventQueue = new LinkedList<>();
    private CommandEventSupport support;

    @Override
    public Orientation to() {
        return orientation;
    }

    @Override
    public Position at() {
        return position;
    }

    @Override
    public void setTo(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void setAt(Position position) {
        this.position = position;
    }

    @Override
    public void onCommandEvent(CommandEvent event) {
        eventQueue.add(event);
    }

    @Override
    public void addCommandEventSupport(CommandEventSupport support) {
        this.support = support;
    }

    public CommandResult accept(Command command){
        if(acceptCommand(command.getUnitTypes())){
            return command.execute(this);
        }else{
            String msg = String.format("Command %s not accepted on %s", command, this);
            return new FailedCommandResult(msg);
        }
    }




}
