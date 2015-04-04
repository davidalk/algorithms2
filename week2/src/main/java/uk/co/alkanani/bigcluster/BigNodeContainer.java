package uk.co.alkanani.bigcluster;

import uk.co.alkanani.domain.Node;

import java.util.Map;
import java.util.Set;

public class BigNodeContainer {
    public final int nodeCount;
    public final int bitSize;
    public final Map<Integer, Set<Node>> nodeMap;

    public BigNodeContainer(int nodeCount, int bitSize, Map<Integer, Set<Node>> nodeMap) {
        this.nodeCount = nodeCount;
        this.bitSize = bitSize;
        this.nodeMap = nodeMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigNodeContainer that = (BigNodeContainer) o;

        if (nodeCount != that.nodeCount) return false;
        if (bitSize != that.bitSize) return false;
        return nodeMap.equals(that.nodeMap);

    }

    @Override
    public int hashCode() {
        int result = nodeCount;
        result = 31 * result + bitSize;
        result = 31 * result + nodeMap.hashCode();
        return result;
    }
}
