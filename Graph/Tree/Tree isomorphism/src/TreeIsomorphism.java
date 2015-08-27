/**
 *
 * Given 2 trees of n nodes check if they are isomorphic or not.
 * 
 * Algorithm:
 * 			get string representation of the both of them and do the check.
 * 
 * Running Time:
 * 				O(nlogn)
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TreeIsomorphism {

	static Scanner in;
	
	static ArrayList<Integer>[] tree1;
	static ArrayList<Integer>[] tree2;
	
	static int n;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("Tree isomorphism.txt"));
		n = in.nextInt();
		tree1 = new ArrayList[n+1];
		tree2 = new ArrayList[n+1];
		for(int i = 1 ; i < n + 1 ; ++i) {
			tree1[i] = new ArrayList<Integer>();
			tree2[i] = new ArrayList<Integer>();
		}
		int from, to;
		for(int i = 0 ; i < n - 1 ; ++i) {
			from = in.nextInt();
			to = in.nextInt();
			tree1[from].add(to);
			tree1[to].add(from);
		}
		for(int i = 0 ; i < n - 1 ; ++i) {
			from = in.nextInt();
			to = in.nextInt();
			tree2[from].add(to);
			tree2[to].add(from);
		}
		String t1 = getRepresentation(tree1, 1, 1);
		String t2 = getRepresentation(tree2, 1, 1);
		if(t1.equals(t2)) System.out.println("the trees are isomorphic");
		else System.out.println("the trees are NOT isomorphic");
	}
	
	static String getRepresentation(ArrayList<Integer>[] tree, int i, int p) {
		ArrayList<String> childrenRep = new ArrayList<String>();
		for(int v : tree[i])
			if(v != p)
				childrenRep.add(getRepresentation(tree, v, i));
		Collections.sort(childrenRep);
		StringBuilder ret = new StringBuilder("(");
		for(String s : childrenRep)
			ret.append(s);
		ret.append(")");
		return ret.toString();
	}

}
