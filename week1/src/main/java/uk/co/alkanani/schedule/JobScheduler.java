package uk.co.alkanani.schedule;

import uk.co.alkanani.domain.Job;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduler {
    private final Comparator<Job> jobComparator;

    public JobScheduler(Comparator<Job> comparator) {
        jobComparator = comparator;
    }

    public int getSumWeightedCompletionTimes(Job[] jobs) {
        Arrays.sort(jobs, jobComparator);
        int sum = 0;
        int currentCompletionTime = 0;

        for (int i=0; i<jobs.length; i++) {
            currentCompletionTime += jobs[i].getLength();
            sum += jobs[i].getWeight() * currentCompletionTime;
        }
        return sum;
    }
}
