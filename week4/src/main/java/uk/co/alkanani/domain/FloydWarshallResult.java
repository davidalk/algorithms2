package uk.co.alkanani.domain;

public class FloydWarshallResult {
    public final long shortestPathLength;

    private final long resultArray[][][];

    private final Graph graph;

    public boolean containsNegativeCycle;

    public FloydWarshallResult(long shortestPathLength, long[][][] resultArray, Graph graph) {
        this.shortestPathLength = shortestPathLength;
        this.resultArray = resultArray;
        this.graph = graph;
        containsNegativeCycle = doesContainNegativeCycle();
    }

    private boolean doesContainNegativeCycle() {
        for (int i=1; i<=graph.nodeCount; i++) {
            if (resultArray[i][i][graph.nodeCount] < 0 ) {
                return true;
            }
        }
        return false;
    }
}
