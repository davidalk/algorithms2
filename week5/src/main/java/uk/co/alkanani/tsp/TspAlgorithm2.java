package uk.co.alkanani.tsp;

import uk.co.alkanani.domain.Coordinate;

import java.util.BitSet;
import java.util.Set;

public class TspAlgorithm2 {
    private final Coordinate[] coordinates;
    private final int n;
    private float[][] result;
    private final int mainBitSet;

    public TspAlgorithm2(Coordinate[] coordinates) {
        this.coordinates = new Coordinate[coordinates.length +1];
        this.coordinates[0] = null;
        for (int i=0; i<coordinates.length; i++) {
            this.coordinates[i+1] = coordinates[i];
        }
        n = coordinates.length;
        mainBitSet = (int) Math.pow(2, n) - 1;
    }

    public float execute() {
        initialiseResults();

        for (int m=2; m<=n; m++) {
            
            int currentBitSet = BinarySetUtil.createStartingBitSet(m);
            int finishingBitSet = BinarySetUtil.createFinishingBitSet(m, n);
            boolean runLastSet = false;
            while (!runLastSet) {
                if (currentBitSet == finishingBitSet) {
                    runLastSet = true;
                }

                Set<Integer> subSet = BinarySetUtil.allBitsExceptOne(currentBitSet);
                for (int j : subSet) {

                    // find min
                    float min = Float.MIN_VALUE;
                    for (int k : subSet) {
                        if (k!=j) {
                            BitSet bitSet = BinarySetUtil.intToBitSet(currentBitSet);
                            bitSet.clear(j-1);
                            int subSetMinusJ = BinarySetUtil.bitSetToInt(bitSet);
                            float test = result[subSetMinusJ][k];
                            if (test < Float.MAX_VALUE) {
                                test += coordinates[k].getEuclideanDistance(coordinates[j]);
                            }
                            if (test < min) {
                                min = test;
                            }
                        }
                    }
                    // end find min

                }  // end j loop

                currentBitSet = BinarySetUtil.nextIntSameBitCount(currentBitSet);
            }  // end subSet loop

        }  // end m loop

        float answer = Float.MAX_VALUE;
        for (int j=2; j<=n; j++) {
            float test = result[mainBitSet][j] +
                    coordinates[j].getEuclideanDistance(coordinates[1]);
            if (test < answer) {
                test = answer;
            }
        }

        return answer;
    }

    private void initialiseResults() {
        result = new float[mainBitSet+1][n+1];
        result[1][1] = 0;
        for (int i=2; i<=mainBitSet; i++) {
            result[i][1] = Float.MAX_VALUE;
        }
    }
}
