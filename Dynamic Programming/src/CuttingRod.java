/**
 *	Given a rod of length n, given price pi for pieces of length i
 *	for i = 1, 2, 3, ... n
 * 
 * 	find maximum revenue obtainable by cutting up the rod and
 * 	selling the pieces.
 *
 */

import java.util.Arrays;

public class CuttingRod {

	static int[] p;
	static final int N = 9;
	static final int INFINITY = (int)(1e9);
	static int[] dp;
	
	public static void main(String[] args) {
		p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24};
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		System.out.println(solve(N));
	}
	
	static int solve(int n) {
		if(n == 0) return 0; // base case
		if(dp[n] != -1) return dp[n];
		int ret = -INFINITY;
		for(int i = 1 ; i <= n ; ++i) // try all possible cuts
			ret = Math.max(ret, p[i] + solve(n-i));
		return dp[n] = ret;
	}
	
}
