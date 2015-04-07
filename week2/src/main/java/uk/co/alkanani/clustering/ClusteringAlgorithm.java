package uk.co.alkanani.clustering;

import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.domain.Node;

import java.util.*;

public class ClusteringAlgorithm {
    private final Graph graph;
    private int clusterCount;

    public ClusteringAlgorithm(Graph graph) {
        this.graph = graph;
        this.clusterCount = graph.nodeCount;
    }

    public Set<Edge> execute(int targetClusters) {
        Node[] nodes = initialiseNodes();
        List<Edge> sortedEdges = getSortedEdges();

        Iterator<Edge> edgeIterator = sortedEdges.iterator();
        while (clusterCount > targetClusters) {
            Edge edge = edgeIterator.next();
            if (nodes[edge.a].findSet() != nodes[edge.b].findSet()) {
                nodes[edge.a].union(nodes[edge.b]);
                clusterCount--;
            }
        }

        Set<Edge> resultSet = new HashSet<>();
        while (resultSet.size() < targetClusters - 1) {
            Edge edge = edgeIterator.next();
            if (nodes[edge.a].findSet() != nodes[edge.b].findSet()) {
                nodes[edge.a].union(nodes[edge.b]);
                resultSet.add(edge);
            }
        }
        return resultSet;
    }

    private Node[] initialiseNodes() {
        Node[] nodes = new Node[graph.nodeCount+1];

        for (int i=1; i<=graph.nodeCount; i++) {
            nodes[i] = new Node(i);
        }
        return nodes;
    }

    List<Edge> getSortedEdges() {
        List<Edge> edges = new ArrayList<>(graph.edges);
        Collections.sort(edges, (e1, e2) -> Long.compare(e1.weight, e2.weight));
        return edges;
    }
}
