package my.graph.node;

import my.util.UnorderedList;

public class NodeViewList extends UnorderedList<NodeView> {
    void cleanDeletedNodes() {
        for(int i = size() - 1; i >= 0; i--) {
            if(get(i).get() == null) {
                swapRemove(i);
            }
        }
    }
}
