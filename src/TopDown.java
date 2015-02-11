
public class TopDown {
	
	public static void sort(int[] a) {
		sort(a, 0, a.length-1);
	}
	
	private static void merge(int[] a, int low, int high, int mid) {
		int[] aux = new int[high-low+1];
		for(int i = low, j = mid+1, k = 0 ; k < aux.length ; ++k)
			if( i > mid || (j <= high && a[j] < a[i]) ) aux[k] = a[j++];
			else 				                           aux[k] = a[i++];
		for(int j = 0 ; j < aux.length ; ++j)
			a[low++] = aux[j];
	}
	
	private static void sort(int[] a, int low, int high) {
		if(low >= high) return;
		int mid = low + (high-low)/2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge(a, low, high, mid);
	}
}
