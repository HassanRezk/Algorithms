
public class ISort {

	public static void sort(int[] arr) { 
		// O(n^2) where n is the size of the array
		for(int i = 0 ; i < arr.length ; ++i)
			for(int j = i ; j > 0 ; --j)
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else break;
	}
}
