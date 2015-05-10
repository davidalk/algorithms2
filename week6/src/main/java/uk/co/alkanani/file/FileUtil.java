package uk.co.alkanani.file;

import uk.co.alkanani.domain.TwoSatClause;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

    public static TwoSatClause[] loadClauses(String filename) {
        File file = CommonFileUtil.getFile(filename);
        int clauseCount;
        TwoSatClause[] clauses;

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            clauseCount = scanner.nextInt();
            clauses = new TwoSatClause[clauseCount + 1];

            for (int i=1; i<=clauseCount; i++) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                boolean v1Negation = false;
                boolean v2Negation = false;
                if (v1 < 0) {
                    v1Negation = true;
                    v1 = Math.abs(v1);
                }
                if (v2 < 0) {
                    v2Negation = true;
                    v2 = Math.abs(v2);
                }
                clauses[i] = new TwoSatClause(v1Negation, v1, v2Negation, v2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return clauses;
    }
}
