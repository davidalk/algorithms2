package uk.co.alkanani.domain;

public class TwoSatClause {
    public final int v1;
    public final int v2;

    public TwoSatClause(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoSatClause clause = (TwoSatClause) o;

        if (v1 != clause.v1) return false;
        return v2 == clause.v2;

    }

    @Override
    public int hashCode() {
        int result = v1;
        result = 31 * result + v2;
        return result;
    }

    public boolean isSatisfied(boolean[] arguments) {
        int i1 = Math.abs(v1);
        int i2 = Math.abs(v2);
        boolean arg1 = v1 < 0 ? !arguments[i1] : arguments[i1];
        boolean arg2 = v2 < 0 ? !arguments[i2] : arguments[i2];
        return arg1 || arg2;
    }
}
