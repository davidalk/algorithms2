package uk.co.alkanani.domain;

public class Job {
    long weight;

    long length;

    public Job(long weight, long length) {
        this.weight = weight;
        this.length = length;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
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
        int result = (int) (weight ^ (weight >>> 32));
        result = 31 * result + (int) (length ^ (length >>> 32));
        return result;
    }
}
