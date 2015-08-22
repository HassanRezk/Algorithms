/**
 * Given a sequence of length n, find the longest increasing subsequence
 * 
 * Sequence: 0, 8, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
 * LIS: 0, 2, 6, 9, 13, 15
 * 
 * Time Complexity: O(nlogn)
 * Memory Complexity: O(n)
 *
 */

public class LIS {

	static int[] a;
	static int[] b;
	static int[] parent;
	static int[] id;
	
	public static void main(String[] args) {
		a = new int[]{0, 8, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int ans = lis();
		System.out.println("Length of LIS = " + ans);
		System.out.print("The Sequence : ");
		get_sequence(end, ans);
	}
	
	static void get_sequence(int i, int k) {
		if(k == 0) return;
		get_sequence(parent[i], k - 1);
		System.out.print(a[i] + " ");
	}
	
	static int end;
	static int lis() {
		b = new int[a.length];
		parent = new int[a.length];
		id = new int[a.length];
		int ret = 1;
		b[0] = a[0];
		for(int i = 1 ; i < a.length ; ++i)
			if(a[i] < b[0]) {
				b[0] = a[i];
				id[0] = i;
			} else if(a[i] > b[ret-1]) {
				b[ret] = a[i];
				id[ret] = i;
				parent[i] = id[ret-1];
				++ret;
				end = i;
			} else {
				int idx = binarySearch(0, ret-1, a[i]);
				b[idx] = a[i];
				id[idx] = i;
				parent[i] = id[idx-1];
			}
		return ret;
	}
	
	static int binarySearch(int l, int r, int val) {
		while(l < r) {
			int mid = (l + r)>>1;
			if(b[mid] > val) r = mid;
			else l = mid + 1;
		}
		return r;
	}

}
