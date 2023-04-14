import java.io.*;
import java.util.*;
public class Generate_Strings_Of_Size_N {

	static int n;
	public static void generate(int idx, char res[]) {
		if(idx == n) {
			pw.println(res);
			return;
		}
		for(char c='a' ; c<='z' ; c++) {
			res[idx] = c;
			generate(idx+1, res);
		}
	}
	
	
	
	public static void main(String[] args) throws Exception{
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		n = sc.nextInt();
		generate(0, new char[n]);
		pw.flush();
		
	}
	
	static Scanner sc;
	static PrintWriter pw;
}
