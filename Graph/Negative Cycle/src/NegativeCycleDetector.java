/**
 *
 * Given a connected graph with negative weights.
 * 
 * The Problem is to find if this graph contains any negative weighted cycles.
 * 
 *  Solution:
 *  
 *  	using bellman ford algorithm:
 *  
 *  		start from a node find the shortest path using n-1 edge.
 *  	(1)	try to do relaxation one more time.
 *  		if (1) is true then the graph must have a shortest path having
 *  			   more than n-1 edge which is a contradiction of the optimal
 *  			   substructure property of the shortest path, thus this graph
 *  			   must contain a negative weighted cycle.
 *  		otherwise return false.
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycleDetector {
	
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
		while(m-- > 0)
			edgeList.add(new Edge(in.nextInt()-1, in.nextInt()-1, 
												in.nextInt()));
		
		if(hasNegativeCycle(0, n-1)) 
			System.out.println("Negative Cycle Detected");
		else System.out.println("No Negative Cycles Detected");
	}
	
	static boolean hasNegativeCycle(int src, int dest) { // O(|V|*|E|)
		dist = new int[n];
		Arrays.fill(dist, INFINITY);
		dist[src] = 0;
		for(int i = 0 ; i < n-1 ; ++i)
			for(Edge e : edgeList)
				if( dist[e.from] + e.weight < dist[e.to] ) 
					dist[e.to] = dist[e.from] + e.weight;
		
		for(Edge e : edgeList)
			if( dist[e.from] + e.weight < dist[e.to] ) // relaxation
				return true;
		return false;
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

