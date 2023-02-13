package com.geekstakulus.table;

import java.util.BitSet;

//=====================================================================
// Sets
//=====================================================================
public class Sets {
	public static int Elements(BitSet s) {
		return s.cardinality();
	}

	public static boolean Equals(BitSet a, BitSet b) {
		return a.equals(b);
	}

	public static boolean Intersect(BitSet a, BitSet b) { // a * b != {}
		return a.intersects(b);
	}

	public static void Subtract(BitSet a, BitSet b) { // a = a - b
		BitSet c = (BitSet)b.clone();
		//a.and(c.not());
		c.flip(0, c.size());	// c.not
		a.and(c);
	}
}
