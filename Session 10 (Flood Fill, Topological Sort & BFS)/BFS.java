



import java.io.*;
import java.util.*;




public class BFS {
	
	
    static int n;
    static ArrayList<Integer> adjL[];
    static int dist[];
    static int par[];
    public static void bfs(int src) {
    	Queue<Integer> q = new LinkedList();
    	boolean vis[] = new boolean[n];
    	dist = new int[n];
    	par = new int[n];
    	q.add(src);
    	vis[src] = true;
    	dist[src] = 0; //for illustration
    	par[src] = -1;
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		pw.print((cur+1) + " ");
    		for(int nxt : adjL[cur]) {
    			if(!vis[nxt]) {
    				q.add(nxt);
    				vis[nxt] = true;
    				dist[nxt] = 1 + dist[cur];
    				par[nxt] = cur;
    			}
    		}
    	}
    }
    public static LinkedList<Integer> getPath(int dest){
    	LinkedList<Integer> path = new LinkedList();
    	while(dest != -1) {
    		path.addFirst(dest+1);
    		dest = par[dest];
    	}
    	return path;
    }
    
    public static boolean checkBipartite() {
    	Queue<Integer> q = new LinkedList();
    	int vis[] = new int[n];
    	Arrays.fill(vis, 2);
    	q.add(0);
    	vis[0] = 0;
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for(int nxt : adjL[cur]) {
    			if(vis[nxt]==2) {
    				q.add(nxt);
    				vis[nxt] = 1 - vis[cur];
    			}
    			else {
    				if(vis[nxt] == vis[cur])
    					return false;
    			}
    		}
    	}
    	return true;
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
        	adjL[v].add(u);
        }
        
//        bfs(0);
//        pw.println();
//        pw.println(Arrays.toString(dist));
//        pw.println(getPath(4));
        
//        pw.println(checkBipartite());
        pw.flush();
        pw.close();
    }


    static Scanner sc;
    static PrintWriter pw;

    

}









