package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Coordinate;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileUtilTest {

    @Test
    public void testTspLoadsCorrectly() {
        // given
        Coordinate[] coordinates = new Coordinate[18];
        coordinates[0] = new Coordinate(0.328521f, 0.354889f);
        coordinates[1] = new Coordinate(0.832f, 0.832126f);
        coordinates[2] = new Coordinate(0.680803f, 0.865528f);
        coordinates[3] = new Coordinate(0.734854f, 0.38191f);
        coordinates[4] = new Coordinate(0.14439f, 0.985427f);
        coordinates[5] = new Coordinate(0.90997f, 0.587277f);
        coordinates[6] = new Coordinate(0.408464f, 0.136019f);
        coordinates[7] = new Coordinate(0.896868f, 0.916344f);
        coordinates[8] = new Coordinate(0.991904f, 0.383134f);
        coordinates[9] = new Coordinate(0.451197f, 0.741267f);
        coordinates[10] = new Coordinate(0.825205f, 0.761446f);
        coordinates[11] = new Coordinate(0.421804f, 0.0374936f);
        coordinates[12] = new Coordinate(0.332503f, 0.26436f);
        coordinates[13] = new Coordinate(0.107117f, 0.51559f);
        coordinates[14] = new Coordinate(0.845227f, 0.21359f);
        coordinates[15] = new Coordinate(0.880095f, 0.593086f);
        coordinates[16] = new Coordinate(0.454773f, 0.834355f);
        coordinates[17] = new Coordinate(0.7464f, 0.363176f);

        // when
        Coordinate[] result = FileUtil.loadCoordinates("tsp-test.txt");

        // then
        assertArrayEquals(coordinates, result);
    }
}