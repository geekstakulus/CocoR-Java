package com.geekstakulus.table;

import com.geekstakulus.dfa.CharSet;

//=====================================================================
// CharClass
//=====================================================================

public class CharClass {
	public int n;       // class number
	public String name;	// class name
	public CharSet set;	// set representing the class

	public CharClass(String name, CharSet s) {
		this.name = name; this.set = s;
	}
}
