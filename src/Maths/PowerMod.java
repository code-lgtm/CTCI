package Maths;

/**
 * Created by kumar_garg on 7/20/2016.
 */
public class PowerMod {
    public static int powmod(int x, int n, int d) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        long temp = powmod(x, n/2, d) % d;
        long result = 0;
        if(n % 2 == 1)
            result = ((long)(x) % d * temp % d * temp % d) % d;
        else
            result =  (temp % d * temp % d) % d;

        return result < 0 ? (int)(result + d) : (int)result;
    }

    public static void main(String[] args) {
        long before = System.nanoTime();
        long output = powmod(71045970, 41535484, 64735492);
        long after = System.nanoTime();

        System.out.println(after-before);
        System.out.println(output);
    }
}
