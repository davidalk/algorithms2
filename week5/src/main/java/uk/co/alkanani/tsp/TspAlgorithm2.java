package uk.co.alkanani.tsp;

import uk.co.alkanani.domain.Coordinate;

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

        }

        return 0;
    }

    private void initialiseResults() {
        result = new float[mainBitSet+1][n+1];
        result[1][1] = 0;
        for (int i=2; i<=mainBitSet; i++) {
            result[i][1] = Float.MAX_VALUE;
        }
    }
}
