/**
 *
 *	Given Array a[], required number of inversions in a[].
 *	
 *	Algorithm:
 *			sorting the array using merge sort
 *				 holding a counter for the number of inversions so far.
 *	
 *	Time Complexity:
 *				O(nlogn)
 *
 */

public class Inversions {
	
	
	static int[] temp;
	static int[] a = new int[]{5, 6, 1, 3, 4};
	
	public static void main(String[] args) {
		temp = new int[a.length];
		System.out.println("Number of Inversions = " + mergeSort(0, a.length-1));
	}
	
	static int mergeSort(int low, int high) {
		if(low >= high) return 0;
		int mid = (low + high)>>1;
		int ret = mergeSort(low, mid);
		ret += mergeSort(mid+1, high);
		ret += merge(low, mid, high);
		return ret;
	}
	
	static int merge(int low, int mid, int high) {
		int i = low, j = mid, k = low, ret = 0;
		while(i < mid && j <= high)
			if(a[i] <= a[j])
				temp[k++] = a[i++];
			else {
				temp[k++] = a[j++];
				ret += (mid - i);
			}
		while(i < mid) temp[k++] = a[i++];
		while(j <= high)
			temp[k++] = a[j++];
		for(i = low ; i <= high ; ++i)
			a[i] = temp[i];
		return ret;
	}
	
}
