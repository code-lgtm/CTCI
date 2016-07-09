package misc;

/**
 * Created by Kumar_Garg on 7/9/2016.
 */
public class ProductArray {
    public static void main(String[] args) {
        int arr[] = {6, 7, 4, 3};

        for(int i :product(arr))
            System.out.print(i + " ");
    }

    private static int[] product(int[] arr) {
        int length = arr.length;
        int result[] = new int[arr.length];

        int product = 1;
        for (int i = 0; i < length; i++) {
            result[i] = product;
            product *= arr[i];
        }

        product = 1;
        for (int i = length-1; i >=0; i--) {
            result[i] *= product;
            product *= arr[i];
        }

        return result;
    }
}
