package com.geekstakulus.table;

//=====================================================================
// Graph
//=====================================================================

public class Graph {
	public Node l;	// left end of graph = head
	public Node r;	// right end of graph = list of nodes to be linked to successor graph

	public Graph() {}

	public Graph(Node left, Node right) {
		l = left; r = right;
	}

	public Graph(Node p) {
		l = p; r = p;
	}

}
