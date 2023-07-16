import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class F_TheNumberOfImposters {
    static ArrayList<Integer>[] graph;
    static int n , m , crewmate ,  imposter;
    static int[] vis;
    public static boolean checkBipartite(int src) {
        Queue<Integer> q = new LinkedList();
        q.add(src);
        vis[src] = 0;
        crewmate = 0;
        imposter = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur < n){
                if(vis[cur] == 0)
                    crewmate++;
                else
                    imposter++;
            }
            for(int nxt : graph[cur]) {
                if(vis[nxt] == 2) {
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
    public static void main(String[] args) throws IOException {
        int tc = sc.nextInt();
        while(tc-->0) {
            n = sc.nextInt();
            m = sc.nextInt();
            graph = new ArrayList[n+m];
            for(int i=0; i<n+m ;i++) graph[i] = new ArrayList<>();
            int fake = n , ans = 0;
            for(int i=0; i<m; i++){
                int u = sc.nextInt() - 1 , v = sc.nextInt() - 1;
                String s = sc.next();
                if(s.equals("crewmate")){
                    graph[u].add(fake);
                    graph[fake].add(u);
                    graph[v].add(fake);
                    graph[fake].add(v);
                    fake++;
                }
                else{
                    graph[u].add(v);
                    graph[v].add(u);
                }
            }
            vis = new int[n+m];
            Arrays.fill(vis, 2);
            boolean ok = true;
            for(int i=0; i<n ;i++){
                if(vis[i] == 2){
                    ok &= checkBipartite(i);
                    ans += Math.max(crewmate , imposter);
                }
            }
            if(ok)
                System.out.println(ans);
            else
                System.out.println(-1);
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