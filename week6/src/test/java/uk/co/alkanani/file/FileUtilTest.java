package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.TwoSatClause;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileUtilTest {

    @Test
    public void clausesLoadCorrectly() {
        // given
        TwoSatClause[] clauses = new TwoSatClause[6];
        clauses[1] = new TwoSatClause(true, 1, false, 3);
        clauses[2] = new TwoSatClause(false, 2, false, 1);
        clauses[3] = new TwoSatClause(true, 5, true, 4);
        clauses[4] = new TwoSatClause(false, 2, false, 4);
        clauses[5] = new TwoSatClause(true, 3, false, 2);

        // when
        TwoSatClause[] result = FileUtil.loadClauses("2sat-test.txt");

        // then
        assertArrayEquals(clauses, result);
    }
}