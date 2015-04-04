package uk.co.alkanani.domain;

public class Edge {
    public final int a;
    public final int b;
    public final long weight;

    public Edge(int a, int b, long weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (a != edge.a) return false;
        if (b != edge.b) return false;
        return weight == edge.weight;

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + (int) (weight ^ (weight >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }
}
