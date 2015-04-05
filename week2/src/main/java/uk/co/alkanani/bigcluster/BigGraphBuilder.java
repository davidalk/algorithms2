package uk.co.alkanani.bigcluster;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BigGraphBuilder {
    private final BigNodeContainer bigNodeContainer;

    public BigGraphBuilder(BigNodeContainer bigNodeContainer) {
        this.bigNodeContainer = bigNodeContainer;
    }

    Set<Integer> generateBitMasks(int bitSize) {
        Integer[] oneBitMasks = new Integer[bitSize];
        oneBitMasks[0] = 1;
        for (int i=1; i<bitSize; i++) {
            oneBitMasks[i] = oneBitMasks[i-1] << 1;
        }

        Set<Integer> masks = new HashSet<>(Arrays.asList(oneBitMasks));
        for (int i=0; i<bitSize-1; i++) {
            for (int j=i+1; j<bitSize; j++) {
                masks.add(oneBitMasks[i] | oneBitMasks[j]);
            }
        }

        return masks;
    }
}
