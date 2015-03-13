/**
 * Given a sequence of length n, find the longest increasing subsequence
 * 
 * Sequence: 0, 8, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
 * LIS: 0, 2, 6, 9, 13, 15
 *
 */
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static final int N = 15;
	
	static int[] a;
	static int[] dp;
	
	public static void main(String[] args) {
		a = new int[]{0, 8, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		dp = new int[N];
		Arrays.fill(dp, -1);
		System.out.println("Size of LIS is: " + lis(0));
		System.out.println("LIS\n");
		print(0, lis(0));
	}
	
	static int lis(int i) { // O(n^2)
		if(i == N) return 0;
		if(dp[i] != -1) return dp[i];
		int ret = 1;
		for(int j = i + 1 ; j < N ; ++j)
			if(a[j] > a[i] && 1 + lis(j) > ret)
				ret = 1 + lis(j);
		return dp[i] = ret;
	}
	
	static void print(int i, int ans) {
		if(i == N || ans == 0) return;
		for(int j = i ; j < N ; ++j)
			if(dp[j] == ans) {
				System.out.print(a[j] + " ");
				print(j+1, ans-1);
				return;
			}
	}
	
}
