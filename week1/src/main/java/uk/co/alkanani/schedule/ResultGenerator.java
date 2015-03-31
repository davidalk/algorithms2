package uk.co.alkanani.schedule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import uk.co.alkanani.domain.Job;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        Injector injector = Guice.createInjector(new SchedulerModule());
        JobScheduler scheduler = injector.getInstance(JobScheduler.class);

        Job[] jobs = FileUtil.loadJobs("jobs.txt");
        long diffSum = scheduler.getDifferenceComparedCompletionTimes(jobs);
        System.out.println("Difference comparator result: " + diffSum);

        Job[] jobs2 = FileUtil.loadJobs("jobs.txt");
        long ratioSum = scheduler.getRatioComparedCompletionTimes(jobs2);
        System.out.println("Ratio comparator result: " + ratioSum);

    }
}
