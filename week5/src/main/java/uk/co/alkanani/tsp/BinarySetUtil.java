package uk.co.alkanani.tsp;

import java.util.*;

public class BinarySetUtil {

    public static BitSet intToBitSet(int i) {
        return BitSet.valueOf(new long[]{i});
    }

    public static int bitSetToInt(BitSet b) {
        return (int) b.toLongArray()[0];
    }

    public static int nextIntSameBitCount(int input) {
        int i = (input & -input);
        int j = input + i;
        int result = (((j ^ input) >> 2) / i) | j;
        if ((result & 1) == 1) {
            return result;
        } else {
            return nextIntSameBitCount(result);
        }
    }

    public static int createStartingBitSet(int size) {
        int result = 0;
        for (int i=0; i<size; i++) {
            result = result << 1;
            result += 1;
        }
        return result;
    }

    public static int createFinishingBitSet(int size, int nodeCount) {
        int result = 0;
        for (int i=0; i<size-1; i++) {
            result = result << 1;
            result += 1;
        }

        int zeroCount = nodeCount - size + 1;
        for (int i=0; i<zeroCount; i++) {
            result = result << 1;
        }

        result += 1;
        return result;
    }

    public static Set<Integer> allBitsExceptOne(int inputBitSet) {
        Set<Integer> result = allBits(inputBitSet);
        result.remove(1);
        return result;
    }

    public static Set<Integer> allBits(int inputBitSet) {
        BitSet bitSet = intToBitSet(inputBitSet);
        Set<Integer> result = new HashSet<>();
        bitSet.stream().forEach(i -> result.add(i+1));
        return result;
    }

}
