package uk.co.alkanani.domain;

public class Edge {
    private int start;

    private int end;

    private long cost;

    public Edge(int start, int end, long cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (start != edge.start) return false;
        if (end != edge.end) return false;
        return cost == edge.cost;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        result = 31 * result + (int) (cost ^ (cost >>> 32));
        return result;
    }
}
