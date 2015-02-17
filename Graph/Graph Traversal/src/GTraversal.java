/*
 *	DFS: Depth First Search. using Stack (Internal Stack)
 *	BFS: Breadth First Search. using Queue.
 *
 *	both:
 *		O(|E| + |V|)
 *		using adjacency list as graph representation.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GTraversal {
	
	static Scanner in;
	
	static int n, m;
	
	static ArrayList<Integer>[] adjList;
	static boolean visited[];

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("graph.txt"));
		n = in.nextInt();
		m = in.nextInt();
		adjList = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 1 ; i < adjList.length ; ++i)
			adjList[i] = new ArrayList<Integer>();
		int x, y;
		while(m-- > 0) {
			x = in.nextInt();
			y = in.nextInt();
			adjList[x].add(y);
			adjList[y].add(x);
		}
		System.out.println("Traverse from Node 1 using:\n\n");
		System.out.println("Depth First Search (DFS)\n");
		dfs(1);
		System.out.println("\n\n");
		System.out.println("Breadth First Search (BFS)\n");
		bfs(1);
	}
	
	static void dfs(int i) {
		System.out.print(i + " ");
		visited[i] = true;
		// for each node adjacent to the current node
		for(int j = 0 ; j < adjList[i].size() ; ++j) {
			int node = adjList[i].get(j);
			if( !visited[node] )
				dfs(node);
		}
	}
	
	static void bfs(int i) {
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			// for each node adjacent to the current node
			for(int j = 0 ; j < adjList[node].size() ; ++j) {
				int adjNode = adjList[node].get(j);
				if(!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
	}
}
