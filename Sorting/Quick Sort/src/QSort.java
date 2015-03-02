/**
 * Quick Sort using Dijkstra 3-way partitioning.
 * 
 * known as Quick3.
 * 
 * Running Time:
 * 			O(nlogn)
 * 
 * Best Case: 
 * 			O(n)
 * 
 */
import java.util.Random;

public class QSort {
	
	public static void sort(int[] a) {
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	public static void sort(int[] a, int low, int high) {
		if(low >= high) return;
		int left = low, right = high, i = low;
		while(i <= right)          // O(n)
			if(a[i] < a[left]) {
				swap(a, left, i);
				++left;
				++i;
			} else if(a[i] > a[left]) {
				swap(a, i, right);
				--right;
			} else ++i;
		
		sort(a, low, left-1);
		sort(a, right+1, high);
	}
	
	public static void shuffle(int[] a) {
		for(int i = 0 ; i < a.length ; ++i) {
			int key = random(i+1);
			swap(a, i, key);
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static int random(int limit) {
		return (new Random()).nextInt(limit);
	}
	
}
