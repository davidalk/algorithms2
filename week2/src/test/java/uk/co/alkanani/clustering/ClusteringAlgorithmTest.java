package uk.co.alkanani.clustering;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ClusteringAlgorithmTest {

    @Test
    public void clusteringAlgorithmGeneratesCorrectMaximumEdgeSet() {
        // given
        int expected = 8 + 9;
        Graph graph = FileUtil.loadGraph("clustering-test.txt");

        // when
        ClusteringAlgorithm algorithm = new ClusteringAlgorithm(graph);
        Set<Edge> edgeResult = algorithm.execute(3);
        int result = 0;
        for (Edge edge : edgeResult) {
            result += edge.weight;
        }


        // then
        assertEquals(expected, result);
    }

    @Test
    public void edgeSortMethodReturnsCorrectList() {
        // given
        Edge edge1 = new Edge(1, 2, 10);
        Edge edge2 = new Edge(2, 3, 2);
        Edge edge3 = new Edge(3, 4, 15);
        Edge edge4 = new Edge(4, 5, 7);
        ImmutableList<Edge> edges = new ImmutableList.Builder<Edge>().add(edge1, edge2, edge3, edge4).build();
        Graph graph = new Graph(5, edges);

        List<Edge> expected = Arrays.asList(edge2, edge4, edge1, edge3);

        // when
        ClusteringAlgorithm algorithm = new ClusteringAlgorithm(graph);
        List<Edge> result = algorithm.getSortedEdges();

        // then
        assertEquals(expected, result);
    }
}