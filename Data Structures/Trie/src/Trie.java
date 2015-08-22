/**
 * 
 * Trie is a data structure that stores a set of strings S.
 * 
 * for any string L:
 * 			Insert ==> O(|L|)
 * 			Search ==> O(|L|)
 * 
 */

import java.util.HashMap;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	public void insert(String s) {
		TrieNode temp = root;
		for(int i = 0 ; i < s.length() ; ++i) {
			char c = s.charAt(i);
			if(!temp.children.containsKey(c)) {
				TrieNode temp2 = new TrieNode(c);
				temp.children.put(c, temp2);
				temp = temp2;
			} else temp = temp.children.get(c);
		}
		temp.isLeaf = true;
	}
	
	public String getLongestPrefixMatch(String s) {
		StringBuilder ret = new StringBuilder("");
		TrieNode temp = root;
		for(int i = 0 ; i < s.length() ; ++i) {
			char c = s.charAt(i);
			if(temp.children.containsKey(c)) {
				ret.append(c);
				temp = temp.children.get(c);
			} else break;
		}
		return ret.toString();
	}
	
}

class TrieNode {
	
	public char value;
	public HashMap<Character, TrieNode> children;
	public boolean isLeaf;
	
	public TrieNode(char value) {
		this.value = value;
		children = new HashMap<>();
		isLeaf = false;
	}
	
}
