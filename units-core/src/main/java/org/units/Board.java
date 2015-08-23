package org.units;

import org.units.commands.results.CommandResult;
import org.units.event.CommandEvent;
import org.units.event.CommandEventSupport;
import org.units.event.UnitPutEvent;
import org.units.units.Unit;

import java.util.*;

/**
 * Created on 23.08.2015.
 */
public class Board implements CommandEventSupport{

    private final int width;
    private final int length;


    private Map<Position,Unit> unitPositionsMap = new HashMap<>();

    private Deque<CommandResult> commandResults = new LinkedList<>();
    private PriorityQueue<Unit> units = new PriorityQueue<>((u1, u2) -> {
        return u1.at().compareTo(u2.at());
    });

    public Board(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public void putUnit(Unit unit, int x, int y){

        Position of = Position.of(x, y);
        if(!unitPositionsMap.containsKey(of)){
            unit.setAt(of);
            unitPositionsMap.put(of, unit);
            fireEvent(unit, new UnitPutEvent());

        }


    }

    /**
     *
     * @param lefttop - left & top point of rectangle
     * @param rightbottom - right & botton point of rectangle
     * @return
     */
    public Iterable<Unit> select(Position lefttop, Position rightbottom) {
        return null;
    }

    public Iterable<CommandResult> getHistory() {
        return commandResults;
    }

    public void addResult(CommandResult result){
        commandResults.add(result);
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
