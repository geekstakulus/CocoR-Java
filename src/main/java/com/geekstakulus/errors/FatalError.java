package com.geekstakulus.errors;

import java.lang.RuntimeException;

public class FatalError extends RuntimeException {
	public static final long serialVersionUID = 1L;
	public FatalError(String s) { 
    super(s); 
  }
}
