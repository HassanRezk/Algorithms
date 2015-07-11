/**
 * Given an array of length n, task is to find contiguous subarray 
 * 	with maximum sum.
 * 
 * Array[]: -2, 1, -3, 4, -1, 2, 1, -5, 4
 * Maximum sum: 
 *
 *	Dynamic programming algorithm made by Kadane:
 *		
 *		Time Complexity: O(n)
 *		Memory Complexity: O(1)
 *
 */

public class MaximumSubarray {
	
	static int[] arr;
	
	public static void main(String[] args) {
		arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxSoFar, max, start = -1, end = -1;
		maxSoFar = max = 0;
		for(int i = 0 ; i < arr.length ; ++i) {
			if(max + arr[i] > 0) {
				if(start == -1) start = i;
				max += arr[i];
			} else {
				max = 0;
				start = -1;
			}
			if(max > maxSoFar) {
				maxSoFar = max;
				end = i;
			}
		}
		System.out.println("Maximum Sum = " + maxSoFar);
		System.out.println("From " + start + " To " + end);
	}
}
