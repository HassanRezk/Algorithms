/**
 * 
 *  kruskal's algorithm: O(nlogn)
 *  	sort the edges according to cost.
 *  	start adding edges from smallest to largest.
 *  	only add edges which connect disconnected components.
 *  
 *  Connectivity Check:
 *  	Using Disjoint-sets Data structure.
 *  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class mst {
	
	static Scanner in;
	
	static ArrayList<Edge> edgeList;
	
	static DisjointSets dsu;
	
	static int n, m;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("graph.txt"));
		edgeList = new ArrayList<Edge>();
		n = in.nextInt();
		m = in.nextInt();
		
		while(m-- > 0)
			edgeList.add(new Edge(in.next().charAt(0)-'a'
						, in.next().charAt(0)-'a', in.nextInt()));
		
		Collections.sort(edgeList);
		
		dsu = new DisjointSets(n);
		
		System.out.println("Minimum Spanning Tree:");
		for(int i = 0 ; i < edgeList.size() ; ++i)
			if(dsu.union(edgeList.get(i).from, edgeList.get(i).to))
				System.out.println(edgeList.get(i));
	}

}

class Edge implements Comparable<Edge> {
	
	public int from, to, w;
	
	public Edge(int from, int to, int w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}

	public int compareTo(Edge a) {
		if(w - a.w != 0) return w - a.w;
		if(a.from - from != 0) return a.from - from;
		return a.to - to;
	}
	
	public String toString() {
		return (char)(from + 'a') + " " + (char)(to + 'a') + " " + w;
	}
}

class DisjointSets {
	
	private int[] parent;
	
	public DisjointSets(int N) {
		parent = new int [N];
		for(int i = 0 ; i < N ; ++i)
			parent[i] = i;
	}
	
	public int find(int i) { // O(logn) Amortized
		if(parent[i] == i)
			return i;
		return parent[i] = find(parent[i]); // Path Compression
	}
	
	public boolean union(int i, int j) {
		int r_i = find(i), r_j = find(j);
		if(r_i == r_j)
			return false;
		parent[r_i] = r_j;
		return true;
	}
	
}
