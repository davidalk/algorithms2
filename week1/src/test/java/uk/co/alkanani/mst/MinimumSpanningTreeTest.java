package uk.co.alkanani.mst;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MinimumSpanningTreeTest {
    private MinimumSpanningTree minimumSpanningTree;

    @Before
    public void setUp() {
        minimumSpanningTree = new MinimumSpanningTree(1);
    }

    @Test
    public void spanningTreeGeneratedCorrectly() {
        // given
        Edge edge1 = new Edge(1, 2, 4);
        Edge edge2 = new Edge(2, 3, 1);
        Edge edge3 = new Edge(3, 4, 2);
        Set<Edge> spanningTree = new HashSet<Edge>();
        spanningTree.add(edge1);
        spanningTree.add(edge2);
        spanningTree.add(edge3);

        // when
        Graph graph = FileUtil.loadEdges("test-edges.txt");
        Set<Edge> result = minimumSpanningTree.generateSpanningTree(graph);

        // then
        assertEquals(spanningTree, result);
    }

}