package uk.co.alkanani.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import uk.co.alkanani.domain.Item;
import uk.co.alkanani.domain.Knapsack;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileUtilTest {

    @Test
    public void knapsackFileLoadsCorrectly() {
        // given
        Item item1 = new Item(3, 4);
        Item item2 = new Item(2, 3);
        Item item3 = new Item(4, 2);
        Item item4 = new Item(4, 3);
        Item[] items = {item1, item2, item3, item4};
        Knapsack knapsack = new Knapsack(6, 4, items);

        // when
        Knapsack result = FileUtil.loadKnapsack("knapsack-test.txt");

        // then
        assertEquals(knapsack, result);
    }
}