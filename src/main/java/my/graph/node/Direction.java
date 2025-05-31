package my.graph.node;

import java.util.EnumMap;

public enum Direction {
    OUT, IN;

    public static final Direction[] directions;
    private static final EnumMap<Direction, Direction> oppositeDirections;

    static {
        directions = values();
        oppositeDirections = new EnumMap<Direction, Direction>(Direction.class);
        oppositeDirections.put(OUT, IN);
        oppositeDirections.put(IN, OUT);
    }

    public Direction opposite() {
        return oppositeDirections.get(this);
    }
}
