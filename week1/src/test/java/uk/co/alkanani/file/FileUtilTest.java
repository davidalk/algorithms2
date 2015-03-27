package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
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
        Edge edge1 = new Edge(1, 2, 4);
        Edge edge2 = new Edge(2, 3, 1);
        Edge edge3 = new Edge(3, 4, 2);
        Edge edge4 = new Edge(4, 1, 5);
        Edge edge5 = new Edge(2, 4, 3);
        Edge[] edges = {edge1, edge2, edge3, edge4, edge5};
        Graph graph = new Graph(4, edges);

        // when
        Graph result = FileUtil.loadEdges("test-edges.txt");

        // then
        assertEquals(graph, result);
    }

}