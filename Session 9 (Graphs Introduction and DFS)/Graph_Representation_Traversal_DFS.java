import java.util.ArrayList;
import java.util.Scanner;

public class Graph_Representation_Traversal_DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Graph Representation

        //Taking input: number of nodes(n) and number of edges(e).
        int n = sc.nextInt();
        int e = sc.nextInt();

        // 1. Adjacency Matrix
        int [][] adjMat = new int[n][n];

        // 2. Adjacency List
        ArrayList<Integer>[]adjList = new ArrayList[n];
        for(int i =0;i<n;i++){
            adjList[i]=new ArrayList();
        }

        // 3. Edge List
        ArrayList<Edge>edgeList = new ArrayList();

        //Taking input: the edges in the graph
        while (e-->0){
            int u = sc.nextInt()-1; // we dec by one to handle zero index
            int v = sc.nextInt()-1;
//            int c = sc.nextInt(); // if the edge will have weight/cost

            // Filling the adjacency matrix
            adjMat[u][v]=1;  // if we are considering a weigted graph then it will be adjMat[u][v]=c;
//            adjMat[v][u]=1; // if we are considering an undirected graph


            // Filling the adjacency list
            adjList[u].add(v);
//            adjList[v].add(u) // if we are considering an undirected graph
            // Note: if the graph is weighted then the ArrayList should be of type Pair (node a, cost c)

            // Filling the edge list
            edgeList.add(new Edge(u,v));
        }

    }


    //------------------------------------------ Traversal using DFS ---------------------------------------------------
    static boolean []vis;
    static ArrayList<Integer>[]adjList;
    static void dfsList(int node){ // dfs using adjacency list O(E+V)
        vis[node]=true;
        for(int x : adjList[node]){
            if(!vis[x]){
                dfsList(x);
            }
        }
    }

    static int [][] adjMat;
    static int n; // number of nodes
    static void dfsMat(int node){ // dfs using adjacency matrix O(V*V)
        vis[node]=true;
        for(int x =0;x<n;x++){
            if(!vis[x]&&adjMat[node][x]!=0){
                dfsMat(x);
            }
        }
    }

    static class Edge{
        int u;
        int v;
        Edge(int u , int v){
            this.u=u;
            this.v=v;
        }
    }
}
