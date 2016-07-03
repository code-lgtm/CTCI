package MST;

/**
 * Created by Kumar_Garg on 6/24/2016.
 */
public class MinPQ<Key extends Comparable<Key>> {
    private final Key keys[];
    private int N;

    MinPQ(int capacity) {
        this.keys = (Key [])new Comparable[capacity+1];
    }

    public void insert(Key key) {
        keys[++N] = key;
        swim(N);
    }

    public Key deleteMin() {
        Key key = keys[1];
        exch(1, N--);
        sink(1);
        keys[N+1] = null;
        return key;
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
            if (j < N && less(j+1, j)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        Key temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

    private boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0 ;
    }

    public static void main(String[] args) {
        MinPQ minPQ = new MinPQ(10);

        minPQ.insert(5);
        minPQ.insert(3);
        minPQ.insert(7);
        minPQ.insert(9);
        minPQ.insert(1);
        minPQ.insert(8);

        System.out.println(minPQ.deleteMin());
        System.out.println(minPQ.deleteMin());
        System.out.println(minPQ.deleteMin());
        System.out.println(minPQ.deleteMin());
        System.out.println(minPQ.deleteMin());
        System.out.println(minPQ.deleteMin());
    }
}