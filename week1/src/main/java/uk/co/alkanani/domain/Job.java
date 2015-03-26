package uk.co.alkanani.domain;

public class Job {
    int weight;

    int length;

    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (weight != job.weight) return false;
        return length == job.length;

    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + length;
        return result;
    }
}
