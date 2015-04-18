package uk.co.alkanani.floydwarshall;

import uk.co.alkanani.domain.FloydWarshallResult;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        Graph graph1 = FileUtil.loadGraph("g1.txt");
        FloydWarshallAlgorithm algorithm1 = new FloydWarshallAlgorithm(graph1);
        FloydWarshallResult result1 = algorithm1.execute();

        System.out.println("Graph 1, shortest path: " + result1.shortestPathLength + " negative cycle: " + result1.containsNegativeCycle);

        Graph graph2 = FileUtil.loadGraph("g2.txt");
        FloydWarshallAlgorithm algorithm2 = new FloydWarshallAlgorithm(graph2);

    }
}
