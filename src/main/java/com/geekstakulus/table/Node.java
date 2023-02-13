package com.geekstakulus.table;

import java.util.BitSet;
import com.geekstakulus.dfa.State;
import com.geekstakulus.source.Position;

//=====================================================================
// Node
//=====================================================================

public class Node {
	// constants for node kinds
	public static final int t    =  1;  // terminal symbol
	public static final int pr   =  2;  // pragma
	public static final int nt   =  3;  // nonterminal symbol
	public static final int clas =  4;  // character class
	public static final int chr  =  5;  // character
	public static final int wt   =  6;  // weak terminal symbol
	public static final int any  =  7;  //
	public static final int eps  =  8;  // empty
	public static final int sync =  9;  // synchronization symbol
	public static final int sem  = 10;  // semantic action: (. .)
	public static final int alt  = 11;  // alternative: |
	public static final int iter = 12;  // iteration: { }
	public static final int opt  = 13;  // option: [ ]
	public static final int rslv = 14;  // resolver expr  /* ML */ /* AW 03-01-13 renamed slv --> rslv */

	public static final int normalTrans  = 0;		// transition codes
	public static final int contextTrans = 1;

	public int      n;				// node number
	public int      typ;			// t, nt, wt, chr, clas, any, eps, sem, sync, alt, iter, opt, rslv
	public Node     next;			// to successor node
	public Node     down;			// alt: to next alternative
	public Node     sub;			// alt, iter, opt: to first node of substructure
	public boolean  up;				// true: "next" leads to successor in enclosing structure
	public Symbol   sym;			// nt, t, wt: symbol represented by this node
	public int      val;			// chr:  ordinal character value
														// clas: index of character class
	public int      code;			// chr, clas: transition code
	public BitSet set;				// any, sync: the set represented by this node
	public Position pos;			// nt, t, wt: pos of actual attributes
														// sem:       pos of semantic action in source text
	public int      line;			// source text line number of item in this node
	public State    state;		// DFA state corresponding to this node
														// (only used in DFA.ConvertToStates)
	public String retVar;			// AH 20040206 - nt: name of output attribute (or null)

	public Node(int typ, Symbol sym, int line) {
		this.typ = typ; this.sym = sym; this.line = line;
	}

}
