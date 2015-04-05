package uk.co.alkanani.bigcluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class BigGraphBuilderTest {

    @Test
    public void bitMaskGeneratedCorrectly() {
        // given
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 4, 8));
        expected.addAll(Arrays.asList(3, 5 ,9, 6, 10, 12));

        // when
        BigGraphBuilder graphBuilder = new BigGraphBuilder(mock(BigNodeContainer.class));
        Set<Integer> result = graphBuilder.generateBitMasks(4);

        // then
        assertEquals(expected, result);
    }

}