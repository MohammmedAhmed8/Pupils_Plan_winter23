import java.io.*;
import java.util.*;

public class Knapsack {
	
	static int n;
	static int maxW;
	static int[] v;
	static int[] w;
	
	public static int ks(int idx, int remw){
		if(idx == n){
			return 0;
		}
		int leave  = ks(idx+1, remw);
		int take = Integer.MIN_VALUE;
		if(remw-w[idx]>=0)
			take =  ks(idx+1, remw-w[idx]) + v[idx] ;
		
		return Math.max(leave, take);
	}
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		n = 6;
		maxW = 190;
		v = new int[]{50, 50, 64, 46, 50, 5};
		w = new int[]{56, 59, 80, 64, 75, 17};
		pw.println(ks(0, maxW));
		
		
		
		
		pw.flush();
	}

	static Scanner sc;
	static PrintWriter pw;

}