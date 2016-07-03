package Maths;

/**
 * Created by kumar_garg on 7/2/16.
 */
public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(270, 192));
    }
}
