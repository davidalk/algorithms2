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

    @Test
    public void nextSetWorksForTwoBits() {
        // given
        int i = 3;

        // when
        int result = BinarySetUtil.nextSetSameBitCountIncludingOne(i);

        // then
        assertEquals(5, result);
    }

    @Test
    public void nextSetWorksForLargeBitSize() {
        // given
        int i = 39327;

        // when
        int result = BinarySetUtil.nextSetSameBitCountIncludingOne(i);

        // then
        assertEquals(39343, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nextSetShouldThrowExceptionWhenNoOneInInput() {
        // given
        int i = 0b00011010;

        // when & then
        int result = BinarySetUtil.nextSetSameBitCountIncludingOne(i);
    }

    @Test
    public void createStartingBitSetGeneratesExpectedInt() {
        // given
        int size = 8;

        // when
        int result = BinarySetUtil.createStartingBitSet(size);

        // then
        assertEquals(255, result);
    }

    @Test
    public void createFinishingBitSetGeneratesExpectedInt() {
        // given
        int size = 8;
        int nodeCount = 25;

        // when
        int result = BinarySetUtil.createFinishingBitSet(size, nodeCount);

        // then
        assertEquals(33292289, result);
    }

    @Test
    public void createFinishingBitSetGeneratesAsExpectedForSizeSameAsNodeCount() {
        // given
        int size = 8;
        int nodeCount = 8;

        // when
        int result = BinarySetUtil.createFinishingBitSet(size, nodeCount);

        // then
        int expected = 0b11111111;
        assertEquals(expected, result);
    }

    @Test
    public void allBitsExceptOneGeneratesExpectedResult() {
        // given
        int inputBitSet = 0b00110011;

        // when
        Set<Integer> result = BinarySetUtil.allBitsExceptOne(inputBitSet);

        // then
        Set<Integer> expected = new HashSet<>(Arrays.asList(2, 5, 6));
        assertEquals(expected, result);
    }

    @Test
    public void allBitsGeneratesExpectedResult() {
        // given
        int inputBitSet = 0b000110011;

        // when
        Set<Integer> result = BinarySetUtil.allBits(inputBitSet);

        // then
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 5, 6));
        assertEquals(expected, result);
    }
}