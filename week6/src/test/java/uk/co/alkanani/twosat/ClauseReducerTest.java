package uk.co.alkanani.twosat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.TwoSatClause;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ClauseReducerTest {

    @Test
    public void reductionAlgorithmWorksCorrectlyWhenClearingAllSets() {
        // given
        TwoSatClause[] clauses = new TwoSatClause[4];
        clauses[0] = new TwoSatClause(1, 2);
        clauses[1] = new TwoSatClause(-2, 1);
        clauses[2] = new TwoSatClause(2, 3);
        clauses[3] = new TwoSatClause(2, -3);

        // when
        Set<TwoSatClause> result = ClauseReducer.reduce(clauses);

        // then
        Set<TwoSatClause> expected = new HashSet<>();
        assertEquals(expected, result);
    }

    @Test
    public void reductionWorksCorrectlyWhenSetsRemain() {
        // given
        TwoSatClause[] clauses = new TwoSatClause[8];
        clauses[0] = new TwoSatClause(1, 2);
        clauses[1] = new TwoSatClause(-1, 2);
        clauses[2] = new TwoSatClause(1, -2);
        clauses[3] = new TwoSatClause(-1, -2);
        clauses[4] = new TwoSatClause(4, 5);
        clauses[5] = new TwoSatClause(6, 7);
        clauses[6] = new TwoSatClause(7, 8);
        clauses[7] = new TwoSatClause(1, -8);

        // when
        Set<TwoSatClause> result = ClauseReducer.reduce(clauses);

        // then
        Set<TwoSatClause> expected = new HashSet<>();
        expected.add(new TwoSatClause(1, 2));
        expected.add(new TwoSatClause(-1, 2));
        expected.add(new TwoSatClause(1, -2));
        expected.add(new TwoSatClause(-1, -2));
        assertEquals(expected, result);
    }

}