



import java.io.*;
import java.util.*;




public class TopologicalSort {
	
    static int n;
    static ArrayList<Integer> adjL[];
    static int vis[];
    static boolean isCyclic;
    static Stack<Integer> st;
    public static void toposort() {
        vis = new int[n];
        //0 --> unvisited
        //1 --> partially visited
        //2 --> totally visited
        isCyclic = false;
        st = new Stack();
        for(int i=0 ; i<n ; i++) {
        	if(vis[i]==0) {
        		dfs(i);
        	}
        }
    }
    public static void dfs(int cur) {
    	vis[cur] = 1;
    	for(int nxt : adjL[cur]) {
    		if(vis[nxt] == 2)
    			continue;
    		if(vis[nxt] == 1) {
    			isCyclic = true;
    			return;
    		}
    		dfs(nxt);
    	}
    	st.push(cur);
    	vis[cur] = 2;
    }
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        n = sc.nextInt();
        int m = sc.nextInt();
        adjL = new ArrayList[n];
        for(int i=0 ; i<n ; i++)
        	adjL[i] = new ArrayList();
        for(int i=0 ; i<m ; i++) {
        	int u = sc.nextInt()-1;
        	int v = sc.nextInt()-1;
        	adjL[u].add(v);
        }
        toposort();
        pw.println(isCyclic);
        if(!isCyclic) {
        	while(!st.isEmpty()) {
        		pw.print((st.pop()+1) +" ");
        	}
        	pw.println();
        }
        

        pw.flush();
        pw.close();
    }


    static Scanner sc;
    static PrintWriter pw;

}









