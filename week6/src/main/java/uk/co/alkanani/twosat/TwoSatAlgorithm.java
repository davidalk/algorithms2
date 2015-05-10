package uk.co.alkanani.twosat;

import uk.co.alkanani.domain.TwoSatClause;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TwoSatAlgorithm {
    private final TwoSatClause[] initialClauses;
    private boolean[] arguments;

    public TwoSatAlgorithm(TwoSatClause[] initialClauses) {
        this.initialClauses = initialClauses;
        arguments = new boolean[initialClauses.length + 1];
    }

    public boolean execute() {
        Set<TwoSatClause> clauses = ClauseReducer.reduce(initialClauses);
        int n = clauses.size();
        System.out.println("Clauses size: " + n);
        Set<Integer> argumentsInPlay = getArgumentsInPlay(clauses);

        for (int i=0; i<Math.log(n); i++) {
            randomiseArguments(argumentsInPlay);

            for (int j=0; j<2 * Math.pow(n, 2); j++) {
                if (isSatisfied(clauses)) {
                    return true;
                }
                flipForUnsatisfiedClause(clauses);

            }
        }

        return false;
    }

    private Set<Integer> getArgumentsInPlay(Set<TwoSatClause> clauses) {
        Set<Integer> result = new HashSet<>();
        for (TwoSatClause clause : clauses) {
            result.add(Math.abs(clause.v1));
            result.add(Math.abs(clause.v2));
        }
        return result;
    }

    private void randomiseArguments(Set<Integer> argumentsInPlay) {
        Random random = new Random();
        for (Integer integer : argumentsInPlay) {
            arguments[integer] = random.nextBoolean();
        }

    }

    private boolean isSatisfied(Set<TwoSatClause> clauses) {
        for (TwoSatClause clause : clauses) {
            if (!clause.isSatisfied(arguments)) {
                return false;
            }
        }
        return true;
    }

    private void flipForUnsatisfiedClause(Set<TwoSatClause> clauses) {
        TwoSatClause clause = null;
        for (TwoSatClause twoSatClause : clauses) {
            if (!twoSatClause.isSatisfied(arguments)) {
                clause = twoSatClause;
                break;
            }
        }
        if (clause == null) {
            throw new IllegalStateException("Could not fund unsatisfied Clause");
        }

        boolean arg1Negation = clause.v1 < 0 ? false : true;
        int arg1 = Math.abs(clause.v1);
        boolean arg2Negation = clause.v2 < 0 ? false : true;
        int arg2 = Math.abs(clause.v2);

        if (arguments[arg1] != arg1Negation) {
            arguments[arg1] = !arguments[arg1];
        } else if(arguments[arg2] != arg2Negation) {
            arguments[arg2] = !arguments[arg2];
        } else {
            throw new IllegalStateException("Could not find argument to flip");
        }
    }
}
