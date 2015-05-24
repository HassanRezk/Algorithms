/**
 * 
 * Application #3:
 * 		Shortest path on unweighted graph using BFS.
 * 
 * The BFS divide the graph into levels from any source.
 * 
 * the source vertex is level 0, level 1 vertices are the vertices
 * reachable from the source vertex by 1 edge, level 2 vertices 
 * are the vertices reachable from the source vertex by 1 edge .. 
 * and so on..
 * 
 * the level assigned to each vertex is the shortest path from the starting
 * vertex.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInUnweightedGraph {
	
	static int n, m;
	
	static ArrayList<Integer>[] graph;
	
	static Scanner in;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("graph.txt"));
		n = in.nextInt() + 1;
		m = in.nextInt();
		graph = new ArrayList[n];
		for(int i = 1 ; i < n ; ++i)
			graph[i] = new ArrayList<Integer>();
		int from, to;
		while(m-- > 0) {
			from = in.nextInt();
			to = in.nextInt();
			graph[from].add(to);
			graph[to].add(from);
		}
		int[] sp = shortestPath(1);
		System.out.println("Shortest Path from node 1\n");
		for(int i = 2 ; i < n ; ++i)
			System.out.println("To node " + i + " = " + sp[i]);
	}
	
	static int[] shortestPath(int src) {
		int[] dist = new int[n];
		boolean[] vis = new boolean[n];
		dist[src] = 0;
		vis[src] = true;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(src, 0));
		while(!q.isEmpty()) {
			Pair node = q.poll();
			for(int j = 0 ; j < graph[node.node].size() ; ++j) {
				int adj_node = graph[node.node].get(j);
				if(!vis[adj_node]) {
					vis[adj_node] = true;
					dist[adj_node] = node.dist + 1;
					q.add(new Pair(adj_node, dist[adj_node]));
				}
			}
		}
		return dist;
	}

}

class Pair {
	
	public int node, dist;
	
	public Pair(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}
