/**
 * 
 * Max Heap and Heap Sort.
 * 
 */
public class MaxPQ {
	
	private int[] heap;
	private int N;
	private int idx = 0;
	
	public MaxPQ(int N) {
		this.N = N;
		heap = new int[N+1];
	}
	
	public static void HeapSort(int[] arr) { // array must be 1-based
		int N = arr.length;
		--N;
		for(int i = N<<1 ; i >= 1 ; --i) // build the heap, O(nlogn)
			heapify(arr, N, i);
		
		while(N > 1) { // sorting, O(nlogn)
			swap(arr, 1, N);
			heapify(arr, --N, 1);
		}
	}
	
	public void insert(int val) {
		if(idx + 1 < N + 1) {
			heap[++idx] = val;
			int k = idx;
			while(k > 1 && heap[k>>1] < heap[k]) { // O(log n)
				swap(heap, k, k>>1);
				k >>= 1;
			}
		}
		// else if the heap is full ==> do nothing.
	}
	
	public int extractMax() {
		if(isEmpty()) 
			return -(1<<30); // if the heap is empty return garbage
		int ret = heap[1];
		swap(heap, 1, idx--);
		heapify(heap, idx, 1);
		return ret;
	}
	
	public boolean isEmpty() {
		return idx == 0;
	}
	
	public int getSize() {
		return idx;
	}
	
	private static void heapify(int[] heap, int idx, int i) {
		while((i << 1) <= idx) { // O(log n)
			int j = i << 1;
			if(j < idx && heap[j] < heap[j+1]) ++j;
			if(heap[i] >= heap[j]) break;
			swap(heap, j, i);
			i = j;
		}
	}
	
	private static void swap(int[] heap, int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
