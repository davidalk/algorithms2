package uk.co.alkanani.tsp;

import uk.co.alkanani.domain.Coordinate;
import uk.co.alkanani.file.FileUtil;

public class ResultGenerator {

    public static void main(String... args) {
        Coordinate[] coordinates = FileUtil.loadCoordinates("tsp.txt");
        TspAlgorithm algorithm = new TspAlgorithm(coordinates);

        float result = algorithm.execute();

        System.out.println("Tour: " + result);
    }
}
