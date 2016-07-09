package misc;

/**
 * Created by Kumar_Garg on 7/8/2016.
 * Example Array: [1, 2, 6, 8, 9]
 * 1. Array can be shifted by offset less than half the number of elements or greater than half
 * 2. {9, 1, 2, 6, 8} or {2, 6, 8, 9, 1}
 * 3. If shifted less, right array would be sorted mid would be lesser than first element
 * 4. If shifted more left array would be sorted, mid would be greater than first element
 * 5. Left array sorted, if target > first element and < mid element, it lies in the sorted
 *    array
 *
 */
public class ShiftedArray {
    public static void main(String[] args) {
        int arr[] = {9, 1, 2, 6, 8};

        System.out.println(elementExists(arr, 9));
        System.out.println(elementExists(arr, 8));
        System.out.println(elementExists(arr, 6));
        System.out.println(elementExists(arr, 2));
        System.out.println(elementExists(arr, 1));
    }


    public static int elementExists(int arr[], int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target || arr[lo] == target || arr[hi] == target) return 0;

            if (arr[mid] > arr[lo]) {
                // Left array would be sorted
                if(target > arr[lo] && target < arr[mid]) {
                    // Continue with Array Search
                    hi = mid-1;
                }
                else {
                    // It lies in unsorted right portion of the array
                    lo = mid + 1;
                }
            }
            else {
                // right array would be sorted
                if (target > arr[mid] && target < arr[hi]) {
                    lo = mid+1;
                }
                else {
                    hi = mid-1;
                }
            }
        }

        return -1;
    }
}
