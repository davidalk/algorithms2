package uk.co.alkanani.schedule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Job;
import uk.co.alkanani.file.FileUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class JobSchedulerTest {
    private JobScheduler scheduler;

    @Before
    public void setUp() {
        scheduler = new JobScheduler(new RatioJobComparator(), new DifferenceJobComparator());
    }

    @Test
    public void jobSchedulerGetsCorrectWeightedSumForDifferenceComparator() {
        // given
        Job[] jobs = FileUtil.loadJobs("test-jobs.txt");

        // when
        long sum = scheduler.getDifferenceComparedCompletionTimes(jobs);

        // then
        assertEquals(21194L, sum);
    }

    @Test
    public void jobSchedulerGetsCorrectWeightedSumForRatioComparator() {
        // given
        Job[] jobs = FileUtil.loadJobs("test-jobs.txt");

        // when
        long sum = scheduler.getRatioComparedCompletionTimes(jobs);

        // then
        assertEquals(21179L, sum);
    }

}