package MST;

/**
 * Created by Kumar_Garg on 6/24/2016.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private Key keys[];
    private int pq[];
    private int qp[];
    private int N;
    private int H;

    public IndexMinPQ(int V) {
        this.keys = (Key []) new Comparable[V];
        this.pq = new int[V+1]; // Index of key in heap position i
        this.qp = new int[V]; // Heap position of key with index i
        this.N = 0;
        this.H = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int deleteMin() {
        int deletedIndex = pq[1];
        //System.out.println(keys[deletedIndex]);
        exch(1, N--);
        sink(1);
        // keys[N+1] = null;
        return deletedIndex;
    }

    public void insert(int i, Key key) {
        keys[i] = key;
        pq[++N] = i;
        qp[i] = N;
        swim(N);
    }

    private void swim(int k) {
        while(k > 1) {
            if (less(k/2, k)) break;
            exch(k, k/2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while(k < N) {
            int j = 2 * k;
            if(j > N) break;
            if (j < N && less(j+1, j)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        int k1 = pq[i];
        int k2 = pq[j];

        // Exhange key indices pointing to heap indices
        qp[k1] = j;
        qp[k2] = i;

        // Exchange heap indices pointing to key indices
        pq[i] = k2;
        pq[j] = k1;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0 ;
    }

    public void decreaseKey(int i, Key key) {
        this.keys[i] = key;
        swim(qp[i]);
    }

    public int size() {
        return N;
    }

    public boolean contains(int i) {
        return keys[i] != null;
    }

    public static void main(String[] args) {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(5);

        minPQ.insert(0, 5);
        minPQ.insert(1, 3);
        System.out.println(minPQ.deleteMin());
        minPQ.insert(2, 7);

        System.out.println(minPQ.deleteMin());
        System.out.println(minPQ.deleteMin());
    }
}
