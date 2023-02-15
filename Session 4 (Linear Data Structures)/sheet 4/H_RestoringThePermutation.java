import java.util.*;
import java.io.*;
public class H_RestoringThePermutation{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int tt = sc.nextInt();
        while(tt-->0) {
            int n = sc.nextInt();
            int[] arr = sc.nextIntArray(n);
            int[] res1 = new int[n];
            int[] res2 = new int[n];
            res1[0] = res2[0] = arr[0];
            Stack<Integer> st = new Stack<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < arr[0]; i++) {
                st.push(i);
                q.add(i);
            }
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    res1[i] = q.poll();
                    res2[i] = st.pop();
                } else {
                    res1[i] = res2[i] = arr[i];
                    for (int j = arr[i - 1] + 1; j < arr[i]; j++) {
                        st.push(j);
                        q.add(j);
                    }
                }
            }
            for (int x : res1)
                pw.print(x + " ");
            pw.println();
            for (int x : res2)
                pw.print(x + " ");
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