/**
 *	given n (n <= 10^6), find it's prime factors.
 *
 *	Solution:
 *			use Sieve of Eratosthenes to find all prime numbers to 10^6.
 *			use the generated primes to factorize this number 'n' in O(logn).
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Factorization {

	static ArrayList<Integer> prime;
	static boolean[] isPrime;
	
	static final int N = (int)(1e6) + 3;
	
	public static void main(String[] args) {
		sieve();//Precalculation
		ArrayList<Integer> pf = getPrimeFactors(50050); // O(logn)
		System.out.print("Prime Factors of 50050 are: ");
		for(int i = 0 ; i < pf.size() ; ++i)
			System.out.print(pf.get(i) + " ");
	}
	
	static void sieve() {
		final int SIEVE = (int)Math.sqrt(N) + 1;
		isPrime = new boolean[SIEVE];
		prime = new ArrayList<Integer>();
		
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2 ; i < SIEVE ; ++i)
			if(isPrime[i]) {
				prime.add(i);
				for(int j = i*i ; j < SIEVE ; j += i)
					isPrime[j] = false;
			}
	}
	
	static ArrayList<Integer> getPrimeFactors(int n) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		for(int i = 0 ; i < prime.size() && n != 1
						&& prime.get(i) <= n/prime.get(i) ; ++i)
			while(n % prime.get(i) == 0) {
				n /= prime.get(i);
				ret.add(prime.get(i));
			}
		if(n != 1)
			ret.add(n);
		return ret;
	}

}
