package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/22/2016.
 */
/*
* Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
* the image by 90 degrees. Can you do this in place?
*/
public class RotateImage_1_6 {
    public static void rotate(int[][] matrix, int n) {
        for(int layer = 0;  layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            for (int i = first; i < last; ++i) {
                int top = matrix[first][i];
                int offset = i - first;

                // Left Top
                matrix[first][i] = matrix[last-offset][first];

                // Left Bottom
                matrix[last-offset][first] = matrix[last][last-offset];

                // Right Bottom
                matrix[last][last-offset] = matrix[i][last];

                //Top Right
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] =
        {
            {2, 3, 4, 5},
            {5, 6, 7, 8},
            {8, 9, 2, 3},
            {1, 5, 6, 7}
        };

        rotate(matrix, 4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }


    }
}


/* Input:
*   2 3 4 5
*   5 6 7 8
*   8 9 2 3
*   1 5 6 7
*
*  Expected Output:
*   1 8 5 2
*   5 9 6 3
*   6 2 7 4
*   7 3 8 5
*/