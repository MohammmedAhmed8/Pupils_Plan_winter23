import java.util.*;
import java.io.*;
public class D_EscapeTheMaze {
    static ArrayList<Integer> graph[];
    static HashSet<Integer> hs;
    static int[] dis1 , dis2;
    static void dfs(int u , int p){
        if(graph[u].size() == 1 && u != 0) hs.add(u);
        for(int v : graph[u]){
            if(v == p)continue;
            dis1[v] = dis1[u] + 1;
            dfs(v , u);
        }
    }
    public static void main(String[] args) throws IOException {
        int tc = sc.nextInt();
        while(tc-- > 0){
            int n = sc.nextInt() , k = sc.nextInt();
            int[] a = sc.nextIntArray(k);
            graph = new ArrayList[n];
            dis1 = new int[n];
            dis2 = new int[n];
            hs = new HashSet<>();
            for(int i = 0 ; i < n ; i++)graph[i] = new ArrayList<>();
            for(int i = 0 ; i < n - 1 ; i++){
                int u = sc.nextInt() - 1 , v = sc.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            dfs(0 , -1);
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[n];
            for(int i=0; i<k ;i++){
                q.add(a[i]-1);
                vis[a[i]-1] = true;
            }
            while(!q.isEmpty()) {
                int u = q.poll();
                for(int v : graph[u]){
                    if(!vis[v]){
                        vis[v] = true;
                        dis2[v] = dis2[u] + 1;
                        q.add(v);
                    }
                }
            }
            boolean ok = false;

            for(int x : hs)
                ok |= dis1[x] < dis2[x];
            pw.println(ok ? "YES" : "NO");
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