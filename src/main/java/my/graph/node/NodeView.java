package my.graph.node;

public class NodeView {
    static Node dummy = new Node();
    private int version;
    private Node node;
    public Node get() {
        if(version == node.getVersion())
            return node;
        else return dummy;
    }
    public void set(Node node) {
        this.node = node;
        this.version = node.getVersion();
    }
}
