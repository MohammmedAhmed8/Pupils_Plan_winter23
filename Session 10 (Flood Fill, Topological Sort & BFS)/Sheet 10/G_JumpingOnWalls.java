import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class G_JumpingOnWalls {
    static char[][] c;
    static boolean[][] vis;

    static boolean bfs(int i , int j , int n , int k){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j , 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0] , y = cur[1] , water = cur[2];
            if(y+1 >= n) return true;
            if(vis[x][y]) continue;
            vis[x][y] = true;
            if(c[x][y+1] != 'X' && !vis[x][y+1]) {
                q.add(new int[]{x,y+1,water+1});
            }
            if(y-1 >= 0 && c[x][y-1] != 'X' && !vis[x][y-1] && water+1 <= y-1)
                q.add(new int[]{x,y-1,water+1});
            if(y+k >= n) return true;
            if(c[1-x][y+k] != 'X' && !vis[1-x][y+k])
                q.add(new int[]{1-x,y+k,water+1});
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        int n = sc.nextInt() , k = sc.nextInt();
        c = new char[2][n];
        vis = new boolean[2][n];
        for(int i=0; i<2 ;i++) c[i] = sc.next().toCharArray();
        if(bfs(0,0,n,k)) pw.println("YES");
        else pw.println("NO");
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
