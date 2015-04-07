package uk.co.alkanani.clustering;

import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

import java.util.Set;

public class ResultGenerator {
    private static long maximumSpacing = Long.MAX_VALUE;

    public static void main(String... args) {
        Graph graph = FileUtil.loadGraph("clustering1.txt");
        ClusteringAlgorithm algorithm = new ClusteringAlgorithm(graph);
        Set<Edge> result = algorithm.execute(4);

        System.out.println("Edges are:");
        result.forEach((e) -> {
            System.out.println(e);
            if (e.weight < maximumSpacing) {
                maximumSpacing = e.weight;
            }
        });

        System.out.println("Maximum spacing is " + maximumSpacing);

    }
}
