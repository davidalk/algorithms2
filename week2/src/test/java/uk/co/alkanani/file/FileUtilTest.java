package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileUtilTest {

    @Test
    public void loadEdgesReturnsCorrectList() {
        // given
        Edge edge1 = new Edge(1, 2, 4);
        Edge edge2 = new Edge(1, 8, 8);
        Edge edge3 = new Edge(2, 8, 11);
        Edge edge4 = new Edge(2, 3, 8);
        Edge edge5 = new Edge(3, 9, 2);
        Edge edge6 = new Edge(3, 4, 7);
        Edge edge7 = new Edge(4, 5, 9);
        Edge edge8 = new Edge(5, 6, 10);
        Edge edge9 = new Edge(6, 4, 14);
        Edge edge10 = new Edge(6, 7, 2);
        Edge edge11 = new Edge(6, 3, 4);
        Edge edge12 = new Edge(7, 9, 6);
        Edge edge13 = new Edge(7, 8, 1);
        Edge edge14 = new Edge(8, 9, 7);
        List<Edge> edges =
                Arrays.asList(edge1, edge2, edge3, edge4, edge5, edge6, edge7,
                        edge8, edge9, edge10, edge11, edge12, edge13, edge14);
        Graph expected = new Graph(9, edges);

        // when
        Graph result = FileUtil.loadEdges("clustering-test.txt");

        // then
        assertEquals(expected, result);
    }
}