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
        TwoSatClause[] clauses = new TwoSatClause[5];
        clauses[0] = new TwoSatClause(-1, 3);
        clauses[1] = new TwoSatClause(2, 1);
        clauses[2] = new TwoSatClause(-5, -4);
        clauses[3] = new TwoSatClause(2, 4);
        clauses[4] = new TwoSatClause(-3, 2);

        // when
        TwoSatClause[] result = FileUtil.loadClauses("2sat-test.txt");

        // then
        assertArrayEquals(clauses, result);
    }
}