package CTCI_Questions;

/**
 * Created by kumar_garg on 7/20/2016.
 */
public class BSearch_SquareRoot {
    public static int binSqrt(int A, int low, int high) {
        if(low >= high) return low;

        int mid = (low+high) / 2;
        long squareMid = (long)mid * (long)mid;

        if(squareMid == (long)A)
            return mid;

        long squareMidMinusOne = ((long)(mid-1))*((long)(mid-1));
        long squareMidPlusOne = ((long)(mid+1))*((long)(mid+1));
        if(squareMidMinusOne < (long)A &&  squareMidPlusOne >(long)A) {
            if(squareMid < (long)A)
                return mid;
            else
                return mid-1;
        }

        if(squareMid < (long)A) return binSqrt(A, mid+1, high);
        else return binSqrt(A, low, mid-1);
    }

    public static int Sqrt(int A) {
        return binSqrt(A, 0, A);
    }

    public static void main(String args[]) {
        long before = System.nanoTime();
        long output = Sqrt(2147483647);
        long after = System.nanoTime();

        System.out.println(after-before);
        System.out.println(output);
    }
}
