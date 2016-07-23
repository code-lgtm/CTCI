package Maths;

/**
 * Created by kumar_garg on 7/21/2016.
 */
public class BasicModuloExp {
    private static long floorSqrt(long num) {
    /*  We can do: return((int)pow(num, 0.5));
        Or, we can use logs
        But that will require math.h
        So here is a solution with iteration:
    */

        long i, j, mul = 0;

        for (i = 0; i <= num / 2; i++) {
            if (i * i <= num)
                mul = i * i;
            else
                break;
        }

        return i - 1;
    }

    public static void main(String[] args) {
        long before = System.nanoTime();
        long output = floorSqrt(2147482647L);
        long after = System.nanoTime();

        System.out.println(after - before);
        System.out.println(output);
    }
}
