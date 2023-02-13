package com.geekstakulus.dfa;

import java.util.BitSet;

//-----------------------------------------------------------------------------
//  Melted
//-----------------------------------------------------------------------------

class Melted {          // info about melted states
  public BitSet set;          // set of old states
  public State state;         // new state
  public Melted next;

  public Melted(BitSet set, State state) {
    this.set = set; this.state = state;
  }

}
