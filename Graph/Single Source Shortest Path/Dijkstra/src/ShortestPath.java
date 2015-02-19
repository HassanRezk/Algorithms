/**
 * Given a weighted Graph find the shortest path 
 * from a given source to a given destination
 * or from a given source to all destinations.
 * 
 * all weights are positive.
 * 
 * Dijkstra's algorithm: 
 * 				    O(|V| + |E|log|V|) using priority queue and adjacency list.
 * 	 	A greedy algorithm:
 * 		(1)	pick the node that is closest to the source with minimum weight.
 * 			use it to reach new nodes.
 * 			repeat (1). until all nodes are visited.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath {
	
	static Scanner in;
	
	public static final int INFINITY = (int) (1e9);

	static int n, m;
	
	static int[] dist;
	static boolean[] visited;
	
	static PriorityQueue<Node> pq;
	
	static ArrayList<Node>[] AdjList;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("graph.txt"));
		n = in.nextInt();
		m = in.nextInt();
		AdjList = new ArrayList[n];
		for(int i = 0 ; i < AdjList.length ; ++i)
			AdjList[i] = new ArrayList<Node>();
		while(m -- > 0) {
			String temp = in.next();
			int from = temp.charAt(0) - 'a';
			temp = in.next();
			int to = temp.charAt(0) - 'a';
			int weight = in.nextInt();
			AdjList[from].add(new Node(to, weight));
		}
		
		System.out.println("The shortest path from a to h : \n");
		System.out.println(dijkstra(0, 'h' - 'a'));
	}
	
	static int dijkstra(int src, int dest) {
		dist = new int[n];
		visited = new boolean[n];
		pq = new PriorityQueue<Node>();
		Arrays.fill(dist, INFINITY);
		dist[0] = 0;
		pq.add(new Node(src, 0));
		while(!pq.isEmpty()) {
			Node curnode = pq.poll();
			if(!visited[curnode.node]) {
				visited[curnode.node] = true;
				for(Node e : AdjList[curnode.node]) 
					// for each e adjacent to the current node.
					if( dist[curnode.node] + e.weight < dist[e.node] ) {
						dist[e.node] = dist[curnode.node] + e.weight;
						pq.add(new Node(e.node, dist[e.node]));
					}
			}
		}
		return dist[dest];
	}

}

class Node implements Comparable<Node> {
	public int node, weight;
	
	Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	public int compareTo(Node a) {
		return weight - a.weight;
	}
	
}

