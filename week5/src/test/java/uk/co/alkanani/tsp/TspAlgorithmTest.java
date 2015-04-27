package uk.co.alkanani.tsp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Coordinate;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TspAlgorithmTest {

    @Test
    public void tspAlgorithmReturnsExpectedValue() {
        // given
        Coordinate[] coordinates = FileUtil.loadCoordinates("tsp-test.txt");
        TspAlgorithm algorithm = new TspAlgorithm(coordinates);

        // when
        float result = algorithm.execute();

        // then
        assertEquals(3.50116f, result, 0.2f);
    }

    @Test
    public void smallTspReturnsExpectedValue() {
        // given
        Coordinate[] coordinates = new Coordinate[4];
        coordinates[0] = new Coordinate(1, 1);
        coordinates[1] = new Coordinate(1, -4);
        coordinates[2] = new Coordinate(3, 1.5f);
        coordinates[3] = new Coordinate(3, -3.5f);
        TspAlgorithm algorithm = new TspAlgorithm(coordinates);

        // when
        float result = algorithm.execute();

        // then
        assertEquals(14.2f, result, 0.1f);
    }
}