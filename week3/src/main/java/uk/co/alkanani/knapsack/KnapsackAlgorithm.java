package uk.co.alkanani.knapsack;

import uk.co.alkanani.domain.Item;
import uk.co.alkanani.domain.Knapsack;

import java.util.Arrays;

public class KnapsackAlgorithm {
    private final Knapsack knapsack;

    public KnapsackAlgorithm(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public long calculateOptimalValue() {
        long[][] table = new long[knapsack.itemCount + 1][knapsack.size + 1];
        Item[] items = knapsack.items;

        for (int x=0; x<=knapsack.size; x++) {
            table[0][x] = 0;
        }

        for (int i=1; i<=knapsack.itemCount; i++) {
            for (int x=0; x<=knapsack.size; x++) {
                long val1 = table[i-1][x];
                long val2 = 0;

                int offset = x - items[i-1].weight;
                if (offset >= 0) {
                    val2 = table[i-1][offset] + items[i-1].value;
                }

                if (val1 > val2) {
                    table[i][x] = val1;
                } else {
                    table[i][x] = val2;
                }
            }
        }

        return table[knapsack.itemCount][knapsack.size];
    }

    public long calculateOptimalValueForLargeKnapsack() {
        long[][] table = new long[2][knapsack.size + 1];
        Item[] items = knapsack.items;

        for (int x=0; x<=knapsack.size; x++) {
            table[0][x] = 0;
        }

        for (int i=1; i<=knapsack.itemCount; i++) {
            for (int x=0; x<=knapsack.size; x++) {
                long val1 = table[0][x];
                long val2 = 0;

                int offset = x - items[i-1].weight;
                if (offset >= 0) {
                    val2 = table[0][offset] + items[i-1].value;
                }

                if (val1 > val2) {
                    table[1][x] = val1;
                } else {
                    table[1][x] = val2;
                }
            }
            table[0] = Arrays.copyOf(table[1], table[1].length);
        }

        return table[1][knapsack.size];
    }
}
