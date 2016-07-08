package Strings;

import java.util.HashMap;

/**
 * Created by Kumar_Garg on 7/7/2016.
 */
public class KeyIndexedCounting {
    public static void main(String[] args) {
        String input = "daabc";
        int a[] = new int[input.length()];

        for (int i = 0; i < input.length(); i++)
            a[i] = input.charAt(i);

        keyIndexedCouting(a, 256);

        for (int i = 0; i < input.length(); i++)
            System.out.print(Character.toString((char) a[i]));
    }

    private static void keyIndexedCouting(int[] a,  int R) {
        int count[] = new int[R + 1];
        int aux[] = new int[a.length];

        for (int i = 0; i < a.length; i++)
            count[a[i]+1]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        for (int i = 0; i < aux.length; i++) {
            aux[count[a[i]]++] = a[i];
        }

        for (int i = 0; i < a.length; i++)
             a[i] = aux[i];
    }
}
