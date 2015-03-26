package uk.co.alkanani.schedule;

import uk.co.alkanani.domain.Job;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        JobScheduler scheduler = new JobScheduler(new DifferenceJobComparator());
        Job[] jobs = FileUtil.loadJobs("jobs.txt");
        int diffSum = scheduler.getSumWeightedCompletionTimes(jobs);
        System.out.println("Difference comparator result: " + diffSum);
    }
}
