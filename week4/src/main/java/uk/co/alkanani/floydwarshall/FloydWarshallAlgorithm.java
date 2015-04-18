package uk.co.alkanani.floydwarshall;

import uk.co.alkanani.domain.FloydWarshallResult;
import uk.co.alkanani.domain.Graph;

public class FloydWarshallAlgorithm {
    private final Graph graph;
    private final Long[][] edges;
    private long shortestPath;
    private boolean negativeCycle;

    public FloydWarshallAlgorithm(Graph graph) {
        this.graph = graph;
        edges = graph.edges;
        shortestPath = Long.MAX_VALUE;
        negativeCycle = false;
    }

    public FloydWarshallResult execute() {
        long resultArray[][][] = new long[graph.nodeCount+1][graph.nodeCount+1][2];
        initialiseResultArray(resultArray);

        for (int k=1; k<=graph.nodeCount; k++) {
            for (int i=1; i<=graph.nodeCount; i++) {
                for (int j=1; j<=graph.nodeCount; j++) {
                    long caseOne = resultArray[i][j][0];
                    long caseTwo = Long.MAX_VALUE;
                    if (resultArray[i][k][0] != Long.MAX_VALUE && resultArray[k][j][0] != Long.MAX_VALUE) {
                        caseTwo = resultArray[i][k][0] + resultArray[k][j][0];
                    }

                    resultArray[i][j][1] = caseOne < caseTwo ? caseOne : caseTwo;

                    if (k==graph.nodeCount) {
                        maintainShortestPath(resultArray[i][j][1]);
                        maintainNegativeCycle(i, resultArray);
                    }

                }
            }
            shiftResultArray(resultArray);
        }
        return new FloydWarshallResult(shortestPath, resultArray, negativeCycle);
    }

    private void initialiseResultArray(long resultArray[][][]) {
        for (int i=1; i<=graph.nodeCount; i++) {
            for (int j=1; j<=graph.nodeCount; j++) {
                if (i==j) {
                   resultArray[i][j][0] = 0;
                } else if (edges[i][j] != null) {
                    resultArray[i][j][0] = edges[i][j];
                } else {
                    resultArray[i][j][0] = Long.MAX_VALUE;
                }
            }
        }
    }

    private void maintainShortestPath(long result) {
        if (result < shortestPath) {
            shortestPath = result;
        }
    }

    private void maintainNegativeCycle(int i, long resultArray[][][]) {
        if (resultArray[i][i][1] < 0) {
            negativeCycle = true;
        }
    }

    private void shiftResultArray(long resultArray[][][]) {
        int length = resultArray.length;
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                resultArray[i][j][0] = resultArray[i][j][1];
            }
        }
    }

}
