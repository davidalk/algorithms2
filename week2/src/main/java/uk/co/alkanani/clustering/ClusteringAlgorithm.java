package uk.co.alkanani.clustering;

import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.domain.Node;

import java.util.*;

public class ClusteringAlgorithm {
    private final Graph graph;

    public ClusteringAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public Set<Edge> execute(int targetClusters) {
        Node[] nodes = initialiseNodes();
        int clusterCount = graph.nodeCount;
        List<Edge> sortedEdges = getSortedEdges();

        Iterator<Edge> edgeIterator = sortedEdges.iterator();
        while (clusterCount > targetClusters) {
            Edge edge = edgeIterator.next();
            if (nodes[edge.a].findSet() != nodes[edge.b].findSet()) {
                nodes[edge.a].union(nodes[edge.b]);
                clusterCount--;
            }
        }

        Collections.reverse(sortedEdges);
        Set<Edge> resultSet = new HashSet<>();
        Iterator<Edge> reverseEdgeIterator = sortedEdges.iterator();
        while (resultSet.size() < targetClusters - 1) {
            Edge edge = reverseEdgeIterator.next();
            if (nodes[edge.a].findSet() != nodes[edge.b].findSet()) {
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
        List<Edge> edges = graph.edges;

        Collections.sort(edges, (e1, e2) -> {
            long diff = e1.weight - e2.weight;
            if (diff == 0) {
                return 0;
            } else if (diff > 0) {
                return 1;
            } else {
                return -1;
            }
        });

        return edges;
    }
}
