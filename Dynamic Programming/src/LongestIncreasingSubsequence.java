/**
 * Given a sequence of length n, find the longest increasing subsequence
 * 
 * Sequence: 0, 8, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
 * LIS: 0, 2, 6, 9, 13, 15
 * 
 * Time Complexity: O(N^2)
 * Memory Complexity: O(N)
 *
 */
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static final int N = 16;
	
	static int[] a;
	static int[] dp;
	static int[] trace;
	
	public static void main(String[] args) {
		a = new int[]{10, 0, 8, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		dp = new int[N];
		trace = new int[N];
		Arrays.fill(dp, 1);
		for(int i = 1 ; i < N ; ++i) {
			trace[i] = i;
			for(int j = 0 ; j < i ; ++j)
				if(a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					trace[i] = j;
				}
		}
		int lis = 0, idx = -1;
		for(int i = 0 ; i < N ; ++i)
			if(dp[i] > lis) {
				idx = i;
				lis = dp[i];
			}
		System.out.println("Length of LIS = " + lis);
		System.out.print("The Sequence : ");
		get_sequence(idx);
	}
	
	static void get_sequence(int i) {
		if(trace[i] == i) {
			System.out.print(a[i] + " ");
			return;
		}
		get_sequence(trace[i]);
		System.out.print(a[i] + " ");
	}
}
