import java.util.Random;

/*
 * Given a weighted grid n*m find the maximum path from (0,0) to (n-1,m-1)
 * 
 * at each step you can move from cell (i, j) to either cell (i+1, j) or
 * cell (i,j+1)
 * 
 * assume that n,m [1,1000]
 * each cell denoted as a(i,j) and a(i,j) [1,1000000000]
 * 
 * O(n*m)
 * 
 */


public class MaximumPath {
	
	static final int N = 10, M = 10;
	static int[][] a;
	static long[][] dp;
	static boolean[][] solved;
	
	static void reset() {
		for(int i = 0 ; i < dp.length ; ++i)
			for(int j = 0 ; j < dp[i].length ; ++j) {
				dp[i][j] = 0;
				solved[i][j] = false;
			}
	}
	
	public static void main(String[] args) {
		a = new int[N][M];
		dp = new long[N][M];
		solved = new boolean[N][M];
		Random gen = new Random();
		
		System.out.println("#Grid1");
		for(int i = 0 ; i < N ; ++i, System.out.println())
			for(int j = 0 ; j < M ; ++j) {
				a[i][j] = gen.nextInt((int)20) - (int)10;
				System.out.print(a[i][j] + " ");
			}
		System.out.println("\nMaximum path = " + solve(0,0));
		System.out.println("The path:");
		pathRecover(0, 0);
		System.out.println("\n");
		
		System.out.println("#Grid2");
		for(int i = 0 ; i < N ; ++i, System.out.println())
			for(int j = 0 ; j < M ; ++j) {
				a[i][j] = gen.nextInt((int)(2e9)) - (int)1e9;
				System.out.print(a[i][j] + " ");
			}
		reset();
		System.out.println("\nMaximum path = " + solve(0,0));
		System.out.println("The path:");
		pathRecover(0, 0);
	}
	
	static long solve(int i, int j) {
		if(i >= N || j >= M) return -(1L<<45);
		if(i == N-1 && j == M-1) return a[i][j];
		if(solved[i][j]) return dp[i][j];
		dp[i][j] = a[i][j] + Math.max(solve(i+1,j), solve(i,j+1));
		solved[i][j] = true;
		return dp[i][j];
	}
	
	static void pathRecover(int i, int j) {
		if(i >= N || j >= M) return;
		System.out.print(a[i][j] + " ");
		long c1 = solve(i+1,j), c2 = solve(i,j+1);
		if ( c1 > c2 ) pathRecover(i+1, j);
		else pathRecover(i, j+1);
	}
}
