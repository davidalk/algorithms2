package uk.co.alkanani.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TwoSatClauseTest {

    @Test
    public void isSatisfiedReturnsCorrectResult() {
        // given
        TwoSatClause clause = new TwoSatClause(-3, 1);
        boolean[] arg1 = {false, true, true, true};
        boolean[] arg2 = {false, false, true, false};
        boolean[] arg3 = {false, true, false, false};
        boolean[] arg4 = {true, false, false, true};

        // when & then
        assertTrue(clause.isSatisfied(arg1));
        assertTrue(clause.isSatisfied(arg2));
        assertTrue(clause.isSatisfied(arg3));
        assertFalse(clause.isSatisfied(arg4));
    }
}