package uk.co.alkanani.tsp;

import java.util.BitSet;

public class BinarySetUtil {

    public static BitSet intToBitset(int i) {
        return BitSet.valueOf(new long[] {i});
    }

    public static int bitSetToInt(BitSet b) {
        return (int) b.toLongArray()[0];
    }

}
