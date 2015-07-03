/**
 *
 * Application #4:
 * 			Given disconnected undirected graph, the problem is to count
 * 			the number of components in this graph.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountingConnectedComponents {

	static ArrayList<Integer>[] adjList;
	static int n, m;
	static Scanner in;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("connected components.txt"));
		n = in.nextInt();
		m = in.nextInt();
		adjList = new ArrayList[n+1];
		for(int i = 1 ; i <= n ; ++i)
			adjList[i] = new ArrayList<Integer>();
		int from, to;
		while(m-- > 0) {
			from = in.nextInt();
			to = in.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		System.out.println("Connected Components = " + count());
	}

	static int count() {
		int ret = 0;
		vis = new boolean[n+1];
		for(int i = 1 ; i <= n ; ++i)
			if(!vis[i]) {
				dfs(i);
				++ret;
			}
		return ret;
	}
	
	static boolean[] vis;
	
	static void dfs(int i) {
		vis[i] = true;
		for(int j = 0 ; j < adjList[i].size() ; ++j) {
			int node = adjList[i].get(j);
			if(!vis[node])
				dfs(node);
		}
	}
	
}
