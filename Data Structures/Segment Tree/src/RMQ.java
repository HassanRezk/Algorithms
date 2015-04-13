/**
 *
 * Range minimum query problem:
 * 
 * Given an array a[].
 * 
 * Given n queries, each query is asking for the minimum value
 * in a sub-array of a[].
 *
 * Sample input:
 * 
 * A[] = {18, 17, 13, 19, 15, 11, 20}
 * RMQ:
 * 		0 0
 * 		0 1
 * 		0 6
 * 
 * Sample output:
 * 
 * 18
 * 17
 * 11
 * ================================================
 * Solution using segment tree:
 * 
 * Time Complexity:
 * 		Build Segment Tree: O(n)
 * 		each query: O(log n)
 * 
 * Memory Complexity:
 * 		Segment Tree array: O(n)
 *
 */
public class RMQ {

	static int[] a;
	
	public static void main(String[] args) {
		a = new int[]{18, 17, 13, 19, 15, 11, 20};
		SegmentTree st = new SegmentTree(a);
		System.out.println("RMQ(0,0) = " + st.rmq(0, 0));
		System.out.println("RMQ(0,1) = " + st.rmq(0, 1));
		System.out.println("RMQ(0,6) = " + st.rmq(0, 6));
		System.out.println("RMQ(3,5) = " + st.rmq(3, 5));
		System.out.println("RMQ(2,3) = " + st.rmq(2, 3));
	}

}

class SegmentTree {
	
	private int[] a;
	private int[] st;
	private int n;
	
	public SegmentTree(int[] a) {
		this.a = a;
		n = a.length;
		st = new int[4*n];//O(n) memory
		build(1, 0, n-1);
	}
	
	public int rmq(int i, int j) {
		return rmq(1, 0, n-1, i, j);
	}
	
	private void build(int i, int l, int r) { // O(n)
		if(l == r) st[i] = a[l];
		else {
			int mid = (l+r)>>1;
			build(left(i), l, mid);
			build(right(i), mid+1, r);
			st[i] = Math.min(st[left(i)], st[right(i)]);
		}
	}
	
	private int left(int i) {
		return i << 1;
	}
	
	private int right(int i) {
		return (i << 1) + 1;
	}
	
	private int rmq(int p, int l, int r, int i, int j) { // O(log n)
		if(i > r || j < l) return -1; //invalid segment
		if(l >= i && r <= j) return st[p];
		int mid = (l+r)>>1;
		int p1 = rmq(left(p), l, mid, i, j);
		int p2 = rmq(right(p), mid+1, r, i, j);
		if(p1 == -1) return p2;
		if(p2 == -1) return p1;
		return Math.min(p1, p2);
	}
}
