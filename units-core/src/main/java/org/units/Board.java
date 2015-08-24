package org.units;

import org.units.commands.results.CommandResult;
import org.units.event.CommandEvent;
import org.units.event.CommandEventSupport;
import org.units.units.Unit;

import java.util.*;

/**
 * Board act as mediator that fires events to listen units.
 */
public class Board implements CommandEventSupport, UnitContainer{

    private final int X;
    private final int Y;

    // to get range of units by its positions
    private NavigableMap<Position,Unit> unitPositionsMap = new TreeMap<>();
    // two way queue for printing history and get last for rollback
    private Deque<CommandResult> commandResults = new ArrayDeque<>();

    public Board(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }

    public void putUnit(Unit unit, int x, int y){

        Position of = Position.of(x, y);
        if(!unitPositionsMap.containsKey(of)){
            unit.setAt(of);
            unit.setUnitContainer(this);
            unitPositionsMap.put(of, unit);
        }
    }

    /**
     *
     * @param lefttop - left & top point of rectangle
     * @param rightbottom - right & botton point of rectangle
     * @return
     */
    public Iterable<Unit> select(Position lefttop, Position rightbottom) {
        return unitPositionsMap.subMap(lefttop, rightbottom).values();
    }

    public Iterable<CommandResult> getHistory() {
        return commandResults;
    }

    public void addResult(CommandResult result){
        commandResults.add(result);
    }

    public Deque<CommandResult> getCommandResults() {
        return commandResults;
    }

    @Override
    public void fireEvent(Unit unit, CommandEvent event) {
        List<Unit> nearUnits = getNearUnits(unit.at());
        for (Unit nearUnit : nearUnits) {
            nearUnit.onCommandEvent(event);
        }
    }

    private List<Unit> getNearUnits(Position position){
        //todo:
        return new ArrayList<>();
    }

}
