package uk.co.alkanani.bigcluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BigClusteringAlgorithmTest {

    @Test
    public void maxClusterReturnsCorrectValue() {
        // given
        BigNodeContainer container = FileUtil.loadBigNodeContainer("clustering-big-test.txt");
        BigClusteringAlgorithm algorithm = new BigClusteringAlgorithm(container);

        // when
        int clusters = algorithm.getMaxClusters();

        // then
        assertEquals(1, clusters);
    }

}