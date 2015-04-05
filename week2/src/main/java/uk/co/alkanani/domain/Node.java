package uk.co.alkanani.domain;

public class Node implements UnionFindSet {
    private Node parent;
    public final int nodeId;
    private long rank;

    public Node(int nodeId) {
        this.nodeId = nodeId;
        parent = this;
        rank = 0;
    }

    @Override
    public void union(Node y) {
        link(findSet(), y.findSet());
    }

    @Override
    public Node findSet() {
        if (this != parent) {
            parent = parent.findSet();
        }
        return parent;
    }

    private void link(Node x, Node y) {
        if (!x.equals(y)) {
            if (x.rank > y.rank) {
                y.parent = x;
            } else {
                x.parent = y.parent;
                if (x.rank == y.rank) {
                    y.rank++;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return nodeId == node.nodeId;

    }

    @Override
    public int hashCode() {
        return nodeId;
    }
}
