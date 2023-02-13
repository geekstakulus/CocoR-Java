package com.geekstakulus.table;

import java.util.BitSet;
import com.geekstakulus.source.Position;

//=====================================================================
// Symbol
//=====================================================================

public class Symbol {

	// token kinds
	public static final int fixedToken    = 0; // e.g. 'a' ('b' | 'c') (structure of literals)
	public static final int classToken    = 1; // e.g. digit {digit}   (at least one char class)
	public static final int litToken      = 2; // e.g. "while"
	public static final int classLitToken = 3; // e.g. letter {letter} but without literals that have the same structure

	public int      n;           // symbol number
	public int      typ;         // t, nt, pr, unknown, rslv /* ML 29_11_2002 slv added */ /* AW slv --> rslv */
	public String   name;        // symbol name
	public Node     graph;       // nt: to first node of syntax graph
	public int      tokenKind;   // t:  token kind (fixedToken, classToken, ...)
	public boolean  deletable;   // nt: true if nonterminal is deletable
	public boolean  firstReady;  // nt: true if terminal start symbols have already been computed
	public BitSet   first;       // nt: terminal start symbols
	public BitSet   follow;      // nt: terminal followers
	public BitSet   nts;         // nt: nonterminals whose followers have to be added to this sym
	public int      line;        // source text line number of item in this node
	public Position attrPos;     // nt: position of attributes in source text (or null)
	public Position semPos;      // pr: pos of semantic action in source text (or null)
	                             // nt: pos of local declarations in source text (or null)
	public String   retType;     // AH - nt: Type of output attribute (or null)
	public String   retVar;      // AH - nt: Name of output attribute (or null)

	public Symbol(int typ, String name, int line) {
		this.typ = typ; this.name = name; this.line = line;
	}
}
