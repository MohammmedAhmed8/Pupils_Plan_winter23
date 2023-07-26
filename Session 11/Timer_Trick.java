import java.util.*;
import java.io.*;
public class Timer_Trick {
    static ArrayList<Integer>[] graph;
    static int timer;
    static int[] t_in , t_out;
    static boolean[] vis;
    static void dfs(int u){
        vis[u] = true;
        t_in[u] = timer++;
        for(int v : graph[u]){
            if(!vis[v]){
                dfs(v);
            }
        }
        t_out[u] = timer++;
    }

    public static void main(String[] args) throws IOException {

        // given a directed tree of n nodes rooted at node 1 and q queries each query consists of two integers u and v
        // we need to find if we can reach v from u in the tree
        // n <= 10^5 , q <= 10^5

        int n = sc.nextInt();
        graph = new ArrayList[n];
        for(int i=0; i<n ;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1 ;i++){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            graph[u].add(v);
        }
        t_in = new int[n];
        t_out = new int[n];
        vis = new boolean[n];
        dfs(0);
        int q = sc.nextInt();
        while(q-- > 0){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            if(t_in[u] < t_in[v] && t_out[u] > t_out[v]){
                pw.println("YES");
            }else{
                pw.println("NO");
            }
        }
        pw.flush();
    }
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String readAllLines(BufferedReader reader) throws IOException {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
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
