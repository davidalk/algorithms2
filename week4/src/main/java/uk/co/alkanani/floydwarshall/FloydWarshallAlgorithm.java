package uk.co.alkanani.floydwarshall;

import uk.co.alkanani.domain.FloydWarshallResult;
import uk.co.alkanani.domain.Graph;

public class FloydWarshallAlgorithm {
    private final Graph graph;
    private final Long[][] edges;
    private long shortestPath;

    public FloydWarshallAlgorithm(Graph graph) {
        this.graph = graph;
        edges = graph.edges;
        shortestPath = Long.MAX_VALUE;
    }

    public FloydWarshallResult execute() {
        long resultArray[][][] = new long[graph.nodeCount+1][graph.nodeCount+1][graph.nodeCount+1];
        initialiseResultArray(resultArray);

        for (int k=1; k<=graph.nodeCount; k++) {
            for (int i=1; i<=graph.nodeCount; i++) {
                for (int j=1; j<=graph.nodeCount; j++) {
                    long caseOne = resultArray[i][j][k-1];
                    long caseTwo = Long.MAX_VALUE;
                    if (resultArray[i][k][k-1] != Long.MAX_VALUE && resultArray[k][j][k-1] != Long.MAX_VALUE) {
                        caseTwo = resultArray[i][k][k-1] + resultArray[k][j][k-1];
                    }

                    resultArray[i][j][k] = caseOne < caseTwo ? caseOne : caseTwo;

                    if (k==graph.nodeCount) {
                        maintainShortestPath(resultArray[i][j][k]);
                    }

                }
            }
        }
        return new FloydWarshallResult(shortestPath, resultArray, graph);
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

}
