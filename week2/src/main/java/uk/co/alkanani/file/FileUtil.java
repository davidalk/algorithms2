package uk.co.alkanani.file;

import com.google.common.collect.ImmutableList;
import uk.co.alkanani.bigcluster.BigNodeContainer;
import uk.co.alkanani.domain.Edge;
import uk.co.alkanani.domain.Graph;
import uk.co.alkanani.domain.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class FileUtil {

    public static Graph loadGraph(String filename) {
        File file = getFile(filename);
        ImmutableList.Builder<Edge> edges = new ImmutableList.Builder<>();
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

        return new Graph(nodeCount, edges.build());
    }

    public static BigNodeContainer loadBigNodeContainer(String filename) {
        File file = getFile(filename);
        int nodeCount;
        int bitSize;
        Map<Integer, Set<Node>> nodeMap = new HashMap<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            nodeCount = scanner.nextInt();
            bitSize = scanner.nextInt();
            for (int i=0; i<nodeCount; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<bitSize; j++) {
                    sb.append(scanner.nextInt());
                }
                int key = Integer.parseInt(sb.toString(), 2);
                if (nodeMap.containsKey(key)) {
                    nodeMap.get(key).add(new Node(i+1));
                } else {
                    Set<Node> nodeSet = new HashSet<>();
                    nodeSet.add(new Node(i+1));
                    nodeMap.put(key, nodeSet);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return new BigNodeContainer(nodeCount, bitSize, nodeMap);
    }

    private static File getFile(String filename) {
        URL url = FileUtil.class.getClassLoader().getResource(filename);
        File file;
        if (url != null) {
            file = new File(url.getFile());
        } else {
            throw new IllegalArgumentException("Invalid file");
        }
        return file;
    }
}
