/**
 * 
 * The Problem is to Find all prime numbers from 0 to a given n.
 * 
 * Idea:
 * 		Composites are multiples of primes, use the primes to eliminate them.
 * 
 * Time Complexity:
 * 				  O(n log(log n))
 */

import java.util.Arrays;

public class Sieve {

	static int N = 1000;
	
	static boolean[] isPrime;
	
	static void sieve() {
		isPrime = new boolean[N];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2 ; i*i < N ; ++i)
			if(isPrime[i])
				for(int j = i*i ; j < N ; j += i)
					isPrime[j] = false;
	}
	
	public static void main(String[] args) {
		sieve();
		for(int i = 0 ; i < N ; ++i)
			if(isPrime[i])
				System.out.print(i + " ");
	}
	
}
