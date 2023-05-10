import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Problem link: https://codeforces.com/contest/129/problem/B
public class Students_and_Shoelaces {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw= new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] adjList= new ArrayList[n];
        for(int i =0;i<n;i++){
            adjList[i]=new ArrayList<>();
        }

        while (m-->0){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            adjList[a].add(b);
            adjList[b].add(a);
        }
        int groupsCount=0;
        while (true){
            ArrayList<Integer>group= new ArrayList<>();

            for(int  i =0;i<n;i++){
                if(adjList[i].size()==1){
                    group.add(i);
                }
            }

            for(int i =0;i<group.size();i++){  // 2--3 group[2,3] i=0 u=2,v=3 --> adj[2]=empty adj[3]=empty
                int u = group.get(i); //student connected b one other student
                if(adjList[u].size()==0)continue;
                int v = adjList[u].get(0);
                adjList[u]=new ArrayList<>();
                adjList[v].remove(new Integer(u));
            }

            if(group.size()==0)break;
            groupsCount++;
        }
        pw.println(groupsCount);
        pw.close();

    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public long[] nextlongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public Long[] nextLongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }


        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}
