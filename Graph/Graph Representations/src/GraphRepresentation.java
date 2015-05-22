/*
 * A graph G = (V,E) consists of a set of vertices "V" and a set of Edges "E".
 * Each edge is a pair (v,w) where v and w belongs to "V".
 * 
 */
import java.io.*;
import java.util.*;

public class GraphRepresentation {

	static Scanner in;
	
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Representation #1:
		 * 		Adjacency matrix:
		 *			2D boolean matrix cell (i,j) is true 
		 *			only if there exist an edge from node i to node j.
		 *		Memory Complexity:
		 *			O(|V|^2)
		 *
		 *		Advantage:		
		 *			Check whether two vertices are adjacent in O(1)
		 */
		in = new Scanner (new File("graph.txt"));
		int V = in.nextInt(), E = in.nextInt();
		boolean[][] adjMatrix = new boolean[V+1][V+1];// starting from vertex 1
													  //           to vertex V.
		for(int i = 0, x, y ; i < E ; ++i) {
			x = in.nextInt();
			y = in.nextInt();
			adjMatrix[x][y] = true;
			adjMatrix[y][x] = true; // graph is undirected 
		}
		System.out.println("Adjacency Matrix:\n"); // printing the matrix
		for(int i = 1 ; i <= V ; ++i, System.out.println())
			for(int j = 1 ; j <= V ; ++j)
				System.out.print(adjMatrix[i][j] ? "1 " : "0 ");
		System.out.println("\n");
		in.close();
		/*
		 * Representation #2:
		 * 		Adjacency List:
		 *			For each vertex store a list of vertices adjacent
		 *			to this vertex.
		 *		Memory Complexity:
		 *			O(|E|)
		 *
		 *		Advantage:		
		 *		    Less memory Consumption.
		 */
		in = new Scanner (new File("graph.txt"));
		V = in.nextInt();
		E = in.nextInt();
		ArrayList[] adjList = new ArrayList[V+1];
		for(int i = 1 ; i < adjList.length ; ++i)
			adjList[i] = new ArrayList<Integer>();
		
		for(int i = 0, x, y ; i < E ; ++i) {
			x = in.nextInt();
			y = in.nextInt();
			adjList[x].add(y);
			adjList[y].add(x); // undirected graph
		}
		System.out.println("Adjacency List:\n"); // printing
		for(int i = 1 ; i <= V ; ++i, System.out.println()) {
			System.out.print(i + " -> ");
			for(int j = 0 ; j < adjList[i].size() ; ++j)
				System.out.print(adjList[i].get(j) + " ");
		}
		System.out.println("\n");
		in.close();
		/*
		 * Representation #3:
		 * 		Edge List:
		 *			List containing pairs of adjacent nodes.
		 *
		 *		Memory Complexity:
		 *			O(|E|)
		 *
		 *		Advantage:		
		 *		    Useless except for some algorithms.
		 */
		in = new Scanner (new File("graph.txt"));
		V = in.nextInt();
		E = in.nextInt();
		
		Edge[] edgeList = new Edge[2*E]; // undirected graph
		for(int i = 0, x, y ; i < 2*E ; i += 2) {
			x = in.nextInt();
			y = in.nextInt();
			edgeList[i] = new Edge(x, y);
			edgeList[i+1] = new Edge(y, x);
		}
		System.out.println("Edge List:\n"); // printing
		for(int i = 0 ; i < edgeList.length ; ++i) {
			System.out.print(edgeList[i].from + " and " + edgeList[i].to);
			System.out.println(" are adjacent.");
		}
		in.close();
	}
	
	static class Edge { // edge class used for edge list representation.
		public int from, to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

}

