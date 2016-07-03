package CTCI_Questions;

/**
 * Created by kumar_garg on 7/3/16.
 *
 * Normal Binary Search:
 * Check with the element in the middle
 *
 *
 */
public class ShiftedArray {
    public static boolean binarySearch(int[] arr, int key, int lo, int hi) {
        if (lo > hi) return false;
        if(lo == hi) return arr[lo] == key ;

        int mid = (hi + lo) / 2;
        if (key < arr[mid])
            return binarySearch(arr, key, lo, mid-1);
        else if(key > arr[mid])
            return binarySearch(arr, key, mid+1,  hi);

        return true;
    }

    /*
    * 1. mid element would be shifted by offset
    * 2. So let's say array is 3 1 2 - offset is 1
    * 3. if we have to find 3 it will go like this
     *        -- olo = 0, ohi = 2
     *        -- lo = (olo + offset) % length of array
     *        -- hi = (ohi + offset) % length of array
     *        -- oMid = (olo + ohi) / 2 = 1
     *        -- mid = (oMid + offset) % length of array = 2
     *        -- key > arr[mid]
     *        -- call again with  omid+1 = 2, ohi = 2
     *        -- 2, 2
     */
    public static boolean shiftedBinarySearch(int[] arr, int key, int lo, int hi, int offset) {
        if (lo > hi) return false;

        int len  = arr.length;
        int slo = (lo + offset) % len;
        int shi = (hi + offset) % len;
        if (slo == shi) return arr[slo] == key;


        int mid = (lo + hi) / 2;
        int smid = (mid + offset) % len;

        if (key < arr[smid]) return shiftedBinarySearch(arr, key, lo, mid - 1, offset);
        else if (key > arr[smid]) return shiftedBinarySearch(arr, key, mid + 1, hi, offset);

        return true;
    }

    public static int offset(int arr[], int lo, int hi) {
        if(lo > hi) return -1;
        int mid = (lo + hi) / 2;

        if (arr[mid] < arr[mid-1]) return mid;
        if (arr[mid] > arr[0]) return offset(arr, mid+1, hi);
        return offset(arr, lo, mid-1);
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 7, 9, 10};
        int arr1[] = {2, 3, 7, 9, 10, 1};

        int offset = offset(arr1, 0, arr1.length-1);
        System.out.println(offset);

        // Edge Cases
        assert binarySearch(arr, 1, 0, arr.length-1) : 1;
        assert binarySearch(arr, 10, 0, arr.length-1) : 10;

        // Element not in the array
        assert binarySearch(arr, 15, 0, arr.length-1) == false : 15;
        assert binarySearch(arr, -3, 0, arr.length-1) == false : -3;

        // Element in the middle position in the array
        assert binarySearch(arr, 3, 0, arr.length-1) : 3;
        assert binarySearch(arr, 7, 0, arr.length-1) : 7;

        // Element in left to middle position of the array
        assert binarySearch(arr, 2, 0, arr.length-1) : 2;

        // Element in right to middle position of the array
        assert binarySearch(arr, 9, 0, arr.length-1) : 9;

        // Edge Cases
        assert shiftedBinarySearch(arr1, 1, 0, arr.length-1, offset) : 1;
        assert shiftedBinarySearch(arr1, 10, 0, arr.length-1, offset) : 10;

        // Element not in the array
        assert shiftedBinarySearch(arr1, 15, 0, arr.length-1, offset) == false : 15;
        assert shiftedBinarySearch(arr1, -3, 0, arr.length-1, offset) == false : -3;

        // Element in the middle position in the array
        assert shiftedBinarySearch(arr1, 3, 0, arr.length-1, offset) : 3;
        assert shiftedBinarySearch(arr1, 7, 0, arr.length-1, offset) : 7;

        // Element in left to middle position of the array
        assert shiftedBinarySearch(arr1, 2, 0, arr.length-1, offset) : 2;

        // Element in right to middle position of the array
        assert shiftedBinarySearch(arr1, 9, 0, arr.length-1, offset) : 9;

    }
}
