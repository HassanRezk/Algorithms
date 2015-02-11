import java.util.Arrays;

/*
 * lets define C(n,r) as the number of subsets of size r that can be selected
 * from a set of n elements.
 * 
 * assume n,r [0,1000]
 * 
 * Calculate the answer modulo 1 000 000 007
 * 
 * using the recurrence:
 * 
 * C(n,r) = C(n-1,r-1) + C(n-1,r)
 * 
 * O(n*r)
 * 
 */


public class Combination {
	
	static final int MOD = 1_000_000_007;
	static int[][] dp;

	public static void main(String[] args) {
		dp = new int[1005][1005];
		for(int[] a : dp)
			Arrays.fill(a, -1);
		
		System.out.println("C(5,2): " + C(5,2));
		System.out.println("C(10,3): " + C(10,3));
		System.out.println("C(1000,3): " + C(1000,3));
	}
	
	static int C(int n, int r) {
		if(n == 0 && r == 0) return 1;
		if(r < 0 || (n == 0 && r > 0)) return 0;
		if(dp[n][r] != -1) return dp[n][r];
		return dp[n][r] =  (( C(n-1,r-1) % MOD ) + ( C(n-1,r) % MOD ))%MOD;
	}
}
