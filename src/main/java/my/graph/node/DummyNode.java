package my.graph.node;

import java.util.List;

public class DummyNode<T> extends Node<T> {

    DummyNode(NodeBox<T> container) {
        super(container);
    }

    @Override
    Node<T> visitFrom(List<NodeBox<T>> from, int index) {
        from.set(index, from.getLast());
        from.removeLast();
        return super.visitFrom(from, index);
    }
}
