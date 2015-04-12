package uk.co.alkanani.knapsack;

import uk.co.alkanani.domain.Knapsack;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        Knapsack smallKnapsack = FileUtil.loadKnapsack("knapsack1.txt");
        KnapsackAlgorithm algorithm = new KnapsackAlgorithm(smallKnapsack);
        long optimalSmall = algorithm.calculateOptimalValue();
        System.out.println("Optimal small value " + optimalSmall);

        Knapsack largeKnapsack = FileUtil.loadKnapsack("knapsack_big.txt");
        KnapsackAlgorithm largeAlgorithm = new KnapsackAlgorithm(largeKnapsack);
        long optimalLarge = largeAlgorithm.calculateOptimalValueForLargeKnapsack();
        System.out.println("Optimal small value " + optimalLarge);

    }
}
