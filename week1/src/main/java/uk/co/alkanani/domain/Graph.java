package uk.co.alkanani.domain;

import java.util.Arrays;

public class Graph {
    private int nodes;

    private Edge[] edges;

    public Graph() {

    }

    public Graph(int nodes, Edge[] edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (nodes != graph.nodes) return false;
        return Arrays.equals(edges, graph.edges);

    }

    @Override
    public int hashCode() {
        int result = nodes;
        result = 31 * result + Arrays.hashCode(edges);
        return result;
    }
}
