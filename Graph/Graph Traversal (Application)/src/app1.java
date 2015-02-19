/**
 *
 * Application #1:
 * 		Path finding.
 * 
 * The idea is simple do a dfs from the source node. 
 * for each visited node store the parent of this node.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class app1 {
	
	static Scanner in;
	
	static int n, m;
	static ArrayList<Integer>[] adjList;
	static boolean visited[];
	static int[] parent;
	
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
		parent = new int[n+1];
		for(int i = 1 ; i < n+1 ; ++i)
			parent[i] = i;
		dfs(1);
		System.out.println("path from 1 to 6\n");
		path(1,6); // path from 1 to 6
	}
	
	static void dfs(int i) {
		visited[i] = true;
		for(int j = 0 ; j < adjList[i].size() ; ++j) {
			int node = adjList[i].get(j);
			if( !visited[node] ) {
				parent[node] = i;
				dfs(node);
			}
		}
	}
	
	static void path(int src, int dest) {
		if(src == dest) System.out.print(src + " ");
		else {
			path(src, parent[dest]);
			System.out.print(dest + " ");
		}
	}

}
