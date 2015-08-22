
public class Test {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("xyz");
		t.insert("abc");
		t.insert("adlgas");
		t.insert("adga");
		t.insert("apapapao");
		
		System.out.println(t.getLongestPrefixMatch("xyz"));
		System.out.println(t.getLongestPrefixMatch("xz"));
		System.out.println(t.getLongestPrefixMatch("adlgsas"));
		System.out.println(t.getLongestPrefixMatch("adlkgh"));
	}

}
