package uk.co.alkanani.bigcluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class BigGraphUtilTest {

    @Test
    public void bitMaskGeneratedCorrectly() {
        // given
        Set<Integer> expectedOneBit = new HashSet<>(Arrays.asList(1, 2, 4, 8));
        Set<Integer> expectedTwoBit = new HashSet<>(Arrays.asList(3, 5, 9, 6, 10, 12));

        // when
        List<Set<Integer>> result = BigGraphUtil.generateBitMasks(4);

        // then
        assertEquals(expectedOneBit, result.get(0));
        assertEquals(expectedTwoBit, result.get(1));
    }

}