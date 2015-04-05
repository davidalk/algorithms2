package uk.co.alkanani.bigcluster;

import java.util.*;

public class BigGraphUtil {

    public static List<Set<Integer>> generateBitMasks(int bitSize) {
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
