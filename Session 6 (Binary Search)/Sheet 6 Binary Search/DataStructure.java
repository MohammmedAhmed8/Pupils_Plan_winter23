import java.util.*;

public class DataStructure {

    static class FenwickTree {

        //1 - INDEXED
        static class FT1 {
            int tree[];
            int sz;

            final int passive = 0;

            int op(int a, int b) {
                return a + b;
            }

            int rv(int a, int b) {
                return a - b;
            }

            public FT1(int n) {
                tree = new int[n + 5];
                int t = 1;
                sz = 0;
                while (t <= n) {
                    t <<= 1;
                    sz++;
                }
            }

            void rvupdate(int i, int v) {
                while (i <= tree.length) {
                    tree[i] = rv(tree[i], v);
                    i = goup(i);
                }
            }

            //Range Query
            int query(int l, int r) {
                int base1 = passive;
                int base2 = passive;

                while (r > 0) {
                    base1 = op(base1, tree[r]);
                    r = godown(r);
                }

                l--;

                while (l > 0) {
                    base1 = op(base1, tree[l]);
                    l = godown(l);
                }

                return rv(base1, base2);
            }

            //Point Update
            void update(int i, int v) {
                while (i <= tree.length) {
                    tree[i] = op(tree[i], v);
                    i = goup(i);
                }
            }

            //Point Assign
            void assign(int i, int v) {
                int ogv = query(i, i);
                rvupdate(i, ogv);
                update(i, v);
            }

            //Range Update(Using Point Update)
            void rupdate(int l, int r, int v) {
                update(l, v);
                rvupdate(r + 1, v);
            }

            //Point Query(Using Range Query)
            int pquery(int i) {
                return query(1, i);
            }

            //KthElement Query (1 - INDEXED INPUT)
            int kthElm(int k) {
                k--;
                int sum = 0;
                int pos = 0;

                for (int j = sz; j >= 0; j--) {
                    int npos = pos + 1 << j;
                    if (npos <= tree.length && sum + tree[npos] <= k) {
                        sum += tree[npos];
                        pos = npos;
                    }
                }

                return pos + 1;
            }

            int goup(int x) {
                return x + (x & (-x));
            }

            int godown(int x) {
                return x & (x - 1);
            }

        }


        //0 - INDEXED
        static class FT0 {
            int tree[];
            int sz;

            final int passive = 0;

            int op(int a, int b) {
                return a + b;
            }

            int rv(int a, int b) {
                return a - b;
            }

            public FT0(int n) {
                tree = new int[n + 5];
                int t = 1;
                sz = 0;
                while (t < n) {
                    t <<= 1;
                    sz++;
                }
            }

            void rvupdate(int i, int v) {
                while (i < tree.length) {
                    tree[i] = rv(tree[i], v);
                    i = goup(i);
                }
            }

            //Range Query
            int query(int l, int r) {
                int base1 = passive;
                int base2 = passive;

                while (r > -1) {
                    base1 = op(base1, tree[r]);
                    r = godown(r);
                }

                l--;

                while (l > -1) {
                    base1 = op(base1, tree[l]);
                    l = godown(l);
                }

                return rv(base1, base2);
            }

            //Point Update
            void update(int i, int v) {
                while (i < tree.length) {
                    tree[i] = op(tree[i], v);
                    i = goup(i);
                }
            }

            //Point Assign
            void assign(int i, int v) {
                int ogv = query(i, i);
                rvupdate(i, ogv);
                update(i, v);
            }

            //Range Update(Using Point Update)
            void rupdate(int l, int r, int v) {
                update(l, v);
                rvupdate(r + 1, v);
            }

            //Point Query(Using Range Query)
            int pquery(int i) {
                return query(0, i);
            }

            //KthElement Query (0 - INDEXED INPUT)
            int kthElm(int k) {

                int sum = 0;
                int pos = -1;

                for (int j = sz; j >= 0; j--) {
                    int npos = pos + (1 << j);
                    if (npos < tree.length && sum + tree[npos] <= k) {
                        sum += tree[npos];
                        pos = npos;
                    }
                }

                return pos + 1;
            }

            int goup(int x) {
                return x | (x + 1);
            }

            int godown(int x) {
                return (x & (x + 1)) - 1;
            }

        }
    }

    static class SparseTable {
        static class ST {
            int table[][];

            //Adjust k according to N;
            // if N <= 1e6, K should be ~20
            // if N <= 1e7, K should be ~25
            // if N <= 1e9, K should be ~30
            final int k = 25;
            int logs[];

            int op(int a, int b) {
                return Math.min(a, b);
            }

            public ST(int[] nums) {
                int n = nums.length;
                table = new int[k][n];
                logs = new int[n + 1];

                for (int i = 2; i <= n; i++) {
                    logs[i] = logs[i / 2] + 1;
                }

                for (int i = 0; i < n; i++) {
                    table[0][i] = nums[i];
                }

                for (int j = 1; j < k; j++) {
                    for (int i = 0; i - 1 + (1 << j) < n; i++) {
                        table[j][i] = op(table[j - 1][i], table[j - 1][i + (1 << (j - 1))]);
                    }
                }

            }

            int query(int a, int b) {
                int sz = logs[(b - a) + 1];
                return op(table[sz][a], table[sz][b - (1 << sz) + 1]);
            }

        }
    }

    static class SegmentTree{

        int[] arr;
        long[] sTree , lazy;
        int N;

