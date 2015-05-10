package uk.co.alkanani.twosat;

import uk.co.alkanani.domain.TwoSatClause;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        TwoSatClause[] clauses = FileUtil.loadClauses("2sat6.txt");
        TwoSatAlgorithm algorithm = new TwoSatAlgorithm(clauses);
        boolean result = algorithm.execute();
        System.out.println("Result for file:  " + result);


    }
}
