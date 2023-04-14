import java.io.*;
import java.util.*;

public class GenerateSubsetsRecursive {
	static int n;
	static int[] arr;
	public static void gen(int idx, int mask){
		if(idx==n){
			for(int j=0 ; j<n ; j++){
				if((mask&(1<<j))!=0){
					pw.print(arr[j]+" ");
				}
			}
			pw.println();
			return;
		}
		gen(idx+1, mask); //leave
		gen(idx+1, mask|(1<<idx)); //take
	}
	public static void gen2(int idx, boolean[] taken){
		if(idx==n){
			for(int j=0 ; j<n ; j++){
				if(taken[j]){
					pw.print(arr[j]+" ");
				}
			}
			pw.println();
			return;
		}
		gen2(idx+1, taken);  //leave
		
		taken[idx] = true;
		gen2(idx+1, taken); //take
		taken[idx] = false;
	}
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		n = 3;
		arr = new int[]{1, 2, 3};
		
		//using mask
		gen(0, 0);
		
		//using boolean array
		gen2(0, new boolean[n]);
		
		
		
		pw.flush();
	}

	static Scanner sc;
	static PrintWriter pw;

}
