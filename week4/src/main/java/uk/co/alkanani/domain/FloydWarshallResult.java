package uk.co.alkanani.domain;

public class FloydWarshallResult {
    public final long shortestPathLength;

    private final long resultArray[][][];

    public boolean containsNegativeCycle;

    public FloydWarshallResult(long shortestPathLength, long[][][] resultArray, boolean containsNegativeCycle) {
        this.shortestPathLength = shortestPathLength;
        this.resultArray = resultArray;
        this.containsNegativeCycle = containsNegativeCycle;
    }

}
