package uk.co.alkanani.file;

import uk.co.alkanani.domain.Coordinate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

    public static Coordinate[] loadCoordinates(String filename) {
        File file = CommonFileUtil.getFile(filename);
        int coordinateCount;
        Coordinate[] coordinates;

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            coordinateCount = scanner.nextInt();
            coordinates = new Coordinate[coordinateCount];

            for (int i=0; i<coordinateCount; i++) {
                float x = scanner.nextFloat();
                float y = scanner.nextFloat();
                coordinates[i] = new Coordinate(x, y);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return coordinates;
    }
}
