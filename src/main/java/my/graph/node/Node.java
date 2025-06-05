package my.graph.node;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Node<T> {
    public NodeBox<T> container;
    private Map<Direction, List<NodeBox<T>>> adjMap;
    private T data;

    public Node(NodeBox<T> container) {
        this.container = container;
    }

    Node<T> visitFrom(List<NodeBox<T>> from, int index) {
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<NodeBox<T>> getAdj(Direction dir) {
        if (adjMap == null) return null;
        return adjMap.get(dir);
    }

    // 문제 : 바로 만들지 않으면... 인접성이 떨어질 수도 있다...
    private List<NodeBox<T>> mustGetAdj(Direction dir) {
        if (adjMap == null) adjMap = new EnumMap<Direction, List<NodeBox<T>>>(Direction.class);
        if (adjMap.get(dir) == null) this.adjMap.put(dir, new ArrayList<NodeBox<T>>());
        return adjMap.get(dir);
    }

    public void delete() {
        container.delete();
        container = null;
    }

    public void link(Node<T> node, Direction direction) {
        this.mustGetAdj(direction).add(node.container);
        node.mustGetAdj(direction.opposite()).add(this.container);
    }
}
