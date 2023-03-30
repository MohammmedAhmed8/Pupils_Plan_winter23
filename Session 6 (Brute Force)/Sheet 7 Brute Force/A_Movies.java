import java.util.*;
import java.io.*;
public class A_Movies{
    static boolean f;
    static int n , y , z;
    static long[] arr;
    static void tryAll(int idx ,int cnt, long acc){
        if(f) return;
        if(cnt == z){
            if(Long.bitCount(acc) == y)
                f = true;
            return;
        }
        if(idx == n) return;
        tryAll(idx + 1 , cnt + 1 , acc | arr[idx]);
        tryAll(idx + 1 , cnt , acc);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int tt = sc.nextInt();
        while(tt-- > 0){
            n = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            f = false;
            arr = new long[n];
            for(int i=0; i<n ;i++){
                StringBuilder x  = new StringBuilder();
                for(int j=0; j<y ;j++) x.append(sc.nextInt());
                arr[i] = Long.valueOf(x.toString() , 2);
            }
            tryAll(0 , 0 , 0);
            pw.println(f? "YES" : "NO");
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