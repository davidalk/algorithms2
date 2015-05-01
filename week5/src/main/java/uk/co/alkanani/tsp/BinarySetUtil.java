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
        BitSet bitSet = new BitSet();
        for (int i=0; i<size; i++) {
            bitSet.set(i);
        }
        return bitSetToInt(bitSet);
    }

    public static int createFinishingBitSet(int size, int nodeCount) {
        int lastBit = nodeCount - 1;
        BitSet bitSet = new BitSet();
        for (int i=lastBit; i > (lastBit - size + 1); i--) {
            bitSet.set(i);
        }
        bitSet.set(0);
        return bitSetToInt(bitSet);
    }

    public static Set<Integer> allBitsExceptOne(int inputBitSet) {
        BitSet bitSet = intToBitSet(inputBitSet);
        bitSet.clear(0);
        Set<Integer> result = new HashSet<>();
        bitSet.stream().forEach(i -> result.add(i + 1));
        return result;
    }

    public static Set<Integer> allBits(int inputBitSet) {
        BitSet bitSet = intToBitSet(inputBitSet);
        Set<Integer> result = new HashSet<>();
        bitSet.stream().forEach(i -> result.add(i+1));
        return result;
    }

}
