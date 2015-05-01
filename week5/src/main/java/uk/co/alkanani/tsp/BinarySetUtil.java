package uk.co.alkanani.tsp;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.util.*;
import java.util.stream.Collectors;

public class BinarySetUtil {

    public static BitSet intToBitSet(int i) {
        return BitSet.valueOf(new long[]{i});
    }

    public static int bitSetToInt(BitSet b) {
        return (int) b.toLongArray()[0];
    }

    @Deprecated
    public static Set<Set<Integer>> getSubSets(int set, int k) {
        BitSet bitSet = intToBitSet(set);
        if (k > bitSet.cardinality()) {
            throw new IllegalArgumentException("Subset size k can not be greater than set size");
        }
        List<Integer> setASList = bitSet.stream().boxed().collect(Collectors.toList());

        ICombinatoricsVector<Integer> initialSet = Factory.createVector(setASList);
        Generator<Integer> generator = Factory.createSimpleCombinationGenerator(initialSet, k);

        return generator
                .generateAllObjects()
                .stream()
                .map(v -> new HashSet<>(v.getVector()))
                .collect(Collectors.toSet());
    }

    @Deprecated
    public static BitSet integerSetToBitSet(Set<Integer> integers) {
        BitSet bitSet = new BitSet();
        integers.forEach(bitSet::set);
        return bitSet;
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
        bitSet.stream().forEach(i -> result.add(i+1));
        return result;
    }

}
