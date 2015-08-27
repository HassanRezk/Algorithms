/**
 *
 *	Problem:
 *  		Given a tree of N nodes find the number of nodes on the longest
 *  		path between two leaves in the tree.
 *  
 *  Algorithm used ==> DFS
 *  
 *  Running Time: O(N)
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Diameter {
	
	static ArrayList<Integer>[] tree;
	static Scanner in;
	static int n;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("Diameter of a tree.txt"));
		n = in.nextInt();
		tree = new ArrayList[n+1];
		for(int i = 0 ; i < n+1 ; ++i) 
			tree[i] = new ArrayList<Integer>();
		int from, to;
		for(int i = 0 ; i < n-1 ; ++i) {
			from = in.nextInt();
			to = in.nextInt();
			tree[from].add(to);
			tree[to].add(from);
		}
		int ans = dfs(1, 1).diameter; // start dfs from any node
		System.out.println("Diameter of the given tree = " + ans);
	}
	
	static Pair dfs(int i, int p) {
		int ret = 0;
		int[] h = new int[3];
		for(int v : tree[i])
			if(v != p) {
				Pair temp = dfs(v, i);
				ret = Math.max(ret, temp.diameter);
				h[0] = temp.height + 1;
				Arrays.sort(h);
			}
		ret = Math.max(ret, h[1] + h[2]);
		return new Pair(ret, h[2]);
	}

}

class Pair {
	
	public int diameter;
	public int height;
	
	public Pair(int diameter, int height) {
		this.diameter = diameter;
		this.height = height;
	}
	
}