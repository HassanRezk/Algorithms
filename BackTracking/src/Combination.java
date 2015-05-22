/*
 * Given n and r (n,r <= 10) numbers
 * 
 * print all Combinations.
 * 
 * O(n!/((n-r)!*(r)!))
 * 
 */

public class Combination {
	
	public static final int N = 6, R = 3;
	
	static int[] arr;
	static int[] selected;
	static boolean[] visited;

	public static void main(String[] args) {
		arr = new int[N];
		selected = new int[R];
		visited = new boolean[N];
		for(int i = 1 ; i <= N ; ++i)
			arr[i-1] = i;
		System.out.println("All Combinations:\n");
		print(0,0);
	}
	
	static void print(int i, int last) {
		if (i == R) {
			for(int j = 0 ; j < R ; ++j)
				System.out.print(selected[j] + " ");
			System.out.println();
			return;
		}
		for(int j = last ; j < N ; ++j)
			if(!visited[j]) {
				visited[j] = true;
				selected[i] = arr[j];
				print(i+1,j);
				visited[j] = false;
			}
	}
}
