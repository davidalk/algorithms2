package uk.co.alkanani.schedule;

import uk.co.alkanani.domain.Job;

import java.util.Comparator;

public class DifferenceJobCamparator implements Comparator<Job> {
    public int compare(Job j1, Job j2) {
        int j1Score = j1.getWeight() - j1.getLength();
        int j2Score = j2.getWeight() - j2.getLength();

        if (j1Score == j2Score) {
            return j2.getWeight() -  j1.getWeight();
        } else {
            return j2Score - j1Score;
        }
    }
}
