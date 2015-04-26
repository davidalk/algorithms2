package uk.co.alkanani.tsp;

import uk.co.alkanani.domain.Coordinate;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TspAlgorithm {
    private final Coordinate[] coordinates;
    private final int n;
    private float[][] result;
    private int bitSet;

    public TspAlgorithm(Coordinate[] coordinates) {
        this.coordinates = coordinates;
        n = coordinates.length;
        bitSet = (int) Math.pow(2, n);
    }

    public float execute() {
        initialiseResults();
        int bitSetWithoutOne = bitSet >> 1;

        for (int m = 2; m <= n; m++) {
            Set<Set<Integer>> subSets = BinarySetUtil.getSubSets(bitSetWithoutOne, m);
            subSets.forEach(subSet -> {
                BitSet subSetBitSet = BitSet.valueOf(setIntToArrayLong(subSet));
                subSet.forEach(j -> {
                    float min = Float.MIN_VALUE;
                    for (Integer k : subSet) {
                        if (k.equals(j)) {
                            continue;
                        }
                        BitSet sMinusJ = (BitSet) subSetBitSet.clone();
                        sMinusJ.clear(idxForValue(j));
                        float test;
                        if (BinarySetUtil.bitSetToInt(sMinusJ) == 0  && k ==1) {
                            test = coordinates[k-1].getEuclideanDistance(coordinates[j-1]);
                        } else {
                            test = result[BinarySetUtil.bitSetToInt(sMinusJ)][k-1] + coordinates[k-1].getEuclideanDistance(coordinates[j-1]);
                        }

                        if (test<min) {
                            min = test;
                        }
                    }
                });
            });

        }
        return 0;
    }

    private void initialiseResults() {
        int bitSetWithoutOne = bitSet >> 1;
        result = new float[bitSetWithoutOne][n];
        for (int i = 0; i < bitSetWithoutOne; i++) {
            result[i][0] = Float.MAX_VALUE;
        }
    }

    private int valueForIdx(int idx) {
        return (int) Math.pow(2, idx + 1);
    }

    private int idxForValue(int value) {
        return (int) (Math.log(value) / Math.log(2)) + 1;
    }

    private long[] setIntToArrayLong(Set<Integer> set) {
        long[] result = new long[set.size()];
        Iterator<Integer> setIterator = set.iterator();
        for (int i=0; i<set.size(); i++) {
            result[i] = (long) setIterator.next();
        }
        return result;
    }
}
