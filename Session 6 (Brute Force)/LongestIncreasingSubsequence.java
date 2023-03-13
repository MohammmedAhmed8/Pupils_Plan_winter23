import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {
	
	static int n;
	static int []arr;
	public static int LIS(int idx, int last){
		if(idx == n){
			return 0;
		}
		int leave = LIS(idx+1, last);
		int take = Integer.MIN_VALUE;
		if(last == -1 || arr[idx]>=arr[last])
			take = LIS(idx+1, idx) +1;
		return Math.max(leave, take);
	}
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		
		n = 6;
		arr = new int[]{1, 2, 7, 4, 5, 6};
		pw.println(LIS(0, -1));
		//last =-1 implies that no element has been taken so far
		
		
		
		
		pw.flush();
	}

	static Scanner sc;
	static PrintWriter pw;

}