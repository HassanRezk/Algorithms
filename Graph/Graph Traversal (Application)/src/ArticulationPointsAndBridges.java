/**
 *
 * Application #7:
 * 			Given a connected graph, find all articulation points and bridges.
 * 
 * Articulation Point:
 * 				A node which if removed would disconnect the graph into
 * 				multiple components.
 * 
 * Bridge:
 * 		An edge that if removed will disconnect the graph into multiple
 * 		components.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ArticulationPointsAndBridges {

	static int n, m, dfsTime, dfsRoot, rootChildren;
	
	static Scanner in;
	
	static int[] dfsLow, dfsNum, dfsParent;
	
	static ArrayList<Integer>[] graph;
	
	static ArrayList<Integer> bridgeFrom, bridgeTo;
	
	static TreeSet<Integer> articulationPoint;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("Articulation points and bridges.txt"));
		n = in.nextInt();
		m = in.nextInt();
		graph = new ArrayList[n+1];
		dfsLow = new int[n+1];
		dfsNum = new int[n+1];
		dfsParent = new int[n+1];
		articulationPoint = new TreeSet<Integer>();
		bridgeFrom = new ArrayList<Integer>();
		bridgeTo = new ArrayList<Integer>();
		for(int i = 0 ; i < graph.length ; ++i)
			graph[i] = new ArrayList<Integer>();
		int from, to;
		while(m-- > 0) {
			from = in.nextInt();
			to = in.nextInt();
			graph[from].add(to);
			graph[to].add(from);
		}
		dfs(1);
		dfsRoot = 1;
		if(rootChildren > 1)
			articulationPoint.add(dfsRoot);
		
		System.out.println("Articulation Points");
		for(int v : articulationPoint)
			System.out.print(v + " ");
		System.out.println('\n');
		
		System.out.println("Bridges");
		for(int i = 0 ; i < bridgeFrom.size() ; ++i)
			System.out.println(bridgeFrom.get(i) + " " + bridgeTo.get(i));
	}
	
	static void dfs(int i) {
		dfsLow[i] = dfsNum[i] = dfsTime++;
		for(int j = 0 ; j < graph[i].size() ; ++j) {
			int node = graph[i].get(j);
			if(node == dfsParent[i]) continue;
			if(dfsNum[node] == 0) { // unvisited
				dfsParent[node] = i;
				if(i == dfsRoot)
					++rootChildren;
				dfs(node);
				if(dfsLow[node] > dfsNum[i])
					articulationPoint.add(i);
				if(dfsLow[node] > dfsNum[i]) {
					bridgeFrom.add(i);
					bridgeTo.add(node);
				}
				dfsLow[i] = Math.min(dfsLow[i], dfsLow[node]);
			} else if(node != dfsParent[i]) // Cycle
				dfsLow[i] = Math.min(dfsLow[i], dfsNum[node]);
		}
	}
	
}
