package my.graph.node;

import java.util.EnumMap;

public class Node implements NodeView {
    static NodeManager nodeManager;
    private Data data;
    private boolean exist;
    public final EnumMap<Direction, NodeViewList> adjacentNodes;

    static {
        nodeManager = new NodeManager();
    }

    public Node() {
        exist = true;
        adjacentNodes = new EnumMap<>(Direction.class);
        for (Direction dir : Direction.getDirections()) {
            adjacentNodes.put(dir, new NodeViewList());
        }
        nodeManager.livingCount++;
    }

    public Node get() {
        if (exist) {
            return this;
        }
        return null;
    }

    public void delete() {
        exist = false;
        nodeManager.delete(this);
    }

    public void cleanNullViews(Direction direction) {
        adjacentNodes.get(direction).cleanDeletedNodes();
    }

    public void link(Node node, Direction direction) {
        this.adjacentNodes.get(direction).add(node);
        node.adjacentNodes.get(direction.opposite()).add(this);
    }
}
