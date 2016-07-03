package DP;

import java.util.HashSet;

/**
 * Created by Kumar_Garg on 7/1/2016.
 */
public class Knapsack {
    public static void main(String[] args) {
        int X = 6;
        int v[] = {3, 4, 2, 4};
        int w[] = {4, 2, 3, 3};

        // int w[] = {10, 15, 25};
        // int v[] = {10, 65, 50};

        int A[][] = new int[w.length+1][X+1];

        for (int i = 1; i <= w.length; i++) {
            for (int j = 0; j <= X; j++) {
                if (w[i-1] > X || j < w[i-1]) A[i][j] = A[i-1][j];
                else A[i][j] = Math.max(A[i-1][j], A[i-1][j-w[i-1]] + v[i-1]);
            }
        }

        System.out.println(A[w.length][X]);

        int index = 0;
        HashSet<Integer> kItems = new HashSet<>();
        for (int i = w.length; i > 0; i--) {
            if (A[i][X-index] == A[i-1][X-index]) continue; // This item is not considered
            else {
                kItems.add(i);
                index += w[i-1];
            }
        }

        System.out.println(kItems);
    }
}
