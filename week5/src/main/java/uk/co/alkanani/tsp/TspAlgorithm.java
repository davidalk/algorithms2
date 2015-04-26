package uk.co.alkanani.tsp;

import uk.co.alkanani.domain.Coordinate;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class TspAlgorithm {
    private final Coordinate[] coordinates;
    private final int n;
    private float[][] result;
    private final int mainBitSet;

    public TspAlgorithm(Coordinate[] coordinates) {
        this.coordinates = coordinates;
        n = coordinates.length;
        mainBitSet = (int) Math.pow(2, n) - 1;
    }

    public float execute() {
        initialiseResults();

        for (int m = 2; m <= n; m++) {
            Set<Set<Integer>> subSets = BinarySetUtil.getSubSets(mainBitSet, m);
            subSets = subSets.stream().filter(s -> s.contains(0)).collect(Collectors.toSet());
            for (Set<Integer> subSet : subSets) {
                BitSet subSetBitSet = BitSet.valueOf(setIntToArrayLong(subSet));
                for (Integer j : subSet) {
                    if (j != 0) {
                        float min = Float.MAX_VALUE;
                        for (Integer k : subSet) {
                            if (k.equals(j)) {
                                continue;
                            }
                            BitSet sMinusJ = (BitSet) subSetBitSet.clone();
                            sMinusJ.clear(j);
                            float test = result[BinarySetUtil.bitSetToInt(sMinusJ)][k];
                            if (test < Float.MAX_VALUE) {
                                test += coordinates[k].getEuclideanDistance(coordinates[j]);
                            }


                            if (test < min) {
                                min = test;
                            }
                        }
                        result[BinarySetUtil.bitSetToInt(subSetBitSet)][j] = min;
                    }
                }
            }
        }

        float answer = Float.MAX_VALUE;
        for (int j=2; j<n; j++) {
            float test = result[mainBitSet][j] + coordinates[j-1].getEuclideanDistance(coordinates[0]);
            if (test < answer) {
                answer = test;
            }
        }
        return answer;
    }

    private void initialiseResults() {
        result = new float[mainBitSet+1][n];
        result[0][0] = 0;
        for (int i = 1; i < mainBitSet; i++) {
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
