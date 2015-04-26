package uk.co.alkanani.domain;

public class Coordinate {
    public final float x;
    public final float y;

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (Float.compare(that.x, x) != 0) return false;
        return Float.compare(that.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }

    public float getEuclideanDistance(Coordinate other) {
        double x = (double) this.x;
        double y = (double) this.y;
        double otherX = (double) other.x;
        double otherY = (double) other.y;
        double answer = Math.sqrt(Math.pow(x - otherX, 2) + Math.pow(y - otherY, 2));
        return (float) answer;
    }
}
