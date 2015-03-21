/**
 *
 * KMP algorithm for String matching.
 * 
 * Given String T and a pattern P find occurence of P in T.
 * 
 * Time Complexity: O(n) ==> Linear Time
 * Memory Complexity: O(n)
 *
 */
public class KMP {

	public static void main(String[] args) {
		String p = "ababcaba";
		String t = "aaacabababcabadddb";
		
		if(KMPmatch(t, p)) System.out.println("Matched");
		else System.out.println("Not Matched");
	}

	static int[] buildFail(String t) {
		int[] f = new int[t.length()];
		f[0] = 0;
		for(int i = 1 ; i < f.length ; ++i) {
			
			int matched = f[i-1];
			while(matched > 0 && t.charAt(i) != t.charAt(matched))
				//while failing
				matched = f[matched-1];//go to next match
			
			if(t.charAt(i) == t.charAt(matched))
				++matched;
			
			f[i] = matched;
		}
		return f;
	}
	
	static boolean KMPmatch(String t, String p) {
		int[] fail = buildFail(p);//building failure using the pattern.
		int matched = 0;
		for(int i = 0 ; i < t.length() ; ++i) {
			
			//In case we can't use next character, we move to the next best
			//possible matching
			while(matched > 0 && t.charAt(i) != p.charAt(matched))
				matched = fail[matched-1];
			
			if(t.charAt(i) == p.charAt(matched)) // one more character matched
				++matched;
			
			if(matched == p.length()) 
				return true; // matched all the pattern
		}
		return false;//pattern not found
	}
}
