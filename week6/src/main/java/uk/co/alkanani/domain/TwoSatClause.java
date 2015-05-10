package uk.co.alkanani.domain;

public class TwoSatClause {
    final boolean v1Negation;
    final int v1;
    final boolean v2Negation;
    final int v2;

    public TwoSatClause(boolean v1Negation, int v1, boolean v2Negation, int v2) {
        this.v1Negation = v1Negation;
        this.v1 = v1;
        this.v2Negation = v2Negation;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoSatClause that = (TwoSatClause) o;

        if (v1Negation != that.v1Negation) return false;
        if (v1 != that.v1) return false;
        if (v2Negation != that.v2Negation) return false;
        return v2 == that.v2;

    }

    @Override
    public int hashCode() {
        int result = (v1Negation ? 1 : 0);
        result = 31 * result + v1;
        result = 31 * result + (v2Negation ? 1 : 0);
        result = 31 * result + v2;
        return result;
    }

    public boolean isSatisfied(boolean[] arguments) {
        boolean arg1 = v1Negation ? !arguments[v1] : arguments[v1];
        boolean arg2 = v2Negation ? !arguments[v2] : arguments[v2];
        return arg1 || arg2;
    }
}
