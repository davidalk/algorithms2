package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Job;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileUtilTest {

    @Test
    public void loadJobsLoadsTestFileCorrectly() {
        // given
        String fileName = "test-jobs.txt";
        Job job1 = new Job(8, 50);
        Job job2 = new Job(74, 59);
        Job job3 = new Job(31, 73);
        Job job4 = new Job(75, 60);

        // when
        Job[] jobs = FileUtil.loadJobs(fileName);

        // then
        assertEquals("Job 1:", job1, jobs[0]);
        assertEquals("Job 2:", job2, jobs[1]);
        assertEquals("Job 3:", job3, jobs[2]);
        assertEquals("Job 4:", job4, jobs[3]);
    }

    @Test
    public void loadEdgesLoadsTestFileCorrectly() {
        // given
        long[][] matrix = new long[5][5];
        matrix[1][2] = 4;
        matrix[2][3] = 1;
        matrix[3][4] = 2;
        matrix[4][1] = 5;
        matrix[2][4] = 3;

        // when
        long[][] result = FileUtil.loadEdges("test-edges.txt");

        // then
        assertArrayEquals(matrix, result);
    }

}