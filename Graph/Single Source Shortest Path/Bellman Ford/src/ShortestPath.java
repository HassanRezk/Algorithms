/**
 *
 * Given a weighted Graph find the shortest path 
 * from a given source to a given destination
 * or from a given source to all destinations.
 * 
 * all weights are positive.
 * 
 * Bellman Ford's Algorithm: O(|V|*|E|)
 *   based on the optimal substructure property of the shortest path.
 *   shortest path contains at most n-1 edges.
 *   
 * Start by creating shortest paths that uses 0 edge.
 * add an edge to create the shortest paths that uses 1 edge until adding
 * n-1 edges.
 *   
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestPath {
	
	public static final int INFINITY = (int) (1e9);
	
	static Scanner in;
	
	static ArrayList<Edge> edgeList;
	
	static int n, m;
	static int[] dist;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("graph.txt"));
		n = in.nextInt();
		m = in.nextInt();
		edgeList = new ArrayList<Edge>();
		while(m-- > 0) {
			String temp = in.next();
			int from = temp.charAt(0) - 'a';
			temp = in.next();
			int to = temp.charAt(0) - 'a';
			int weight = in.nextInt();
			edgeList.add(new Edge(from, to, weight));
		}
		
		System.out.println("The shortest path from a to h : \n");
		System.out.println(bellmanford(0, 'h' - 'a'));
	}
	
	static int bellmanford(int src, int dest) { // O(|V|*|E|)
		dist = new int[n];
		Arrays.fill(dist, INFINITY);
		dist[src] = 0;
		for(int i = 0 ; i < n-1 ; ++i) // O(|V|)
			for(Edge e: edgeList)      // O(|E|)
				if( dist[e.from] + e.weight < dist[e.to] ) 
					dist[e.to] = dist[e.from] + e.weight; // relaxation
		
		return dist[dest];
	} 

}

class Edge {
	
	public int from, to, weight;

	Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
}
