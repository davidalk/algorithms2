package uk.co.alkanani.twosat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.TwoSatClause;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TwoSatAlgorithmTest {

    @Test
    public void testFile2ReturnsCorrectResult() {
        // given
        TwoSatClause[] clauses = FileUtil.loadClauses("2sat-test2.txt");
        TwoSatAlgorithm algorithm = new TwoSatAlgorithm(clauses);

        // when
        boolean result = algorithm.execute();

        // then
        assertTrue(result);
    }

    @Test
    public void testFile3ReturnsCorrectResult() {
        // given
        TwoSatClause[] clauses = FileUtil.loadClauses("2sat-test3.txt");
        TwoSatAlgorithm algorithm = new TwoSatAlgorithm(clauses);

        // when
        boolean result = algorithm.execute();

        // then
        assertFalse(result);
    }

    @Test
    public void testFile4ReturnsCorrectResult() {
        // given
        TwoSatClause[] clauses = FileUtil.loadClauses("2sat-test4.txt");
        TwoSatAlgorithm algorithm = new TwoSatAlgorithm(clauses);

        // when
        boolean result = algorithm.execute();

        // then
        assertTrue(result);
    }
}