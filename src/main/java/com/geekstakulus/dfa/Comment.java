package com.geekstakulus.dfa;

//-----------------------------------------------------------------------------
//  Comment
//-----------------------------------------------------------------------------

public class Comment {         // info about comment syntax
  public String start;
  public String stop;
  public boolean nested;
  public Comment next;

  public Comment(String start, String stop, boolean nested) {
    this.start = start; this.stop = stop; this.nested = nested;
  }

}
