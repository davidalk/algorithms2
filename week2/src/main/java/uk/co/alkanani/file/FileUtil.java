package uk.co.alkanani.file;

import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

    public static Graph loadEdges(String filename) {
        File file = new File(FileUtil.class.getClassLoader().getResource(filename).getFile());
        List<Edge> edges = new ArrayList<>();
        int nodeCount = 0;

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            nodeCount = scanner.nextInt();

            while (scanner.hasNext()){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                long weight = scanner.nextLong();
                Edge edge = new Edge(a, b, weight);
                edges.add(edge);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return new Graph(nodeCount, edges);
    }
}
