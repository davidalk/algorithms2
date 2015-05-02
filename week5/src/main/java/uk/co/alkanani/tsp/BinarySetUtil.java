package uk.co.alkanani.tsp;

import java.util.*;

public class BinarySetUtil {

    public static BitSet intToBitSet(int i) {
        return BitSet.valueOf(new long[]{i});
    }

    public static int bitSetToInt(BitSet b) {
        return (int) b.toLongArray()[0];
    }

    public static int nextSetSameBitCountIncludingOne(int input) {
        if ((input & 1) != 1) {
            throw new IllegalArgumentException("Input set must contain one");
        }
        int result = input >> 1;
        result = nextIntSameBitCount(result);
        result = result << 1;
        result += 1;
        return result;
    }

    private static int nextIntSameBitCount(int input) {
        int i = (input & -input);
        int j = input + i;
        return (((j ^ input) >> 2) / i) | j;
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
