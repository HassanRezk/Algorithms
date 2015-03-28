/**
 *
 * A linear recurrence relation is a function or a sequence such that each term
 * is a linear combination of previous terms. Each term can be described as a
 * function of the previous terms.
 * 
 * Problem: Given n (n <= 10^18) find f(n)%(1000000007)
 * 
 * f(n) = f(n-1) + f(n-2) , n > 2 f(1) = 1 f(2) = 1
 * 
 * solution is to find "transformation matrix".
 * 
 * Transformation matrix:
 * 
 * A square matrix 'T' such that T*f(i) = f(i+1)
 * 
 * thus for any n (T^n-1)*f(1) = f(n)
 * 
 * Time Complexity: O(log n)
 *
 */

public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 1; i < 20; ++i)
			System.out.print(f(i) + " ");
		System.out.println("\n" + f((long) (1e18) - 2) + " + "
				+ f((long) (1e18) - 1) + " = " + f((long) (1e18)));
	}

	static long f(long n) {
		if (n == 1)
			return 1L;
		long[][] a = { { 0, 1 }, { 1, 1 } };
		Matrix T = new Matrix(a);
		T = T.power(n - 1);
		return (T.matrix[0][0] + T.matrix[0][1])%Matrix.MOD;
	}

}

class Matrix {

	public static final int MOD = (int)(1e9) + 7;
	public long[][] matrix;
	private int sz;

	public Matrix(long[][] matrix) {
		this.matrix = matrix;
		sz = matrix.length;
	}

	public Matrix(int n) {
		matrix = new long[n][n];
		sz = n;
	}

	public Matrix mutiply(Matrix m) { // O(sz^3)
		Matrix ret = new Matrix(sz);
		for (int i = 0; i < sz; i++)
			for (int j = 0; j < sz; j++)
				for (int k = 0; k < sz; k++) {
					ret.matrix[i][j] += ((m.matrix[i][k] % MOD) * 
										(this.matrix[k][j] % MOD))%MOD;
					ret.matrix[i][j] %= MOD;
				}
		return ret;
	}

	//exponentiation of a square matrix using divide and conquer.
	Matrix power(long k) { // O(sz^3 * log k)
		if (k == 1)
			return this;
		if ((k & 1) == 1)
			return this.mutiply(power(k - 1));
		Matrix ret = power(k / 2);
		return ret.mutiply(ret);
	}

}
