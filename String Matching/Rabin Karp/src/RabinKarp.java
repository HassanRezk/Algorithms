/**
 *
 * Rabin Karp algorithm for String matching,
 * using the rolling hash technique.
 *
 * O(nt + np + match*np)
 * 
 * where:
 * 
 * nt = length of initial String.
 * np = length of the pattern.
 * match = # of matching 
 *
 */

public class RabinKarp {
	
	static final int B = 17, M = (int)(1e9) + 7;
	
	public static void main(String[] args) {
		String t = "aaaaaaaaaaaaaaaaaaaaaaaaaba";
		String p = "aaab";
		
		long hp = 0;
		long ht = 0;
		int np = p.length()-1;
		
		for(int i = 0 ; i < p.length() ; ++i) {
			hp += ((power(B, np-i)%M)*((int)p.charAt(i) - 'a' + 1)%M)%M;
			hp %= M;
			ht += ((power(B, np-i)%M)*((int)t.charAt(i) - 'a' + 1)%M)%M;
			ht %= M;
		}
		
		if(ht == hp) {
			boolean matched = true;
			for(int i = 0 ; i < p.length() && matched ; ++i)
				matched &= (p.charAt(i) == t.charAt(i));
			if(matched) {
				System.out.println("Matched");
				return;
			}
		}
		
		for(int i = p.length() ; i < t.length() ; ++i) {
			ht *= B;
			ht += (int)(t.charAt(i) - 'a' + 1);
			ht -= power(B, p.length());
			ht %= M;
			
			if(ht == hp) {
				boolean matched = true;
				for(int j = i, k = 0 ; k < p.length() && matched ; ++k, --j)
					matched &= (p.charAt(np - k) == t.charAt(j));
				if(matched) {
					System.out.println("Matched");
					return;
				}
			}
		}
		System.out.println("Not Matched");
	}
	
	static long power(long base, int exp) {
		if(exp == 0) return 1;
		if((base&1) == 1) return ( (base%M) * (power(base, exp-1)%M) )%M;
		long ret = power(base, exp/2)%M;
		return (ret*ret)%M;
	}

}
