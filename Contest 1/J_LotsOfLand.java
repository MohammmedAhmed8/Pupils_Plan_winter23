import java.util.*;
import java.io.*;
public class J_LotsOfLand{

    static void div(int area , int n , int m , char[][] c){
        for(int i=1; i*i <= area ;i++){
            if(area%i == 0){
                if((n%i == 0 && m%(area/i) == 0)){
                    dojob(i , area/i , n , m , c);
                    break;
                }
                else if(m%i == 0 && n%(area/i) == 0){
                    dojob(area/i , i , n , m , c);
                    break;
                }
            }
        }
    }
    static void dojob(int x , int y , int n , int m , char[][] c){
        char a = 'A';
        for(int i=0; i<n ;i+=x){
            for(int j=0; j<m ;j+=y) {
                change(i, j, Math.min(i+x,n), Math.min(j+y,m), c, a);
                a++;
            }
        }
    }
    static void change(int i ,int x , int j , int y , char[][] c , char a){
        while(i<x){
            for(int k=j; k<y ; k++)
                c[i][k] = a;
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt() , m = sc.nextInt() , k = sc.nextInt();
        if((n * m)%k != 0){
            pw.println("IMPOSSIBLE");
        }
        else {
            char[][] c = new char[n][m];
            int area = n * m; area /= k;
            div(area , n , m , c);
            for(int i=0; i<n ;i++)
                pw.println(c[i]);
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