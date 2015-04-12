package uk.co.alkanani.file;

import uk.co.alkanani.domain.Item;
import uk.co.alkanani.domain.Knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class FileUtil {

    public static Knapsack loadKnapsack(String filename) {
        File file = getFile(filename);
        int knapsackSize;
        int itemCount;
        Item[] items;

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            knapsackSize = scanner.nextInt();
            itemCount = scanner.nextInt();
            items = new Item[itemCount];

            int i = 0;
            while (scanner.hasNext()) {
                long value = scanner.nextLong();
                int weight = scanner.nextInt();
                Item item = new Item(value, weight);
                items[i] = item;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return new Knapsack(knapsackSize, itemCount, items);
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
