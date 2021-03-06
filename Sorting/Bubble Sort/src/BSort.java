
public class BSort {
	
	public static void sort(int[] arr) {
		// O(n^2) where n is the size of the array
		for(int i = 0 ; i < arr.length-1 ; ++i)
			for(int j = arr.length-1 ; j > i ; --j)
				if(arr[j] < arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
	}
}
