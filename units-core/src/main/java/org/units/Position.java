package org.units;

/**
 *
 */
public class Position {

    public final int X;
    public final int Y;

    //private static Set<Position> positions = new TreeSet<>((p1,p2) -> p1.X == p2.X ? p1.Y - p2.Y : p1.X - p2.X);

    private Position(int x, int y) {
        X = x;
        Y = y;
    }

    public  static Position of(int x, int y){
        return new Position(x, y);
    }



}
