/**
 * Prim's Algorithm to find minimum spanning tree:
 * 
 * ==> A greedy algorithm:
 * 	start from any vertex pick the minimum weight edge from that vertex to
 * 	discover some new vertices, and each vertex is visited only once.
 * 
 * Time Complexity: O(|E|log(|V|))
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Prim {
	
	static Scanner in;
	
	static ArrayList<Node>[] graph;
	
	static boolean[] vis;
	
	static int n, m;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("graph.txt"));
		n = in.nextInt();
		m = in.nextInt();
		vis = new boolean[n];
		graph = new ArrayList[n];
		for(int i = 0 ; i < n ; ++i)
			graph[i] = new ArrayList<Node>();
		int from, to, weight;
		while(m-- > 0) {
			from = in.next().charAt(0) - 'a';
			to = in.next().charAt(0) - 'a';
			weight = in.nextInt();
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		System.out.println("MST cost = " + mst());
	
	}
	
	static int mst() { // taking the starting vertex = 'a'
		int cost = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(!vis[node.vertex]) {
				cost += node.weight;
				vis[node.vertex] = true;
				for(int i = 0 ; i < graph[node.vertex].size() ; ++i) {
					Node adjNode = graph[node.vertex].get(i);
					if(!vis[adjNode.vertex])
						pq.add(new Node(adjNode.vertex, adjNode.weight));
				}
			}
		}
		return cost;
	}

}

class Node implements Comparable<Node> {
	
	public int vertex, weight;
	
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
	
}
