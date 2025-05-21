package my.graph.node;

import java.util.EnumMap;

public enum Direction {
    OUT, IN;

    private static final Direction[] directions;
    private static final EnumMap<Direction, Direction> oppositeDirections;

    static {
        directions = values();
        oppositeDirections = new EnumMap<>(Direction.class);
        oppositeDirections.put(OUT, IN);
        oppositeDirections.put(IN, OUT);
    }

    public static Direction[] getDirections() {
        return directions;
    }

    public Direction opposite() {
        return oppositeDirections.get(this);
    }
}
