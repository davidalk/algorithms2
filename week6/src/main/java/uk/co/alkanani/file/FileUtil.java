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

                clauses[i] = new TwoSatClause(v1, v2);
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
