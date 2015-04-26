package uk.co.alkanani.tsp;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BinarySetUtil {

    public static BitSet intToBitSet(int i) {
        return BitSet.valueOf(new long[]{i});
    }

    public static int bitSetToInt(BitSet b) {
        return (int) b.toLongArray()[0];
    }

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

    public static BitSet integerSetToBitSet(Set<Integer> integers) {
        BitSet bitSet = new BitSet();
        integers.forEach(bitSet::set);
        return bitSet;
    }

}
