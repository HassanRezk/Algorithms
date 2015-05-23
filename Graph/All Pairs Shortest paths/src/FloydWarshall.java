/**
 * Given a weighted Graph, find the shortest path between any pair.
 * 
 * Floyd Warshall's Algorithm:
 * 
 * A Dynamic Programming algorithm which uses every node as an intermediate 
 * node.
 * 
 * Time Complexity: O(|V|^3)
 * Memory Complexity: O(|V|^2)
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FloydWarshall {
	
	static final int INFINITY = (int)(1e9);
	
	static Scanner in;
	
	static int[][] graph;
	static int[][] path;
	static int n, m;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("Graph.txt"));
		n = in.nextInt();
		m = in.nextInt();
		graph = new int[n+1][n+1];
		path = new int[n+1][n+1];
		for(int i = 0 ; i < n+1 ; ++i)
			for(int j = 0 ; j < n+1 ; ++j) {
				graph[i][j] = (i == j ? 0 : INFINITY);
				path[i][j] = i;
			}
		int from, to, w;
		while(m-- > 0) {
			from = in.nextInt();
			to = in.nextInt();
			w = in.nextInt();
			graph[from][to] = graph[to][from] = w;
		}
		for(int k = 1 ; k <= n ; ++k)
			for(int i = 1 ; i <= n ; ++i)
				for(int j = 1 ; j <= n ; ++j)
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
						path[i][j] = path[k][j];
					}
		System.out.println("All Pairs Shortest Paths:\n");
		for(int i = 1 ; i <= n ; ++i)
			for(int j = i+1 ; j <= n ; ++j) {
				System.out.println("Shortest Path from " + 
								i + " to " + j + " = " + graph[i][j]);
				System.out.print("Path : ");
				printPath(i, j);
				System.out.println("\n");
			}
				
	}

	static void printPath(int i, int j) {
		if(i != j) printPath(i, path[i][j]);
		System.out.print(j + " ");
	}
}
