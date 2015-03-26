package uk.co.alkanani.file;

import uk.co.alkanani.Job;

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
                long weight = scanner.nextLong();
                long length = scanner.nextLong();
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

}
