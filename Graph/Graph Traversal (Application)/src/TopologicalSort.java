/**
 *	
 *	Application #5:
 *		Given DAG G(V, E), output the vertices in V such that
 *		no vertex is output before any other vertex with an edge to it.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TopologicalSort {

	static Scanner in;
	
	static final int N = 26;
	
	static int m;
	
	static boolean[] vis;
	static boolean[] exist;
	
	static ArrayList<Integer>[] graph;
	
	static ArrayList<Character> toposort;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("topological.txt"));
		m = in.nextInt();
		graph = new ArrayList[N];
		exist = new boolean[N];
		vis = new boolean[N];
		for(int i = 0 ; i < N ; ++i)
			graph[i] = new ArrayList<Integer>();
		String from, to;
		while(m-- > 0) {
			from = in.next();
			to = in.next();
			graph[from.charAt(0) - 'a'].add(to.charAt(0) - 'a');
			exist[from.charAt(0) - 'a'] = exist[to.charAt(0) - 'a'] = true;
		}		
		toposort = new ArrayList<Character>();
		for(int i = 0 ; i < N ; ++i)
			if(exist[i] && !vis[i])
				dfs(i);
		Collections.reverse(toposort);
		System.out.println("Topological Sort:");
		for(int i = 0 ; i < toposort.size() ; ++i)
			System.out.print(toposort.get(i) + " ");
	}
	
	static void dfs(int i) {
		vis[i] = true;
		for(int j = 0 ; j < graph[i].size() ; ++j) {
			int node = graph[i].get(j);
			if(!vis[node])
				dfs(node);
		}
		toposort.add((char) (i + 'A'));
	}
	
}
