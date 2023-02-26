import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VanyaAndLanterns {

    // This questions can be solved in three ways:
    // Sol 1: Greedy
    // Sol 2: Binary search on radius (double)
    // Sol 3: Binary search on diameter
    static PrintWriter pw ;
    static Scanner sc;
    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        solution1(); // Greedy
        solution2(); // Binary search on radius
        solution3(); // Binary search on diameter
        pw.close();
    }

    // Greedy
    static void solution1() throws IOException {
        int t =1;
        while(t-->0){
            int n = sc.nextInt();
            int l = sc.nextInt();
            int [] a = sc.nextIntArray(n);
            Arrays.sort(a);
            double ans = Math.max(a[0],l-a[n-1]);
            for(int i =0;i<n-1;i++){
                ans=Math.max(ans,1.0*(a[i+1]-a[i])/2.0);
            }
            pw.println(ans);
        }
    }

    // Binary Search on radius
    static void solution2() throws IOException {
        int t = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] a = sc.nextIntArray(n);
            Arrays.sort(a);
            double lo = 0.0;
            double hi = l * 1.0;
            double res = 0.0;
            for (int i = 0; i < 100; i++) {
                double mid = (lo + hi) / 2.0;
                if (checkRadius(a, mid, l)) {
                    res = mid;
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            pw.printf("%.9f", res);
        }
    }
    static boolean checkRadius ( int[] a, double mid, int l){
        boolean res = (1.0 * a[0] <= mid) && 1.0 * (l - a[a.length - 1]) <= mid;
        for (int i = 0; i < a.length - 1; i++) {
            res &= (mid >= ((a[i + 1] - a[i]) / 2.0));
        }
        return res;
    }

    //Binary Search on Diamter
    static void solution3 () throws IOException {
        int t = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] a = sc.nextIntArray(n);
            Arrays.sort(a);
            long lo = 0;
            long hi = l * 2L;
            double res = 0.0;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (checkDiameter(a, mid, l)) {
                    res = (1.0 * mid) / 2;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            pw.println(res);
        }
    }

    static boolean checkDiameter(int[] a, long mid, int l){
        boolean res = (2L * a[0] <= mid) && 2L * (l - a[a.length - 1]) <= mid;
        for (int i = 0; i < a.length - 1; i++) {
            res &= (mid >= (a[i + 1] - a[i]));
        }
        return res;
    }
    // -----------------------------------------------------Scanner---------------------------------------------------------
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


