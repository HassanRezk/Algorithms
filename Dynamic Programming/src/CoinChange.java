/**
 *
 * Find the number of ways of making changes for n cents, 
 * 	given set of denominations d1, d2, ... dm.
 * 
 * Sample:
 * 		n = 4, S = {1, 2, 3}
 * 
 * there are 4 solutions:
 * 
 * {1, 1, 1, 1}
 * {1, 1, 2}
 * {2, 2}
 * {1, 3}
 *
 *	Time Complexity:
 *			O(nm)
 *
 *	Memory Complexity:
 *			O(nm) using topdown approach.
 *
 */

import java.util.Arrays;

public class CoinChange {

	static int[] coins;
	static int n;
	
	static int[][] dp;
	
	public static void main(String[] args) {
		coins = new int[]{1, 2, 3};
		n = 4;
		dp = new int[coins.length][n+1];
		for(int[] arr : dp)
			Arrays.fill(arr, -1);
		System.out.println("Number of ways for making " + n + 
							" = " + solve(0, n));
	}
	
	static int solve(int i, int val) {
		if(val == 0) return 1;
		if(i == coins.length || val < 0) return 0;
		if(dp[i][val] != -1) return dp[i][val];
		return dp[i][val] = solve(i+1, val) + solve(i, val - coins[i]);
	}
	
}
