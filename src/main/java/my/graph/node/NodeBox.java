package my.graph.node;

import java.util.List;

public class NodeBox<T> {
    private Node<T> node;
    private static DummyNode<?> dummyNode = new DummyNode<>(new NodeBox<>());

    NodeBox() {
        node = new Node<T>(this);
    }

    public Node<T> getNode() {
        return node;
    }

    public Node<T> visitFrom(List<NodeBox<T>> from, int index) {
        return node.visitFrom(from, index);
    }

    public void delete() {
        node = (Node<T>) dummyNode;
    }
}

