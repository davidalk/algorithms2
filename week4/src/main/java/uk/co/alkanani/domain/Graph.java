package uk.co.alkanani.domain;

import java.util.Arrays;

public class Graph {
    public final int nodeCount;

    public final int edgeCount;

    public final Long[][] edges;

    public Graph(int nodeCount, int edgeCount, Long[][] edges) {
        this.nodeCount = nodeCount;
        this.edgeCount = edgeCount;
        this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (nodeCount != graph.nodeCount) return false;
        if (edgeCount != graph.edgeCount) return false;
        return Arrays.deepEquals(edges, graph.edges);

    }

    @Override
    public int hashCode() {
        int result = nodeCount;
        result = 31 * result + edgeCount;
        result = 31 * result + (edges != null ? Arrays.deepHashCode(edges) : 0);
        return result;
    }
}
