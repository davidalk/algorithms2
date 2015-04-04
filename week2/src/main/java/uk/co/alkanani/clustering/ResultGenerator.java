package uk.co.alkanani.clustering;

import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

import java.util.Set;

public class ResultGenerator {

    public static void main(String... args) {
        Graph graph = FileUtil.loadEdges("clustering1.txt");
        ClusteringAlgorithm algorithm = new ClusteringAlgorithm(graph);
        Set<Edge> result = algorithm.execute(4);

        long maximumSpacing = 0L;
        System.out.println("Edges are:");
        for (Edge edge : result) {
            System.out.println(edge);
            maximumSpacing += edge.weight;
        }
        System.out.println("Maximum spacing is " + maximumSpacing);

    }
}
