/**
 *
 * given a set of n numbers
 * 
 * required all subsets.
 *
 */

public class AllSubsets {

	public static final int N = 4;
	
	static int[] arr;
	
	public static void main(String[] args) {
		arr = new int[N];
		for(int i = 0 ; i < N ; ++i) arr[i] = i+1;
		for(int i = 1 ; i < (1<<N) ; ++i, System.out.println())
			for(int j = 0 ; j < N ; ++j)
				if( (i&(1<<j)) != 0 )
					System.out.print(arr[j] + " ");
	}
}
