package Maths;

/**
 * Created by kumar_garg on 7/2/16.
 */
public class FastModuloExp {
    public static long fastExponentiation(int A, int B, int M) {
        // Convert B to binary
        String bin = toBinary(B);
        // System.out.println(bin);
        long[] numbers = new long[bin.length()];

        numbers[0] = A % M;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = (numbers[i-1]) * (numbers[i-1]) % M;
        }

//        for (int i = 0; i < numbers.length; i++)
//            System.out.print(numbers[i] + " ");
//         System.out.println();

        long prod = 1L;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                prod = (prod * numbers[i]) % M;
            }
        }

        return prod;
    }

    public static String toBinary(int num) {
        if (num == 0) return "0";
        StringBuffer output = new StringBuffer();

        while(num > 0)
        {
            if(num%2 == 1) output.append("1");
            else output.append("0");
            num /= 2;
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // System.out.println(fastExponentiation(5, 117, 19));
        long before = System.nanoTime();
        long output = fastExponentiation(71045970, 41535484, 64735492);
        long after = System.nanoTime();

        System.out.println(after-before);
        System.out.println(output);

    }
}
