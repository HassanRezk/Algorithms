/**
 *
 * Application #2:
 * 		Bipartite graph check.
 * 
 * A Graph is bipartite if we can color it using two colors such that
 * adjacent nodes have different colors.
 * 
 * Algorithm:
 * 		start by coloring a node, color every adjacent node to this node with
 * 		an alternative color.
 * 
 * 	(1)	if a step is reached where we must color a node with different colors
 * 		then the graph is not bipartite.
 * 
 * 		if(1) never happened then the graph is bipartite.
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class app2 {

	static Scanner in;
	
	static int n, m;
	static ArrayList<Integer>[] adjList;
	static int color[];
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("bipartite.txt"));
		n = in.nextInt();
		m = in.nextInt();
		adjList = new ArrayList[n+1];
		for(int i = 1 ; i < adjList.length ; ++i)
			adjList[i] = new ArrayList<Integer>();
		int x, y;
		while(m-- > 0) {
			x = in.nextInt();
			y = in.nextInt();
			adjList[x].add(y);
			adjList[y].add(x);
		}
		color = new int[n+1]; 
		// 2 colors are 1 and 2
		// uncolored ==> 0
		if(bipartiteCheck()) System.out.println("The Graph is Bipartite");
		else System.out.println("The Graph is not Bipartite");
	}
	
	static boolean bipartiteCheck() {
		for(int i = 1 ; i < n+1 ; ++i) // for each node
			if(color[i] == 0) {
				color[i] = 1;
				if(!isBipartite(i))
					return false;
			}
		return true;
	}
	
	static boolean isBipartite(int i) {
		boolean ret = true;
		for(int j = 0 ; j < adjList[i].size() ; ++j) {
			int node = adjList[i].get(j);
			if(color[node] == color[i])
			// if this adjacent node has the same color as the current node.
				return false; 
			
			if(color[node] == 0) { // if not colored yet
				color[node] = 3-color[i]; // color it with alternative color.
				ret &= isBipartite(node); 
				// do the check from the adjacent node.
			}
		}
		return ret;
	}
	
}
