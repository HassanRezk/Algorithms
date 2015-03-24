/**
 *
 * Travelling Salesman Problem: (NP - Hard Problem)
 * 
 * Given a list of cities and the distances between each pair of cities,
 * 
 * find the shortest possible route that visits each city exactly once
 * and returns to the origin city.
 * 
 * Brute Force Solution: O(n!)
 * Using Dynamic Programming: O((n^2)*(2^n))
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TravellingSalesman {
	
	static int n, m;
	
	static Scanner in;
	static int[][] graph;
	static int start;
	
	static int[][] dp;
	
	static final int INFINITY = (int)(1e9);

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("TSP.txt"));
		n = in.nextInt();
		m = in.nextInt();
		graph = new int[n][n];
		dp = new int[n][1<<n];
		for(int i = 0 ; i < n ; ++i) {
			Arrays.fill(graph[i], INFINITY);
			graph[i][i] = 0;
			Arrays.fill(dp[i], -1);
		}
		while(m-- > 0) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			int w = in.nextInt();
			graph[x][y] = graph[y][x] = w;
		}
		start = 0;
		System.out.println(solve(start, 0));
	}
	
	static public int solve(int i, int mask) {
		if(mask == (1<<n) - 1)
			return graph[start][i];
		
		if(dp[i][mask] != -1) return dp[i][mask];
		
		int ret = INFINITY;
		
		for(int j = 0 ; j < n ; ++j)
			if( (mask&(1<<j)) == 0 )
				ret = Math.min(ret, graph[i][j] + solve(j, mask|(1<<j)));
		
		return dp[i][mask] = ret;
	}
}
