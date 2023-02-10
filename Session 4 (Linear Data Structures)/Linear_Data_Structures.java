import java.util.*;
import java.io.*;
public class Linear_Data_Structures{
    static Scanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        // nextMin Problem
        nextMin();

        //Subset Problem
        SubsetProblem();

        // Some bits operations
        int x = sc.nextInt() , i = sc.nextInt();
        setBit(x , i);
        toggleBit(x , i);
        getBit(x , i);

        pw.flush();
    }

    static void nextMin() {

//        Given an array, print the Next Smaller Element (NSE) for every element.
//        The NSE for an element x is the first smaller element on the right side of x in the array.
//        Elements for which no smaller element exist (on the right side), consider NSE as -1.

        int[] a = {1, 3, 2, 5, 10, 4};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < a.length; i++) { // O(2*n)
            int curElement = a[i];
            System.out.println("Before: " + curElement + " " + stack);
            while (!stack.isEmpty() && a[stack.peek()] > curElement)
                res[stack.pop()] = curElement;
            System.out.println("After : " + stack);
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }

    static void SubsetProblem(){

        // Given an array of integers and a number x,
        // can determine if there is a subset of the array that has a sum equals to x?

        // A subset of an array can be formed by choosing some (may be 0, 1, 2, ... or equal to size of the array) elements out of all the possible array elements,
        // in the same order in which they appear in the original array.

        int[] a = {5, 3, 10, 2, 1};
        int size = a.length;
        int x = 8;
        for(int mask = 0; mask < (1 << size); mask++){ // O(2 power n)
            int curSum = 0;
            for(int idx = 0; idx < size; idx++){ // O(n)
                if(getBit(mask, idx)){
                    curSum += a[idx];
                }
            }
            if(curSum == x){
                System.out.println("Ok " + mask + " " + Integer.toBinaryString(mask));
            }
        }
    }

    static int setBit(int x, int i){
        // sets the i-th bit of an integer to 1.
        x |= (1 << i);
        return x;
    }

    static int toggleBit(int x, int i){
        // flips the i-th bit of an integer.
        x ^= (1 << i);
        return x;
    }

    static boolean getBit(int x, int i){
        // checks whether the i-th bit of a number is one.
        return (x & (1 << i)) != 0;
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
