/**
 * Given directed Graph, find the strongly connected Components.
 * 
 *	Kosaraju's Time Complexity:
 *			O(|E| + |V|)
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kosaraju {
	
	static Scanner in;
	
	static int n, m;
	
	static ArrayList<Integer>[] graph, graphTranspose;
	static boolean[] vis;
	
	static int[] time;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("SCC.txt"));
		n = in.nextInt();
		m = in.nextInt();
		graph = new ArrayList[n];
		graphTranspose = new ArrayList[n];
		vis = new boolean[n];
		time = new int[n];
		for(int i = 0 ; i < n ; ++i) {
			graph[i] = new ArrayList<Integer>();
			graphTranspose[i] = new ArrayList<Integer>();
		}
		int from, to;
		while(m-- > 0) {
			from = in.nextInt();
			to = in.nextInt();
			graph[from].add(to);
			graphTranspose[to].add(from);
		}
		System.out.println("Strongly Connected Components:");
		int comp = 0;
		for(int i = 0 ; i < n ; ++i)
			if(!vis[i])
				dfs1(i);
		Arrays.fill(vis, false);
		for(int i = n - 1 ; i >= 0 ; --i)
			if(!vis[time[i]]) {
				System.out.print("Component #" + (++comp) + " ");
				scc(time[i]);
				System.out.println();
			}
	}
	
	static int dfs_time = 0;
	
	static void dfs1(int i) {
		vis[i] = true;
		for(int j = 0 ; j < graph[i].size() ; ++j) {
			int node = graph[i].get(j);
			if(!vis[node])
				dfs1(node);
		}
		time[dfs_time++] = i;
	}
	
	static void scc(int i) {
		vis[i] = true;
		System.out.print(i + " ");
		for(int j = 0 ; j < graphTranspose[i].size() ; ++j) {
			int node = graphTranspose[i].get(j);
			if(!vis[node])
				scc(node);
		}
	}
	
}
