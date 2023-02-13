package com.geekstakulus.source;

public class Position { // position of source code stretch (e.g. semantic action, resolver expressions)
	public final int beg;      // start relative to the beginning of the file
	public final int end;      // end of stretch
	public final int col;      // column number of start position

	public Position(int beg, int end, int col) {
		this.beg = beg; this.end = end; this.col = col;
	}
}
