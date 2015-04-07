package uk.co.alkanani.bigcluster;

import uk.co.alkanani.domain.Node;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BigClusteringAlgorithm {
    private final BigNodeContainer bigNodeContainer;
    private int clusters;

    public BigClusteringAlgorithm(BigNodeContainer bigNodeContainer) {
        this.bigNodeContainer = bigNodeContainer;
        this.clusters = bigNodeContainer.nodeCount;
    }

    public int getMaxClusters() {
        Map<Integer, Set<Node>> nodeMap = bigNodeContainer.nodeMap;
        List<Set<Integer>> bitMasks = BigGraphUtil.generateBitMasks(bigNodeContainer.bitSize);

        // union all zero distance edges
        nodeMap.values().forEach((nodeSet) -> {
            if (nodeSet.size() > 1) {
                Node first = nodeSet.iterator().next();
                nodeSet.forEach((node) -> {
                    if (first.findSet() != node.findSet()) {
                        first.union(node);
                        clusters--;
                    }
                });
            }
        });

        // join all one distance clusters
        for (Integer mask : bitMasks.get(0)) {
            joinClusters(nodeMap, mask);
        }

        // join all two distance clusters
        for (Integer mask : bitMasks.get(1)) {
            joinClusters(nodeMap, mask);
        }


        return clusters;
    }

    private void joinClusters(Map<Integer, Set<Node>> nodeMap, Integer mask) {
        for (Integer key : nodeMap.keySet()) {
            int xorVal = key ^ mask;
            if (nodeMap.containsKey(xorVal)) {
                Node nodeA = nodeMap.get(key).iterator().next();
                Node nodeB = nodeMap.get(xorVal).iterator().next();
                if (nodeA.findSet() != nodeB.findSet()) {
                    nodeA.union(nodeB);
                    clusters--;
                }
            }
        }
    }

}
