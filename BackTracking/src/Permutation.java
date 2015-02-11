/*
 * Given n (n <= 10) numbers
 * 
 * print all permutations.
 * 
 */

public class Permutation {
	
	public static final int N = 4;
	
	static int[] arr;
	static int[] selected;
	static boolean[] visited;

	public static void main(String[] args) {
		arr = new int[N];
		selected = new int[N];
		visited = new boolean[N];
		for(int i = 1 ; i <= N ; ++i)
			arr[i-1] = i;
		System.out.println("All Permutations:\n");
		print(0);
	}
	
	static void print(int i) {
		if (i == N) {
			for(int j = 0 ; j < N ; ++j)
				System.out.print(selected[j] + " ");
			System.out.println();
			return;
		}
		for(int j = 0 ; j < N ; ++j)
			if(!visited[j]) {
				visited[j] = true;
				selected[i] = arr[j];
				print(i+1);
				visited[j] = false;
			}
	}
}
