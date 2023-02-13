package com.geekstakulus.errors;

public class Errors {
	public int count = 0;                                    // number of errors detected
	public java.io.PrintStream errorStream = System.out;     // error messages go to this stream
	public String errMsgFormat = "-- line {0} col {1}: {2}"; // 0=line, 1=column, 2=text
	
	protected void printMsg(int line, int column, String msg) {
		StringBuffer b = new StringBuffer(errMsgFormat);
		int pos = b.indexOf("{0}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, line); }
		pos = b.indexOf("{1}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, column); }
		pos = b.indexOf("{2}");
		if (pos >= 0) b.replace(pos, pos+3, msg);
		errorStream.println(b.toString());
	}
	
	public void SynErr (int line, int col, int n) {
		String s;
		switch (n) {
			case 0: s = "EOF expected"; break;
			case 1: s = "ident expected"; break;
			case 2: s = "number expected"; break;
			case 3: s = "string expected"; break;
			case 4: s = "badString expected"; break;
			case 5: s = "char expected"; break;
			case 6: s = "\"COMPILER\" expected"; break;
			case 7: s = "\"IGNORECASE\" expected"; break;
			case 8: s = "\"CHARACTERS\" expected"; break;
			case 9: s = "\"TOKENS\" expected"; break;
			case 10: s = "\"PRAGMAS\" expected"; break;
			case 11: s = "\"COMMENTS\" expected"; break;
			case 12: s = "\"FROM\" expected"; break;
			case 13: s = "\"TO\" expected"; break;
			case 14: s = "\"NESTED\" expected"; break;
			case 15: s = "\"IGNORE\" expected"; break;
			case 16: s = "\"PRODUCTIONS\" expected"; break;
			case 17: s = "\"=\" expected"; break;
			case 18: s = "\".\" expected"; break;
			case 19: s = "\"END\" expected"; break;
			case 20: s = "\"+\" expected"; break;
			case 21: s = "\"-\" expected"; break;
			case 22: s = "\"..\" expected"; break;
			case 23: s = "\"ANY\" expected"; break;
			case 24: s = "\"<\" expected"; break;
			case 25: s = "\"^\" expected"; break;
			case 26: s = "\"out\" expected"; break;
			case 27: s = "\">\" expected"; break;
			case 28: s = "\",\" expected"; break;
			case 29: s = "\"<.\" expected"; break;
			case 30: s = "\".>\" expected"; break;
			case 31: s = "\"[\" expected"; break;
			case 32: s = "\"]\" expected"; break;
			case 33: s = "\"|\" expected"; break;
			case 34: s = "\"WEAK\" expected"; break;
			case 35: s = "\"(\" expected"; break;
			case 36: s = "\")\" expected"; break;
			case 37: s = "\"{\" expected"; break;
			case 38: s = "\"}\" expected"; break;
			case 39: s = "\"SYNC\" expected"; break;
			case 40: s = "\"IF\" expected"; break;
			case 41: s = "\"CONTEXT\" expected"; break;
			case 42: s = "\"(.\" expected"; break;
			case 43: s = "\".)\" expected"; break;
			case 44: s = "??? expected"; break;
			case 45: s = "this symbol not expected in Coco"; break;
			case 46: s = "this symbol not expected in TokenDecl"; break;
			case 47: s = "invalid TokenDecl"; break;
			case 48: s = "invalid AttrDecl"; break;
			case 49: s = "invalid AttrDecl"; break;
			case 50: s = "invalid AttrDecl"; break;
			case 51: s = "invalid AttrDecl"; break;
			case 52: s = "invalid AttrDecl"; break;
			case 53: s = "invalid SimSet"; break;
			case 54: s = "invalid Sym"; break;
			case 55: s = "invalid Term"; break;
			case 56: s = "invalid Factor"; break;
			case 57: s = "invalid Attribs"; break;
			case 58: s = "invalid Attribs"; break;
			case 59: s = "invalid Attribs"; break;
			case 60: s = "invalid Attribs"; break;
			case 61: s = "invalid Attribs"; break;
			case 62: s = "invalid TokenFactor"; break;
			case 63: s = "invalid Bracketed"; break;
			default: s = "error " + n; break;
		}
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (int line, int col, String s) {	
		printMsg(line, col, s);
		count++;
	}
	
	public void SemErr (String s) {
		errorStream.println(s);
		count++;
	}
	
	public void Warning (int line, int col, String s) {	
		printMsg(line, col, s);
	}
	
	public void Warning (String s) {
		errorStream.println(s);
	}
} // Errors
