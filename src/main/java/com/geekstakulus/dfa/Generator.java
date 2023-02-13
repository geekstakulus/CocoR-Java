package com.geekstakulus.dfa;

import com.geekstakulus.table.Tab;
import com.geekstakulus.errors.FatalError;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

//-----------------------------------------------------------------------------
//  Generator
//-----------------------------------------------------------------------------
public class Generator {
  private static final int EOF = -1;

  private Reader fram;
  private PrintWriter gen;
  private final Tab tab;
  private File frameFile;

  public Generator(Tab tab) {
    this.tab = tab;
  }

  public Reader OpenFrame(String frame) {
    if (tab.frameDir != null) frameFile = new File(tab.frameDir, frame);
    if (frameFile == null || !frameFile.exists()) frameFile = new File(tab.srcDir, frame);
    if (frameFile == null || !frameFile.exists()) throw new FatalError("Cannot find : " + frame);

    try {
      fram = new BufferedReader(new FileReader(frameFile)); /* pdt */
    } catch (FileNotFoundException e) {
      throw new FatalError("Cannot open frame file: " + frameFile.getPath());
    }
    return fram;
  }

  public PrintWriter OpenGen(String target) {
    File f = new File(tab.outDir, target);
    try {
      if (f.exists()) {
        File old = new File(f.getPath() + ".old");
        old.delete(); f.renameTo(old);
      }
      gen = new PrintWriter(new BufferedWriter(new FileWriter(f, false))); /* pdt */
    } catch (Exception e) {
      throw new FatalError("Cannot generate file: " + f.getPath());
    }
    return gen;
  }

  public void GenCopyright() {
    File copyFr = null;
    if (tab.frameDir != null) copyFr = new File(tab.frameDir, "Copyright.frame");
    if (copyFr == null || !copyFr.exists()) copyFr = new File(tab.srcDir, "Copyright.frame");
    if (copyFr == null || !copyFr.exists()) return;

    try {
      Reader scannerFram = fram;
      fram = new BufferedReader(new FileReader(copyFr));
      CopyFramePart(null);
      fram = scannerFram;
    } catch (FileNotFoundException e) {
      throw new FatalError("Cannot open Copyright.frame");
    }
  }

  public void SkipFramePart(String stop) {
    CopyFramePart(stop, false);
  }

  public void CopyFramePart(String stop) {
    CopyFramePart(stop, true);
  }

  // if stop == null, copies until end of file
  private void CopyFramePart(String stop, boolean generateOutput) {
    char startCh = 0;
    int endOfStopString = 0;

    if (stop != null) {
      startCh = stop.charAt(0);
      endOfStopString = stop.length() - 1;
    }

    int ch = framRead();
    while (ch != EOF) {
      if (stop != null && ch == startCh) {
        int i = 0;
        do {
          if (i == endOfStopString) return; // stop[0..i] found
          ch = framRead(); i++;
        } while (ch == stop.charAt(i));
        // stop[0..i-1] found; continue with last read character
        if (generateOutput) gen.print(stop.substring(0, i));
      } else {
        if (generateOutput) gen.print((char)ch); ch = framRead();
      }
    }

    if (stop != null) throw new FatalError("Incomplete or corrupt frame file: " + frameFile.getPath());
  }

  private int framRead() {
    try {
      return fram.read();
    } catch (java.io.IOException e) {
      throw new FatalError("Error reading frame file: " + frameFile.getPath());
    }
  }
}
