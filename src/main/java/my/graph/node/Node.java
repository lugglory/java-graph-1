package my.graph.node;

import java.util.EnumMap;

public class Node implements NodeView {
    static NodeCleaner nodeCleaner;
    static int count; // 논리적으로 살아있는 갯수
    private Data data;
    private boolean exist;
    public final EnumMap<Direction, NodeViewList> adjacentNodes;

    static {
        nodeCleaner = new NodeCleaner();
    }

    public Node() {
        exist = true;
        adjacentNodes = new EnumMap<>(Direction.class);
        for (Direction dir : Direction.getDirections()) {
            adjacentNodes.put(dir, new NodeViewList());
        }
        count++;
    }

    public Node get() {
        if (exist) {
            return this;
        }
        return null;
    }

    public void delete() {
        exist = false;
        nodeCleaner.delete(this);
    }

    public void cleanNullViews(Direction direction) {
        adjacentNodes.get(direction).cleanDeletedNodes();
    }
}
