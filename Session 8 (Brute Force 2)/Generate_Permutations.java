import java.io.*;
import java.util.*;
public class Generate_Permutations {

	static int n;
	static int arr[];
	
	//generating all permutations and store result in array
	public static void genPerms(int idx, int mask, int res[]) {
		if(idx == n) {  //base case (leaf of recursion tree)
			for(int i=0 ; i<n ; i++) {
				pw.print(res[i]+" ");
			}
			pw.println();
			return;
		}
		for(int i=0 ; i<n ; i++) {
			if((mask&(1<<i)) == 0) {
				res[idx] = arr[i];
				genPerms(idx+1, mask|(1<<i), res);
			}
		}
	}
	
	//generate all permutations and store result in LinkedList
	public static void genPerms(int idx, int mask, LinkedList<Integer> res) {
		if(idx == n) { 
			for(int x : res)
				pw.print(x+ " ");
			pw.println();
			return;
		}
		for(int i=0 ; i<n ; i++) {
			if((mask&(1<<i)) == 0) {
				res.add(arr[i]);
				genPerms(idx+1, mask|(1<<i), res);
				res.pollLast();
			}
		}
	}
	
	//generate all distinct permutations of an array eg {1, 2, 2, 3}
	public static void genPermsWithRepitition(int idx, int mask, int res[]) {
		if(idx == n) {  //base case
			for(int x : res)
				pw.print(x+ " ");
			pw.println();
			return;
		}
		HashSet<Integer> hs = new HashSet();
		for(int i=0 ; i<n ; i++) {
			if((mask&(1<<i)) == 0 && !hs.contains(arr[i])) {
				hs.add(arr[i]);
				res[idx] = arr[i];
				genPermsWithRepitition(idx+1, mask|(1<<i), res);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0 ; i<n ; i++)
			arr[i] = sc.nextInt();
		
		genPerms(0, 0, new int[n]);
		genPerms(0, 0, new LinkedList());
		genPermsWithRepitition(0, 0, new int[n]);
		
		pw.flush();
		
	}
	
	static Scanner sc;
	static PrintWriter pw;
}
