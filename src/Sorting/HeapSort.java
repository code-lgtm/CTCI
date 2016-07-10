package Sorting;

/**
 * Created by kumar_garg on 7/10/16.
 */
public class HeapSort {
    private int[] pq;
    private int N;

    HeapSort(int maxCapacity) {
        this.pq = new int[maxCapacity+1];
    }


    public void insert(int x) {
        this.pq[++N] = x;
        swim(N);
    }


    public int size() {
        return this.N;
    }

    public int delMin() {
        int min = pq[1];
        exch(1, N--);
        sink(1);
        return min;
    }

    private void swim(int k) {
        while (k > 1) {
            int j = k/2;
            if (pq[j] < pq[k]) break;
            exch(j, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if(j < N && pq[j+1] < pq[j]) j++;
            if (pq[k] < pq[j]) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(5);

        heapSort.insert(5);
        heapSort.insert(3);
        heapSort.insert(4);
        heapSort.insert(1);
        heapSort.insert(2);

        while (heapSort.size() > 0) {
         System.out.println(heapSort.delMin());
        }
    }
}
