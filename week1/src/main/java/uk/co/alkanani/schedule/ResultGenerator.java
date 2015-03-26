package uk.co.alkanani.schedule;

import uk.co.alkanani.domain.Job;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        JobScheduler diffScheduler = new JobScheduler(new DifferenceJobComparator());
        Job[] jobs = FileUtil.loadJobs("jobs.txt");
        long diffSum = diffScheduler.getSumWeightedCompletionTimes(jobs);
        System.out.println("Difference comparator result: " + diffSum);

        JobScheduler ratioScheduler = new JobScheduler(new RatioJobComparator());
        Job[] jobs2 = FileUtil.loadJobs("jobs.txt");
        long ratioSum = ratioScheduler.getSumWeightedCompletionTimes(jobs2);
        System.out.println("Ratio comparator result: " + ratioSum);

    }
}
