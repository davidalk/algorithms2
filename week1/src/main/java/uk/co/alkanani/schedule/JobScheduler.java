package uk.co.alkanani.schedule;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import uk.co.alkanani.domain.Job;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduler {
    private final Comparator<Job> ratioJobComparator;
    private final Comparator<Job> differenceJobComparator;

    @Inject
    public JobScheduler(@Named("Ratio") Comparator<Job> ratio,
                        @Named("Difference") Comparator<Job> difference) {
        ratioJobComparator = ratio;
        differenceJobComparator = difference;
    }

    private long getSumWeightedCompletionTimes(Job[] jobs, Comparator<Job> comparator) {
        Arrays.sort(jobs, comparator);
        long sum = 0;
        long currentCompletionTime = 0;

        for (int i=0; i<jobs.length; i++) {
            currentCompletionTime += jobs[i].getLength();
            sum += jobs[i].getWeight() * currentCompletionTime;
        }
        return sum;
    }

    public long getRatioComparedCompletionTimes(Job[] jobs) {
        return getSumWeightedCompletionTimes(jobs, ratioJobComparator);
    }

    public long getDifferenceComparedCompletionTimes(Job[] jobs) {
        return getSumWeightedCompletionTimes(jobs, differenceJobComparator);
    }
}
