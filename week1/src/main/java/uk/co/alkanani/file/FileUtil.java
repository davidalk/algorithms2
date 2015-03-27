package uk.co.alkanani.file;

import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.domain.Job;

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
                int weight = scanner.nextInt();
                int length = scanner.nextInt();
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

    public static Graph loadEdges(String filename) {
        File file = new File(FileUtil.class.getClassLoader().getResource(filename).getFile());
        Graph graph = new Graph();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int nodes = scanner.nextInt();
            int edgeCount = scanner.nextInt();
            Edge[] edges = new Edge[edgeCount];

            for (int i=0; i<edgeCount; i++) {
                Edge edge = new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextLong());
                edges[i] = edge;
            }

            graph.setNodes(nodes);
            graph.setEdges(edges);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return graph;
    }

}
