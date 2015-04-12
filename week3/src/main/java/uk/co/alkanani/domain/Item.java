package uk.co.alkanani.domain;

public class Item {
    public final long value;

    public final int weight;

    public Item(long value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (value != item.value) return false;
        return weight == item.weight;

    }

    @Override
    public int hashCode() {
        int result = (int) (value ^ (value >>> 32));
        result = 31 * result + weight;
        return result;
    }
}