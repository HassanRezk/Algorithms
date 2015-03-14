import java.util.Arrays;

/**
 *
 * Given a list of items.
 * for each item i
 *		weight ==> wi, value ==> vi
 *
 * find a subset of items with maximum values
 * 			  and weight that doesn't exceed w.
 *
 */
public class Knapsack {
	
	public static int N = 6;
	
	static int[] w;
	static int[] v;
	
	static int[][] dp;
	
	static int maxW = 33;
	
	public static void main(String[] args) {
		w = new int[]{26, 22, 4, 18, 13, 9};
		v = new int[]{64, 85, 52, 99, 39, 54};
		dp = new int[N][maxW+1];
		for(int[] arr : dp)
			Arrays.fill(arr, -1);
		System.out.println("Answer: " + solve(0, maxW));
	}
	
	static int solve(int i, int mw) { // O(N*maxW)
		if(mw < 0) return -(1<<30);
		if(i == N) return 0;
		if(dp[i][mw] != -1) return dp[i][mw];
		return dp[i][mw] = Math.max(solve(i+1, mw), v[i] + solve(i+1, mw - w[i]));
		                  // each item try to take it or leave it.
	}
}
