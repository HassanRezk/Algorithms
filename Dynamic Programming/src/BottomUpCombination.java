/**
 * 
 * Repeat Combination Problem.
 * 
 * Bottom up approach using pascal's triangle
 *
 */

public class BottomUpCombination {
	
	static int[][] C;
	
	public static void main(String[] args) {
		C = new int[1005][1005];
		
		for(int i = 0 ; i < 1001 ; ++i)
			C[i][0] = C[i][i] = 1;
		
		for(int i = 1 ; i < 1001 ; ++i)
			for(int j = 1 ; j < i ; ++j)
				C[i][j] = ((C[i-1][j]%Combination.MOD) 
						 + (C[i-1][j-1]%Combination.MOD)) % Combination.MOD;
		
		System.out.println("C(5,2): " + C[5][2]);
		System.out.println("C(10,3): " + C[10][3]);
		System.out.println("C(1000,3): " + C[1000][3]);
	}
}
