
public class BottomUp {
	
	public static void sort(int[] a) {  // O(nlogn)
		for(int i = 1 ; i < a.length ; i = i+i)
			for(int j = 0 ; j < a.length-i ; j += i+i)
				TopDown.merge(a, j, Math.min(j+i+i-1, a.length-1), j+i-1);
	}
}
