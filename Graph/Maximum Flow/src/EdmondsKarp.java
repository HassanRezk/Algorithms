/**
 *	A better implementation for the Ford-Fulkerson method using BFS instead
 *	of DFS reducing the running time to ==> O(|V|*|E|^2)
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class EdmondsKarp {

	static Scanner in;
	
	static int[][] cap;
	static int[][] flow;
	
	static int[] parent;
	
	static int n, m, s, t;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("Maximum Flow.txt"));
		n = in.nextInt();
		m = in.nextInt();
		cap = new int[n][n];
		TreeMap<String, Integer> val = new TreeMap<>();
		String from, to;
		int w, dfrom, dto;
		int idx = 0;
		while(m-- > 0) { // Building the initial Graph
			from = in.next();
			to = in.next();
			w = in.nextInt();
			if(val.containsKey(from)) dfrom = val.get(from);
			else {
				dfrom = idx++;
				if(from.charAt(0) == 's') s = dfrom;
				val.put(from, dfrom);
			}
			if(val.containsKey(to)) dto = val.get(to);
			else {
				dto = idx++;
				if(to.charAt(0) == 't') t = dto;
				val.put(to, dto);
			}
			cap[dfrom][dto] = w;
		}
		System.out.println("Maximum Flow from s to t = " + maxFlow());
	}
	
	static int maxFlow() {
		int mxf = 0;
		flow = new int[n][n];
		parent = new int[n];
		while(true) {
			bfs();
			if(parent[t] == -1) break;
			int f = Integer.MAX_VALUE;
			int node = t;
			while(node != s) {
				f = Math.min(f, 
						cap[parent[node]][node] - flow[parent[node]][node]);
				node = parent[node];
			}
			node = t;
			while(node != s) {
				flow[parent[node]][node] += f;
				flow[node][parent[node]] -= f;
				node = parent[node];
			}
			mxf += f;
		}
		return mxf;
	}
	
	static void bfs() {
		Arrays.fill(parent, -1);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i = 0 ; i < n ; ++i)
				if(parent[i] == -1 && cap[node][i] - flow[node][i] > 0) {
					parent[i] = node;
					q.add(i);
				}
		}
	}
	
}
