/**
 *
 * Given two numbers a, b.
 * 
 * 1- Find their greatest common divisor(GCD).
 * 2- Find their least common multiple(LCM).
 * 
 * GCD: the largest number that divides both of them.
 * LCM: the smallest number that is divisible by both of them.
 * 
 * Using Euclid's algorithm.
 * 
 * gcd(a, 0) = a
 * gcd(a, b) = gcd(b, a mod b)
 * * * * * * * * * * * * * * * * *
 * lcm(a, b) = a*b/gcd(a, b)
 * 
 */

public class GCD_LCM {
	
	public static void main(String[] args) {
		int a = 1116, b = 504;
		System.out.println("GCD = " + gcd(a, b));
		System.out.println("LCM = " + lcm(a, b));
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	
	static int lcm(int a, int b) {
		return (a/gcd(a,b))*b;
	}
}
