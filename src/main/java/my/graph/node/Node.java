package my.graph.node;

import my.util.UnorderedList;

import java.util.EnumMap;

public class Node {
    private int version;
    private Data data;
    private boolean isActive;
    public final EnumMap<Direction, UnorderedList<Node>> nodes;

    public Node() {
        nodes = new EnumMap<>(Direction.class);
        for (Direction dir : Direction.getDirections()) {
            nodes.put(dir, new UnorderedList<>());
        }
    }

    public int getVersion() {
        return version;
    }
}
