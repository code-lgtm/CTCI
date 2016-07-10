package Sorting;

/**
 * Created by kumar_garg on 7/10/16.
 */
public class MergeSort {
    public static void mergeSort(Comparable a[], Comparable aux[], int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void merge(Comparable a[], Comparable aux[], int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        int k = lo;
        while (k <= hi) {
            if (i > mid) aux[k++] = a[j++];
            else if (j > hi) aux[k++] = a[i++];
            else if (a[i].compareTo(a[j]) < 0) aux[k++] = a[i++];
            else aux[k++] = a[j++];
        }

        for (k = lo; k <= hi; k++)
            a[k] = aux[k];
    }

    public static void main(String[] args) {
        Integer arr[] = {15, 24, 13, 21, 7};
        Integer aux[] = new Integer[arr.length];

        mergeSort(arr, aux, 0, arr.length-1);
        for (int i : arr)
            System.out.println(i);
    }
}
