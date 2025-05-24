package my.graph.node;

import java.util.EnumMap;
import java.util.HashSet;

public class NodeManager {
    private final EnumMap<Direction, HashSet<Node>> cleanList;
    int livingCount; // 논리적으로 살아있는 갯수
    public NodeManager() {
        cleanList = new EnumMap<>(Direction.class);
        for (Direction direction : Direction.getDirections()) {
            cleanList.put(direction, new HashSet<Node>());
        }
    }

    public void cleanAll() {
        for (Direction direction : Direction.getDirections()) {
            HashSet<Node> list = cleanList.get(direction);
            // HashSet을 순회하면서 각 노드에 대해 cleanDeletedNodes() 호출
            for (Node node : list) {
                node.adjacentNodes.get(direction).cleanDeletedNodes();
            }
            list.clear(); // 모든 노드 처리 후 HashSet을 비움
        }
    }

    public void delete(Node nodeToDelete) {
        int cleanCount = 0;
        for (Direction direction : Direction.getDirections()) {
            NodeViewList nodeViews = nodeToDelete.adjacentNodes.get(direction);
            while (!nodeViews.isEmpty()) {
                Node node = nodeViews.removeLast().get();
                if (node != null) {
                    cleanList.get(direction.opposite()).add(node);
                }
            }
            cleanCount += cleanList.get(direction).size();
        }
        if (cleanCount * 4 > livingCount) {
            cleanAll();
        }
    }
}
