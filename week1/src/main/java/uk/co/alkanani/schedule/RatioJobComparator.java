package uk.co.alkanani.schedule;

import uk.co.alkanani.domain.Job;

import java.util.Comparator;

public class RatioJobComparator implements Comparator<Job>{
    public int compare(Job j1, Job j2) {
        float j1Score = (float) j1.getWeight() / j1.getLength();
        float j2Score = (float) j2.getWeight() / j2.getLength();
        if (j1Score == j2Score) {
            return 0;
        }
        if (j2Score > j1Score) {
            return 1;
        } else {
            return -1;
        }
    }
}
