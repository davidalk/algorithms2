package uk.co.alkanani.tsp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

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
        BitSet result = BinarySetUtil.intToBitSet(i);

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

    @Test(expected = IllegalArgumentException.class)
    public void getSubSetsThrowsExceptionWhenSubsetSizeTooLarge() {
        // given
        int bitSet = 0b0010110;
        int k = 4;

        // when & then
        BinarySetUtil.getSubSets(bitSet, k);
    }

    @Test
    public void getSubSetsGeneratesCorrectSets() {
        // given
        int bitSet = 0b11010;
        int k = 2;

        // when
        Set<Set<Integer>> result = BinarySetUtil.getSubSets(bitSet, k);

        // then
        Set<Set<Integer>> expected = new HashSet<>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 4));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(3, 4));
        expected.add(set1);
        expected.add(set2);
        expected.add(set3);
        assertEquals(expected, result);
    }

    @Test
    public void integerSetToBitSetReturnsCorrectObject() {
        // given
        Set<Integer> integers = new HashSet<>(Arrays.asList(3, 5, 8, 15, 91));

        // when
        BitSet result = BinarySetUtil.integerSetToBitSet(integers);

        // then
        BitSet expected = new BitSet();
        expected.set(3);
        expected.set(5);
        expected.set(8);
        expected.set(15);
        expected.set(91);
        assertEquals(expected, result);
    }

    @Test
    public void nextIntWorksForSingleBit() {
        // given
        int i = 1;

        // when
        int result = BinarySetUtil.nextIntSameBitCount(i);

        // then
        assertEquals(2, result);
    }

    @Test
    public void nextIntWorksForTwoBits() {
        // given
        int i = 3;

        // when
        int result = BinarySetUtil.nextIntSameBitCount(i);

        // then
        assertEquals(5, result);
    }
}