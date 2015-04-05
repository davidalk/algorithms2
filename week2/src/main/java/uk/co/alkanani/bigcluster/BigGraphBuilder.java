package uk.co.alkanani.bigcluster;

import com.google.common.collect.ImmutableList;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;

import java.util.*;

public class BigGraphBuilder {
    private final BigNodeContainer bigNodeContainer;

    public BigGraphBuilder(BigNodeContainer bigNodeContainer) {
        this.bigNodeContainer = bigNodeContainer;
    }

    public Graph buildGraph() {
        List<Set<Integer>> bitMasks = generateBitMasks(bigNodeContainer.bitSize);
        int nodeCount = bigNodeContainer.nodeCount;
        ImmutableList.Builder<Edge> edgeBuilder = new ImmutableList.Builder<>();



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
