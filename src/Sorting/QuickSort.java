package Sorting;

/**
 * Created by kumar_garg on 7/10/16.
 */
public class QuickSort {
    private static void quickSort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) return;

        int left = lo;
        int last = left;
        for (int i = left+1; i <= hi; i++)
            if (a[i].compareTo(a[left]) < 0)
                exch(a, i, ++last);
        exch(a, left, last);
        quickSort(a, lo, last-1);
        quickSort(a, last+1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer arr[] = {15, 24, 13, 21, 7};

        quickSort(arr, 0, arr.length-1);
        for (int i : arr)
            System.out.println(i);
    }
}
