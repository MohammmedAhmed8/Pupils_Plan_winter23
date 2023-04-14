import java.io.*;
import java.util.*;
public class N_Queens_Problem {
	
	//Here is a nice visualizer of the problem:
	//https://www.cs.usfca.edu/~galles/visualization/RecQueens.html
	
	
	
	static int n;
	static int cols[];
	
	
	//returns false if the cell to be checked lies on a diagonal with any previous cell,
	//otherwise true.
	public static boolean check(int row, int col) {
		for(int i=0 ; i<col ; i++)
			if(Math.abs(col - i) == Math.abs(row-cols[i]))
				return false;
		return true;
	}
	
	public static int cntNQueens(int col, int mask) {
		if(col == n)
			return 1;
		
		int res = 0;
		for(int row = 0; row<n ; row++) {
			if((mask&(1<<row))==0  && check(row, col)) {
				cols[col] = row;
				res += cntNQueens(col+1, mask|(1<<row));
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		n = 8;
		cols = new int[n];
		pw.println(cntNQueens(0, 0));
		
		
		pw.flush();
		
	}
	
	static Scanner sc;
	static PrintWriter pw;
}
