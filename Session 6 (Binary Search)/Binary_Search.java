package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binary_Search {
    // Things covered in today's session:
    // 1. Get the index of a given element
    // 2. Get the first occurence of a given element
    // 3. Get the last occurence of a given element
    // 4. Get the number of elements < a specific value

    // -------------------------------------------- Iterative Implementation -------------------------------------------

    static int binarySearch(int [] a, int x){ // all unique
        int l = 0;
        int r = a.length-1;
        int ans=-1;
        while(l<=r){
            int mid =(l+r)/2;
            if(a[mid]==x)return mid;
            if(a[mid]<x){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }

    // First occurence of an element in an array
    static int binarySearchFirstOcc(int [] a, int x){
        int l = 0;
        int r = a.length-1;
        int ans=-1;
        while(l<=r){
            int mid =(l+r)/2;
            if(a[mid]<x){
                l=mid+1;
            }else { // a[mid]>=x
                if(a[mid]==x)ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }

    // Last occurrnece of an element in an array
    static int binarySearchLastOcc(int [] a, int x){
        int l = 0;
        int r = a.length-1;
        int ans=-1;
        while(l<=r){
            int mid =(l+r)/2;
            if(a[mid]<=x){
                if(a[mid]==x)ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }


    // -------------------------------------------- Recursive Implementation -------------------------------------------

    static int binarySearchRecursion(int [] a, int x, int l , int r){
        int mid = (l+r)/2;
        if(l>r)return -1;
        if(a[mid]==x)return mid;
        if(a[mid]<x)return binarySearchRecursion(a,x,mid+1,r);
        return binarySearchRecursion(a,x,l,mid-1);
    }

    static int binarySearchRecursionFirstOcc(int [] a, int x, int l , int r, int ans){
        int mid = (l+r)/2;
        if(l>r)return ans;
        if(a[mid]>=x){
            if(a[mid]==x)return binarySearchRecursionFirstOcc(a,x,l,mid-1,mid);
            return binarySearchRecursionFirstOcc(a,x,l,mid-1,ans);
        }
        return binarySearchRecursionFirstOcc(a,x,mid+1,r,ans);
    }

    static int binarySearchRecursionLastOcc(int [] a, int x, int l , int r, int ans){
        int mid = (l+r)/2;
        if(l>r)return ans;
        if(a[mid]<=x){
            if(a[mid]==x)return binarySearchRecursionLastOcc(a,x,mid+1,r,mid);
            return binarySearchRecursionLastOcc(a,x,mid+1,r,ans);
        }
        return binarySearchRecursionLastOcc(a,x,l,mid-1,ans);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        // Question :
        // you are given an array of length n (not sorted)
        // and q queries in each query you should print the order of an element when it's sorted if the element is not present print -1
        // Constraints :
        // n --> 10^5
        // q --> 10^5
        // a[i] <= 10^6

        // Solutions for query:
        // Sol 1 --> n*q worst case: 10^10 (looping over all the elements and printing the index when the elements is found)
        // Sol 2 --> q*(log(n)) worst case: 15*10^5 (for each query we will binary search to get the index of the elemnt)
        // Sol 3 --> q*1 worst case: 10^5 (using preprocessing we will calculate the occurence of each element)


        int n = sc.nextInt(); // 10^5
        int [] a = sc.nextIntArray(n); // 12 15 9 6 3 1 18 20
        Arrays.sort(a); // o(nlog(n))
        int q = sc.nextInt(); //10^5

        // for Sol 3 (preprocessing)
        int [] occ = new int [100001];
        Arrays.fill(occ,-1);
        for(int i =0;i<n;i++){
            occ[a[i]]=i;
        }

        while(q-->0){
            int x = sc.nextInt();
            // Sol 1
            int occur=-1;
            for(int i =0;i<n;i++){
                if(a[i]==x){
                    occur=i;
                }
            }
            pw.println(occur);
            // Sol 2
            pw.println(binarySearch(a,x));
            // Sol 3
            pw.println(occ[x]);
        }
        pw.close();

    }

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
