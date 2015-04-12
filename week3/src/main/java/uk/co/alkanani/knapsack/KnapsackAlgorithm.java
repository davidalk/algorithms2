package uk.co.alkanani.knapsack;

import uk.co.alkanani.domain.Knapsack;

public class KnapsackAlgorithm {
    private final Knapsack knapsack;

    public KnapsackAlgorithm(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public long calculateOptimalValue() {
        long[][] table = new long[knapsack.itemCount + 1][knapsack.size + 1];
        return 0;
    }
}
