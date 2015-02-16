import java.util.Random;


public class Test {
	
	public static final int N = 10;
	static int[] arr = new int[N];
	static Random gen = new Random();
	
	public static void main(String[] args) {
		System.out.print("Initial array: ");
		gen();
		print();
		System.out.print("After Sorting: ");
		BSort.sort(arr);
		print();
	}
	
	public static void gen() {
		for(int i = 0 ; i < N ; ++i)
			arr[i] = gen.nextInt(10*N);
	}
	
	public static void print() {
		for(int i = 0 ; i < N ; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}	
}
