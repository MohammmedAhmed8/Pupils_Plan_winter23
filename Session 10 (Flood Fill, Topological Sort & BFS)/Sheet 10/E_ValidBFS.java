import java.util.*;
import java.io.*;
public class E_ValidBFS {
    static ArrayList<Integer>[] graph;
    static int[] a;
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        graph = new ArrayList[n];
        for(int i=0; i<n ;i++) graph[i] = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            graph[u].add(v);
            graph[v].add(u);
        }
        a = sc.nextIntArray(n);
        boolean ok = a[0] == 1  ;
        int j = 1;
        boolean[] vis = new boolean[n];
        vis[a[0] - 1] = true;
        for(int i=0; i<n && ok ;i++){
            int u = a[i] - 1;
            HashSet<Integer> hs = new HashSet<>();
            for(int v : graph[u]){
                if(vis[v]) continue;
                vis[v] = true;
                hs.add(v+1);
            }
            while(hs.size() > 0 && j < n){
                if(!hs.contains(a[j])){
                    ok = false;
                    break;
                }
                hs.remove(a[j++]);
            }
            ok &= hs.size() == 0;
        }
        pw.println(ok ? "Yes" : "No");
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