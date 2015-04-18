package uk.co.alkanani.file;

import uk.co.alkanani.domain.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

    public static Graph loadGraph(String filename) {
        File file = CommonFileUtil.getFile(filename);
        int nodeCount;
        int edgeCount;
        Long[][] edges;

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            nodeCount = scanner.nextInt();
            edgeCount = scanner.nextInt();
            edges = new Long[nodeCount+1][nodeCount+1];

            for (int i=0; i<edgeCount; i++) {
                int tail = scanner.nextInt();
                int head = scanner.nextInt();
                long length = scanner.nextLong();
                edges[tail][head] = length;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return new Graph(nodeCount, edgeCount, edges);
    }
}
