package uk.co.alkanani.bigcluster;

import com.google.common.collect.ImmutableList;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.domain.Node;

import java.util.*;

public class BigGraphBuilder {
    private final BigNodeContainer bigNodeContainer;

    public BigGraphBuilder(BigNodeContainer bigNodeContainer) {
        this.bigNodeContainer = bigNodeContainer;
    }

    public Graph buildGraph() {
        List<Set<Integer>> bitMasks = generateBitMasks(bigNodeContainer.bitSize);
        int nodeCount = bigNodeContainer.nodeCount;
        Map<Integer, Set<Node>> nodeMap = bigNodeContainer.nodeMap;
        ImmutableList.Builder<Edge> edgeBuilder = new ImmutableList.Builder<>();

        for (Integer integer : nodeMap.keySet()) {
            Set<Node> sourceNodes = nodeMap.get(integer);

            // one bit xor check
            for (Integer mask : bitMasks.get(0)) {
                int xorVal = integer ^ mask;
                if (nodeMap.containsKey(xorVal)) {
                    for (Node targetNode : nodeMap.get(xorVal)) {
                        for (Node sourceNode : sourceNodes) {
                            Edge edge = new Edge(sourceNode.nodeId, targetNode.nodeId, 1);
                            edgeBuilder.add(edge);
                        }

                    }
                }
            }

            // two bit xor check
            for (Integer mask : bitMasks.get(1)) {
                int xorVal = integer ^ mask;
                if (nodeMap.containsKey(xorVal)) {
                    for (Node targetNode : nodeMap.get(xorVal)) {
                        for (Node sourceNode : sourceNodes) {
                            Edge edge = new Edge(sourceNode.nodeId, targetNode.nodeId, 2);
                            edgeBuilder.add(edge);
                        }

                    }

                }
            }

        }

        return new Graph(nodeCount, edgeBuilder.build());
    }

    List<Set<Integer>> generateBitMasks(int bitSize) {
        Integer[] oneBitMasks = new Integer[bitSize];
        oneBitMasks[0] = 1;
        for (int i=1; i<bitSize; i++) {
            oneBitMasks[i] = oneBitMasks[i-1] << 1;
        }
        Set<Integer> oneBitSet = new HashSet<>(Arrays.asList(oneBitMasks));

        Set<Integer> twoBitSet = new HashSet<>();
        for (int i=0; i<bitSize-1; i++) {
            for (int j=i+1; j<bitSize; j++) {
                twoBitSet.add(oneBitMasks[i] | oneBitMasks[j]);
            }
        }

        List<Set<Integer>> masks = new ArrayList<>();
        masks.add(oneBitSet);
        masks.add(twoBitSet);
        return masks;
    }

}
