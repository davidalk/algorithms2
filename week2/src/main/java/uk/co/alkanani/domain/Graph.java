package uk.co.alkanani.domain;

import java.util.List;

public class Graph {
    public final int nodeCount;
    public final List<Edge> edges;

    public Graph(int nodeCount, List<Edge> edges) {
        this.nodeCount = nodeCount;
        this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (nodeCount != graph.nodeCount) return false;
        return !(edges != null ? !edges.equals(graph.edges) : graph.edges != null);

    }

    @Override
    public int hashCode() {
        int result = nodeCount;
        result = 31 * result + (edges != null ? edges.hashCode() : 0);
        return result;
    }
}
