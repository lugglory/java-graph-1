package my.graph.node;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Node<T> {
    private T data;
    private Map<Direction, List<Node<T>>> adjMap;

    public Node() {
        data = new T();
    }

    public List<Node<T>> getAdj(Direction dir) {
        if (adjMap == null) return null;
        return adjMap.get(dir);
    }

    // 문제 : 바로 만들지 않으면... 인접성이 떨어질 수도 있다...
    private List<Node<T>> mustGetAdj(Direction dir) {
        if (adjMap == null) adjMap = new EnumMap<Direction, List<Node<T>>>(Direction.class);
        if (adjMap.get(dir) == null) this.adjMap.put(dir, new ArrayList<Node<T>>());
        return adjMap.get(dir);
    }

    public void delete() {
        for (Direction dir : Direction.directions) {
            List<Node<T>> adj = getAdj(dir);
            if (adj == null) continue;
            for (Node<T> oppNode : adj) {
                // 이 그래프에서는, 노드가 상호참조 한다. oppNode.getAdj(dir.opposite()) == null 인 경우는 없다.
                oppNode.getAdj(dir.opposite()).remove(this);
            }
            adj.clear();
        }
        adjMap = null;
    }

    public void link(Node<T> node, Direction direction) {
        this.mustGetAdj(direction).add(node);
        node.mustGetAdj(direction.opposite()).add(this);
    }
}
