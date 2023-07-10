



import java.io.*;
import java.util.*;




public class FloodFillLand {
	
	
    static int n;
    static int m;
    static char grid[][];
    static boolean vis[][];
    static final int dx[] = new int[] {-1, 1, 0, 0};
    static final int dy[] = new int[] {0, 0, -1, 1};
    public static boolean isValid(int i, int j) {
    	boolean isValid = i>=0 && i<n && j>=0 && j<m && grid[i][j] !='#';
    	return isValid;
    }
    public static void dfs(int i, int j) {
    	vis[i][j] = true;
    	for(int k=0 ; k<4 ; k++) {
    		int newI = i + dx[k];
    		int newJ = j + dy[k];
    		if(isValid(newI, newJ) && !vis[newI][newJ]) {
    			dfs(newI, newJ);
    		}
    	}
    }
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][];
        for(int i=0 ; i<n ; i++) {
        	grid[i] = sc.next().toCharArray();
        }
        vis = new boolean[n][m];
        int cnt = 0;
        
        //O(n*m)
        for(int i=0 ; i<n ; i++) {
        	for(int j=0 ; j<m ; j++) {
        		if(!vis[i][j] && grid[i][j] !='#') {
        			cnt++;
        			dfs(i, j);
        		}
        	}
        }
        pw.println(cnt);
        

        pw.flush();
        pw.close();
    }

    static Scanner sc;
    static PrintWriter pw;

}









