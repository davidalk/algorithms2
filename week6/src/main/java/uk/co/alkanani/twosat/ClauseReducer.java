package uk.co.alkanani.twosat;

import uk.co.alkanani.domain.TwoSatClause;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClauseReducer {

    public static Set<TwoSatClause> reduce(TwoSatClause[] clauses) {
        int currentSize = clauses.length;
        int newSize = Integer.MAX_VALUE;
        Set<TwoSatClause> twoSatClauseSet = new HashSet<>(Arrays.asList(clauses));

        do {
            reductionIteration(twoSatClauseSet);
            if (newSize < Integer.MAX_VALUE) {
                currentSize = newSize;
            }
            newSize = twoSatClauseSet.size();
        } while(newSize < currentSize);

        return twoSatClauseSet;
    }

    private static void reductionIteration(Set<TwoSatClause> twoSatClauseSet) {
        Set<Integer> arguments = new HashSet<>();
        Set<Integer> argumentsToRemove = new HashSet<>();
        for (TwoSatClause clause : twoSatClauseSet) {
            arguments.add(clause.v1);
            arguments.add(clause.v2);
        }

        arguments.stream().forEach(i -> {
            if (!arguments.contains(-i)) {
                argumentsToRemove.add(i);
            }
        });

        Iterator<TwoSatClause> iterator = twoSatClauseSet.iterator();
        while (iterator.hasNext()) {
            TwoSatClause clause = iterator.next();
            if (argumentsToRemove.contains(clause.v1) || argumentsToRemove.contains(clause.v2)) {
                iterator.remove();
            }
        }

    }
}
