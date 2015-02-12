/**
 *
 * given 9*9 sudoku grid.
 * 
 * Task: solve the sudoku
 *
 *	empty cells are represented by zeroes.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {
	
	public static final int N = 9;
	static int[][] grid;
	static Scanner in;
	
	public static void main(String[] args) throws FileNotFoundException {
		grid = new int[N][N];
		
		in = new Scanner(new File("Sudoku.txt"));
		for(int i = 0 ; i < N ; ++i)
			for(int j = 0 ; j < N ; ++j)
				grid[i][j] = in.nextInt();
		if(solve(0,0)) {
			for(int i = 0 ; i < N ; ++i,System.out.println())
				for(int j = 0 ; j < N ; ++j)
					System.out.print(grid[i][j] + " ");
		} else 
			System.out.println("Invalid Sudoku");
	}
	
	static boolean solve(int i, int j) {
		if(i == N) return true;
		if(grid[i][j] == 0) {
			boolean[] selectedR = new boolean[N+1];
			boolean[] selectedC = new boolean[N+1];
			boolean[] selectedS = new boolean[N+1];
			
			for(int k = 0 ; k < N ; ++k) {
				if(grid[i][k] != 0) selectedR[grid[i][k]] = true;
				if(grid[k][j] != 0) selectedC[grid[k][j]] = true;
			}
			int x = i - (i%3);
			int y = j - (j%3);
			for(int k = 0 ; k < 3 ; ++k)
				for(int l = 0 ; l < 3 ; ++l)
					if(grid[x+k][y+l] != 0)
						selectedS[grid[x+k][y+l]] = true;
			
			for(int k = 1 ; k <= 9 ; ++k) {
				if(!selectedC[k] && !selectedR[k] && !selectedS[k]) {
					grid[i][j] = k;
					if( solve(j == N-1 ? i+1 : i, j == N-1 ? 0 : j+1) ) 
						return true;
					grid[i][j] = 0;
				}
			}
		} else if( solve(j == N-1 ? i+1 : i, j == N-1 ? 0 : j+1) ) 
				return true;
		return false;
	}	
}