        SegmentTree(int[] a){
            this.arr = a;
            N = a.length-1;
            sTree = new long[2*N];
            build(1 , 1 ,N);
        }

        void build(int node , int l , int r){
            if(l == r)
                sTree[node] = arr[l];
            else{
                int mid = (l+r)/2;
                int left = (node * 2)  , right = node*2+1;
                build(left , l , mid);
                build(right , mid+1 , r);
                sTree[node] = sTree[left] + sTree[right];
            }
        }

        long query(int i , int j){
            return query(1,1,N,i,j);
        }
        long query(int node , int l , int r , int i , int j){
            if(r < i || l > j)
                return 0;
            if(i <= l && r <= j)
                return sTree[node];
            int mid = (l+r)/2;
            propagate(node , l , mid , r);
            long left = query(node<<1 , l , mid , i , j);
            long right = query((node<<1)|1, mid+1 , r , i , j);
            return left + right;
        }

        void updatePoint(int idx, int value) {
            int node = idx + N - 1;
            arr[idx] = value;
            sTree[node] = value;
            while (node > 1) {
                node /= 2;
                int l = 2 * node;
                int r = 2 * node + 1;
                sTree[node] = sTree[l] + sTree[r];
            }
        }
        void updateRange(int i , int j , int value){
            updateRange(1,1,N,i,j,value);
        }
        void updateRange(int node , int l ,int r, int i , int j , int value){
            if(i > r || l > j)
                return;
            if(i <= l && r <= j){
                lazy[node] += value;
                sTree[node] += (long) (r - l + 1) * value;
                return;
            }
            int mid = l+r >> 1;
            int left = node<<1 , right = node<<1|1;
            propagate(node , l , mid , r);
            updateRange(left , l , mid , i , j , value);
            updateRange(right , mid+1 , r , i , j , value);
            sTree[node] = sTree[left] + sTree[right];
        }
        void propagate(int node , int l , int mid ,  int r){
            int left = (node<<1) , right = node<<1|1;
            lazy[left] += lazy[node];
            lazy[right] += lazy[node];
            sTree[left] += lazy[node] * (mid-l+1);
            sTree[right] += lazy[node] * (r-mid);
            lazy[node] = 0;
        }
    }

    static long gcd(long a, long b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a , long b){
        return a*b / gcd(a , b);
    }

    static class tuple implements Comparable<tuple>{
        int x , y , z , i;
        tuple(int x , int y , int z , int i ){
            this.x = x;
            this.y = y;
            this.z = z;
            this.i = i;
        }
        public int compareTo(tuple t){
            if(t.x == this.x){
                if(t.y == this.y)
                    return t.z - this.z;
                return t.y - this.y;
            }
            return t.x - this.x;
        }
        public String toString(){
            return x+" "+y+" "+z;
        }
    }

    static class pair implements Comparable<pair> {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(pair o) {
            return o.x - x;
        }

        public String toString() {

            return x + " " + y;
        }

    }

    static class UnionFind {
        int[] p, rank, setSize;
        int numSets;

        public UnionFind(int N){
            p = new int[numSets = N];
            rank = new int[N];
            setSize = new int[N];
            for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
        }

        public int findSet(int i){
            return p[i] == i ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            if(rank[x] > rank[y]) {
                p[y] = x;
                setSize[x] += setSize[y];
            }
            else {	p[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() {
            return numSets;
        }

        public int sizeOfSet(int i) {
            return setSize[findSet(i)];
        }
    }

    static class DSU {
        LinkedList<Integer>[] allSets;
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            allSets = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                allSets[i] = new LinkedList<>();
                allSets[i].add(i);
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean isSameSet(int i , int j){
            return find(i) == find(j);
        }

        public void join(int x, int y) {
            int a = find(x), b = find(y);
            if (a == b) {
                return;
            }
            if (allSets[a].size() >= allSets[b].size()) {
                while (!allSets[b].isEmpty()) {
                    int cur = allSets[b].poll();
                    parent[cur] = a;
                    allSets[a].add(cur);
                }
            } else {
                while (!allSets[a].isEmpty()) {
                    int cur = allSets[a].poll();
                    parent[cur] = b;
                    allSets[b].add(cur);
                }
            }
        }
    }

    static long pow(long a , long b , int mod){
        long res = 1;
        while(b > 0){
            if((b & 1) != 0) res = (res * a) % mod;
            a = (a * a) % mod;
            b /= 2;
        }
        return res;
    }

    static int cnt = 0 ;

    public static void sort(int[] a){
        Helper(a , 0 , a.length-1);
    }
    public static void Helper(int[] a , int l , int r){
        if(l != r){
            int mid = (l+r)/2;
            Helper(a , l , mid);
            Helper(a , (mid+1) , r);
            merge(a , l , mid , (mid+1) , r);
        }
    }
    public static void merge(int[] a , int l1 , int r1 , int l2 , int r2){
        int[] tmp = new int[r2-l1+1];
        int i = l1 ;
        int j = l2 ;
        int k = 0;
        while(i<=r1 && j<=r2){
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            }
            else {
                cnt += (r1-i + 1);
                tmp[k++] = a[j++];
            }
        }
        while(i <= r1)
            tmp[k++] = a[i++];
        while(j <= r2)
            tmp[k++] = a[j++];
        k = 0;
        for(int l=l1; l<=r2 ;l++){
            a[l] = tmp[k++];
        }
    }

    public static void main(String[] args){
    }
}
