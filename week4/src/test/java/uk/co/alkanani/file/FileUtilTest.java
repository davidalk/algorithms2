package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Graph;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileUtilTest {

    @Test
    public void graphLoadsCorrectly() {
        // given
        int nodeCount = 5;
        int edgeCount = 7;
        Long[][] edges = new Long[6][6];

        edges[1][2] = 1L;
        edges[2][4] = -2L;
        edges[4][1] = 2L;
        edges[2][5] = -3L;
        edges[5][3] = 5L;
        edges[1][3] = -6L;
        edges[4][5] = 0L;

        Graph expected = new Graph(nodeCount, edgeCount, edges);

        // when
        Graph result = FileUtil.loadGraph("g1-test.txt");

        // then
        assertEquals(expected, result);
    }
}