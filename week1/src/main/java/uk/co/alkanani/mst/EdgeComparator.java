package uk.co.alkanani.mst;

import uk.co.alkanani.domain.Edge;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge o1, Edge o2) {

        long costDiff =  o1.getCost() - o2.getCost();

        if (costDiff == 0L) {
            return 0;
        } else if (costDiff < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
