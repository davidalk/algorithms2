package uk.co.alkanani.floydwarshall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.FloydWarshallResult;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FloydWarshallAlgorithmTest {

    @Test
    public void nonNegativeCycleGraphCalculatesCorrectResult() {
        // given
        Graph graph = FileUtil.loadGraph("g1-test.txt");

        // when
        FloydWarshallAlgorithm algorithm = new FloydWarshallAlgorithm(graph);
        FloydWarshallResult result = algorithm.execute();

        // then
        assertEquals(-6L, result.shortestPathLength);
        assertFalse(result.containsNegativeCycle);
    }

}