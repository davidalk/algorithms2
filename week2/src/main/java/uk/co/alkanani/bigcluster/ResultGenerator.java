package uk.co.alkanani.bigcluster;

import uk.co.alkanani.clustering.ClusteringAlgorithm;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

import java.util.Set;

public class ResultGenerator {

    public static void main(String... args) {
        BigNodeContainer nodeContainer = FileUtil.loadBigNodeContainer("clustering_big.txt");
        BigGraphBuilder graphBuilder = new BigGraphBuilder(nodeContainer);
        Graph graph = graphBuilder.buildGraph();
        ClusteringAlgorithm algorithm = new ClusteringAlgorithm(graph);
        Set<Edge> result = algorithm.execute(10);

        System.out.println("Results are: ");
        result.forEach((e) -> System.out.println(e));


    }
}
