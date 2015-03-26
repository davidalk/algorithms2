package uk.co.alkanani.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Job;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class JobSchedulerTest {

    @Test
    public void jobSchedulerGetsCorrectWeightedSumForDifferenceComparator() {
        // given
        DifferenceJobComparator comparator = new DifferenceJobComparator();
        JobScheduler scheduler = new JobScheduler(comparator);
        Job[] jobs = FileUtil.loadJobs("test-jobs.txt");

        // when
        long sum = scheduler.getSumWeightedCompletionTimes(jobs);

        // then
        assertEquals(21194L, sum);
    }

    @Test
    public void jobSchedulerGetsCorrectWeightedSumForRatioComparator() {
        // given
        RatioJobComparator comparator = new RatioJobComparator();
        JobScheduler scheduler = new JobScheduler(comparator);
        Job[] jobs = FileUtil.loadJobs("test-jobs.txt");

        // when
        long sum = scheduler.getSumWeightedCompletionTimes(jobs);

        // then
        assertEquals(21179L, sum);
    }

}