
public class TopDown {
	
	static int[] aux;
	
	public static void sort(int[] a) { // O(nlogn)
		aux = new int[a.length];
		sort(a, 0, a.length-1);
	}
	
	public static void merge(int[] a, int[] aux, int low, int high, int mid) {
		int sz = high-low+1;
		for(int i = low, j = mid+1, k = 0 ; k < sz ; ++k)
			if( i > mid || (j <= high && a[j] < a[i]) ) aux[k] = a[j++];
			else 				                        aux[k] = a[i++];
		for(int j = low, k = 0 ; k < sz ; ++k, ++j)
			a[j] = aux[k];
	}
	
	private static void sort(int[] a, int low, int high) {
		if(low >= high) return;
		int mid = low + (high-low)/2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge(a, aux, low, high, mid);
	}
}
