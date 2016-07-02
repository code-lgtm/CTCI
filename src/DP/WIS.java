package DP;

import java.util.ArrayList;

/**
 * Created by Kumar_Garg on 6/27/2016.
 */
public class WIS {
    public static void main(String[] args) {
        int a[] = {1, 4, 5, 4};
        int A[] = new int[a.length+1];

        A[0] = 0;
        A[1] = a[0];

        for(int i = 1; i < a.length; i++)
            A[i+1] = Math.max(A[i], A[i-1] + a[i]); // Dynamic Programming
        System.out.println(A[a.length]);

        ArrayList<Integer> path = new ArrayList<>(a.length/2);
        // Get Path
        for (int i = a.length; i > 0; i--) {
            if (A[i-1] >= A[i])
                continue;
            else {
                path.add(i-1);
                i -= 1;
            }
        }

        System.out.println(path);

    }
}
