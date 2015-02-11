import java.util.Random;


public class Test {

	public static void main(String[] args) {
		int[] arr = new int[10];
		Random gen = new Random();
		System.out.print("Initial array : ");
		for(int i = 0 ; i < 10 ; ++i) {
			arr[i] = gen.nextInt(100);
			System.out.print(arr[i] + " ");
		}
		System.out.print("\nAfter Sorting : ");
		TopDown.sort(arr);
		for(int i = 0 ; i < 10 ; ++i)
			System.out.print(arr[i] + " ");
	}
}
