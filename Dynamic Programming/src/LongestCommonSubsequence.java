/**
 * 
 *	Given 2 Sequences find the longest common subsequence
 *
 *	Sequence #1: 'abcdgh'
 *	Sequence #2: 'aedfhr'	
 *	
 *	Longest common subsequence: 'adh' ==> length = 3
 *
 *	if length(sequence#1) = N, and length(sequence#2) = M
 *
 *	Time Complexity: O(N*M)	
 *	Memory Complexity: O(N*M)
 *
 */
import java.util.Arrays;

public class LongestCommonSubsequence {
	
	static final int N = 6;
	
	static int[][] dp;
	
	static String s1 = "abcdgh";
	static String s2 = "aedfhr";
	
	public static void main(String[] args) {
		dp = new int[N][N];
		for(int[] arr : dp)
			Arrays.fill(arr, -1);
		System.out.println("LCS length = " + lcs(0, 0));
		System.out.print("Sequence: ");
		trace(0, 0, lcs(0, 0));
	}
	
	static int lcs(int i, int j) {
		if(i == s1.length() || j == s2.length()) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		if(s1.charAt(i) == s2.charAt(j))
			return dp[i][j] = 1 + lcs(i+1, j+1);
		return dp[i][j] = Math.max(lcs(i+1, j), lcs(i, j+1));
	}
	
	static void trace(int i, int j, int k) {
		if(i == s1.length() || j == s2.length() || k == 0) return;
		if(s1.charAt(i) == s2.charAt(j) && lcs(i, j) == k) {
			System.out.print(s1.charAt(i));
			trace(i+1, j+1, k-1);
		} else {
			if(lcs(i+1, j) > lcs(i, j+1))
				trace(i+1, j, k);
			else trace(i, j+1, k);
		}
	}
}
