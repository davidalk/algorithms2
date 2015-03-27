package uk.co.alkanani.file;

import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.domain.Job;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

    public static Job[] loadJobs(String filename) {
        File file = new File(FileUtil.class.getClassLoader().getResource(filename).getFile());

        Job[] jobs = null;

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int lines = scanner.nextInt();
            jobs = new Job[lines];
            for (int i=0; i<lines; i++) {
                int weight = scanner.nextInt();
                int length = scanner.nextInt();
                Job job = new Job(weight, length);
                jobs[i] = job;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return jobs;
    }

    public static long[][] loadEdges(String filename) {
        File file = new File(FileUtil.class.getClassLoader().getResource(filename).getFile());
        long[][] matrix = null;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int nodes = scanner.nextInt();
            int edgeCount = scanner.nextInt();
            matrix = new long[nodes+1][nodes+1];

            for (int i=0; i<edgeCount; i++) {
                int start = scanner.nextInt();
                int end =  scanner.nextInt();
                long cost = scanner.nextLong();
                matrix[start][end] = cost;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return matrix;
    }

}
