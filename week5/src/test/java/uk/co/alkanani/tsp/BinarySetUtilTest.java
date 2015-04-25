package uk.co.alkanani.tsp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.BitSet;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BinarySetUtilTest {

    @Test
    public void intToBitSetShouldReturnCorrectBitSet() {
        // given
        int i = 9;
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(3);

        // when
        BitSet result = BinarySetUtil.intToBitset(i);

        // then
        assertEquals(bitSet, result);
    }

    @Test
    public void bitSetToIntShouldReturnCorrectInt() {
        // given
        int i = 212;
        BitSet bitSet = new BitSet();
        bitSet.set(7);
        bitSet.set(6);
        bitSet.set(4);
        bitSet.set(2);

        // when
        int result = BinarySetUtil.bitSetToInt(bitSet);

        // then
        assertEquals(i, result);
    }
}