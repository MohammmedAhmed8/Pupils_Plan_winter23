import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class H_TheChildAndSet {

    static int get(int x){
        int ans = 1;
        while(x%2 == 0){
            x /= 2;
            ans *= 2;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int s = sc.nextInt() , limit = sc.nextInt();
        ArrayList<int[]> arr = new ArrayList<>();
        long sum = 0;
        for(int i=0; i<limit ;i++){
            int lowBit = get(i+1);
            sum += lowBit;
            arr.add(new int[]{i+1 , lowBit});
        }
        if(sum < s){
            pw.println(-1);
        }
        else{
            ArrayList<Integer> ans = new ArrayList<>();
            Collections.sort(arr , (x,y)-> (y[1] - x[1]));
            for(int[] a : arr){
                if(s - a[1] >= 0) {
                    ans.add(a[0]);
                    s -= a[1];
                }
            }
            pw.println(ans.size());
            for(int x : ans)
                pw.print(x+" ");
        }
        pw.close();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public Scanner(String s) throws FileNotFoundException {	br = new BufferedReader(new FileReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }

}