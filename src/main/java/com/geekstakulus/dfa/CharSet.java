package com.geekstakulus.dfa;

//-----------------------------------------------------------------------------
//  CharSet
//-----------------------------------------------------------------------------

public class CharSet {

  public static class Range {
    public int from, to;
    public Range next;
    public Range(int from, int to) { this.from = from; this.to = to; }
  }

  public Range head;

  public boolean Get(int i) {
    for (Range p = head; p != null; p = p.next)
      if (i < p.from) return false;
      else if (i <= p.to) return true; // p.from <= i <= p.to
    return false;
  }

  public void Set(int i) {
    Range cur = head, prev = null;
    while (cur != null && i >= cur.from-1) {
      if (i <= cur.to + 1) { // (cur.from-1) <= i <= (cur.to+1)
        if (i == cur.from - 1) cur.from--;
        else if (i == cur.to + 1) {
          cur.to++;
          Range next = cur.next;
          if (next != null && cur.to == next.from - 1) { cur.to = next.to; cur.next = next.next; };
        }
        return;
      }
      prev = cur; cur = cur.next;
    }
    Range n = new Range(i, i);
    n.next = cur;
    if (prev == null) head = n; else prev.next = n;
  }

  public CharSet Clone() {
    CharSet s = new CharSet();
    Range prev = null;
    for (Range cur = head; cur != null; cur = cur.next) {
      Range r = new Range(cur.from, cur.to);
      if (prev == null) s.head = r; else prev.next = r;
      prev = r;
    }
    return s;
  }

  public boolean Equals(CharSet s) {
    Range p = head, q = s.head;
    while (p != null && q != null) {
      if (p.from != q.from || p.to != q.to) return false;
      p = p.next; q = q.next;
    }
    return p == q;
  }

  public int Elements() {
    int n = 0;
    for (Range p = head; p != null; p = p.next) n += p.to - p.from + 1;
    return n;
  }

  public int First() {
    if (head != null) return head.from;
    return -1;
  }

  public void Or(CharSet s) {
    for (Range p = s.head; p != null; p = p.next)
      for (int i = p.from; i <= p.to; i++) Set(i);
  }

  public void And(CharSet s) {
    CharSet x = new CharSet();
    for (Range p = head; p != null; p = p.next)
      for (int i = p.from; i <= p.to; i++)
        if (s.Get(i)) x.Set(i);
    head = x.head;
  }

  public void Subtract(CharSet s) {
    CharSet x = new CharSet();
    for (Range p = head; p != null; p = p.next)
      for (int i = p.from; i <= p.to; i++)
        if (!s.Get(i)) x.Set(i);
    head = x.head;
  }

  public boolean Includes(CharSet s) {
    for (Range p = s.head; p != null; p = p.next)
      for (int i = p.from; i <= p.to; i++)
        if (!Get(i)) return false;
    return true;
  }

  public boolean Intersects(CharSet s) {
    for (Range p = s.head; p != null; p = p.next)
      for (int i = p.from; i <= p.to; i++)
        if (Get(i)) return true;
    return false;
  }

  public void Fill() {
    head = new Range(Character.MIN_VALUE, Character.MAX_VALUE);
  }
}
