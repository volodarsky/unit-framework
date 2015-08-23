package org.units;

import org.units.commands.results.CommandResult;
import org.units.units.Unit;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on 23.08.2015.
 */
public class Board {

    private final int width;
    private final int length;

    private Queue<CommandResult> commandResults = new LinkedList<>();
    private PriorityQueue<Unit> units = new PriorityQueue<>((u1, u2) -> {
        return u1.at().compareTo(u2.at());
    });

    public Board(int width, int length) {
        this.width = width;
        this.length = length;
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
}
