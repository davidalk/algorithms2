package uk.co.alkanani.domain;

import java.util.Arrays;

public class Knapsack {
    public final int size;

    public final int itemCount;

    public final Item[] items;

    public Knapsack(int size, int itemCount, Item[] items) {
        this.size = size;
        this.itemCount = itemCount;
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knapsack knapsack = (Knapsack) o;

        if (size != knapsack.size) return false;
        if (itemCount != knapsack.itemCount) return false;
        return Arrays.equals(items, knapsack.items);

    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + itemCount;
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
