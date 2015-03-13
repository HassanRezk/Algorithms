import java.util.Random;


public class Test {

	public static final int N = 25;
	
	public static void main(String[] args) {
		int[] arr = new int[N+1];
		System.out.println("Random Array:");
		for(int i = 1 ; i < arr.length ; ++i) {
			arr[i] =  (new Random()).nextInt(N+1);
			System.out.print(arr[i] + " ");
		}
		MaxPQ.HeapSort(arr);
		System.out.println();
		System.out.println("After Heap Sort:");
		for(int i = 1 ; i < arr.length ; ++i)
			System.out.print(arr[i] + " ");
	}

}
