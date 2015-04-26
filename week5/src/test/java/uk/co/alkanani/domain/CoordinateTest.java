package uk.co.alkanani.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CoordinateTest {

    @Test
    public void getEuclideanDistanceReturnsCorrectValue() {
        // given
        Coordinate c1 = new Coordinate(2, -1);
        Coordinate c2 = new Coordinate(-2, 2);

        // when
        float answer = c1.getEuclideanDistance(c2);

        // then
        assertEquals(5f, answer, 0f);
    }
}