package uk.co.alkanani.bigcluster;

import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        BigNodeContainer container = FileUtil.loadBigNodeContainer("clustering_big.txt");
        BigClusteringAlgorithm algorithm = new BigClusteringAlgorithm(container);
        int clusters = algorithm.getMaxClusters();
        System.out.println("Max cluster size is " + clusters);

    }
}
