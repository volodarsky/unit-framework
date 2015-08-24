package org.units;

import java.util.Objects;

/**
 *
 */
public class Position implements Comparable<Position> {

    public final int X;
    public final int Y;

    //private static Set<Position> positions = new TreeSet<>((p1,p2) -> p1.X == p2.X ? p1.Y - p2.Y : p1.X - p2.X);

    private Position(int x, int y) {
        X = x;
        Y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }


    @Override
    public int compareTo(Position that) {
        return this.X == that.X ? that.Y - this.Y : this.X - that.X;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(X, position.X) &&
                Objects.equals(Y, position.Y);
    }

    @Override public int hashCode() {
        return Objects.hash(X, Y);
    }


    @Override
    public String toString() {
        return "Position{" + X + "," + Y + "}";
    }
}
