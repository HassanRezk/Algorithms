/**
 *
 * Application #6:
 * 			Given directed graph, check if the graph has any cycle.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetection {

	static ArrayList<Integer>[] graph;
	
	static Scanner in;
	
	static int n, m;
	
	static int[] visited;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("cycle detection.txt"));
		n = in.next().charAt(0) - 'a';
		graph = new ArrayList[n+1];
		visited = new int[n+1];
		for(int i = 0 ; i < graph.length ; ++i)
			graph[i] = new ArrayList<Integer>();
		m = in.nextInt();
		int from, to;
		while(m-- > 0) {
			from = in.next().charAt(0) - 'a';
			to = in.next().charAt(0) - 'a';
			graph[from].add(to);
		}
		for(int i = 0 ; i < n + 1 ; ++i)
			if(visited[i] == 0)
				if(hasCycle(i)) {
					System.out.println("Cycle detected.");
					return;
				}
		System.out.println("Cycle not found.");
	}
	
	static boolean hasCycle(int i) {
		boolean ret = false;
		visited[i] = 1;
		for(int j = 0 ; j < graph[i].size() && !ret ; ++j) {
			int node = graph[i].get(j);
			if(visited[node] == 0)
				ret |= hasCycle(node);
			else if(visited[node] == 1)
				return true;
		}
		visited[i] = 2;
		return ret;
	}

}
