package uk.co.alkanani.knapsack;

import org.junit.Test;
import uk.co.alkanani.domain.Knapsack;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

public class KnapsackAlgorithmTest {

    @Test
    public void algorithmReturnsOptimalValue() {
        // given
        Knapsack knapsack = FileUtil.loadKnapsack("knapsack-test.txt");

        // when
        KnapsackAlgorithm algorithm = new KnapsackAlgorithm(knapsack);
        long result = algorithm.calculateOptimalValue();

        // then
        assertEquals(8L, result);
    }

    @Test
    public void largeAlgorithmReturnsOptimalValue() {
        // given
        Knapsack knapsack = FileUtil.loadKnapsack("knapsack-test.txt");

        // when
        KnapsackAlgorithm algorithm = new KnapsackAlgorithm(knapsack);
        long result = algorithm.calculateOptimalValueForLargeKnapsack();

        // then
        assertEquals(8L, result);
    }

}