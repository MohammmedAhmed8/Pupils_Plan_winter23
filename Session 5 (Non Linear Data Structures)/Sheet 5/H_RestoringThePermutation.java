import java.util.*;
import java.io.*;
public class H_RestoringThePermutation{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int tt = sc.nextInt();
        while(tt-->0){
            int n = sc.nextInt();
            int[] a = sc.nextIntArray(n);
            TreeSet<Integer> ts = new TreeSet<>();
            for(int i=1; i<=n ;i++) ts.add(i);
            int[] b = new int[n] , c = new int[n];
            for(int i=0; i<n ;i++){
                if(ts.contains(a[i])){
                    b[i] = a[i];
                    c[i] = a[i];
                }
                ts.remove(a[i]);
            }
            TreeSet<Integer> ts2 = new TreeSet<>(ts);
            for(int i=0; i<n ;i++){
                if(b[i] == 0){
                    b[i] = ts.pollFirst();
                    c[i] = ts2.lower(a[i]);
                    ts2.remove(c[i]);
                }
            }
            for(int y : b) pw.print(y+" ");
            pw.println();
            for(int y : c) pw.print(y+" ");
            pw.println();
        }
        pw.flush();
    }
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