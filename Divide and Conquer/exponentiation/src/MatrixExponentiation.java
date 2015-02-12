/**
 *
 * Exponentiation of a square matrix. 
 *
 */

public class MatrixExponentiation {
	
	public static void main(String[] args) {
		int[][] m = {
				{1,1}, {1,1}
		};
		Matrix a = new Matrix(m);
		System.out.println(a.power(5));
	}
}

class Matrix {
	int[][] matrix;
	int sz;
	
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
		sz = matrix.length;
	}
	
	public Matrix(int n) {
		matrix = new int[n][n];
		sz = n;
	}
	
	public Matrix mutiply ( Matrix m ){ // O(sz^3)
		Matrix ret = new Matrix(sz);
		for ( int i = 0 ; i < sz ; i ++ )
			for ( int j = 0 ; j < sz ; j ++ )
				for ( int k = 0 ; k < sz ; k ++ )
					ret.matrix[i][j] += (m.matrix[i][k]*this.matrix[k][j]) ;
		return ret ;
	}
	
	Matrix power(int k) { // O(sz^3 * log k)
		if(k == 1) return this;
		if((k&1) == 1) return this.mutiply(power(k-1));
		Matrix ret = power(k/2);
		return ret.mutiply(ret);
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder("");
		for(int i = 0 ; i < sz ; ++i, ret.append("\n"))
			for(int j = 0 ; j < sz ; ++j)
				ret.append(matrix[i][j] + " ");
		return ret.toString();
	}
}