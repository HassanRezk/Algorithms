/**
 *
 * given b(0 <= b <= 10^9) p(0 <= p <= 10^9)
 * required b^p mod 1000000007
 */


public class IntegerExponentiation {
	
	public static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) {
		System.out.println(power(5,2));
		System.out.println(power(100,3));
		System.out.println(power(3,20));
		System.out.println(power(1000000007, 1000000007));
		System.out.println(power(1000000006, 1000000007));
	}
	
	// O(log(exponent))
	static long power(int base, int exponent) {
		if(exponent == 0) return 1L;
		if((exponent&1L) == 1) 
			return ((base%MOD) * (power(base,exponent-1)%MOD))%MOD;
		long ret = power(base,exponent/2)%MOD;
		return (ret*ret)%MOD;
	}
}
