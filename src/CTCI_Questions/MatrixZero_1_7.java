package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/22/2016.
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 */
public class MatrixZero_1_7 {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 4, 5},
                {5, 6, 7},
                {1, 8, 9}
        };

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int zRow = 0;
        int zColumn = 0;
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < columns; j++) {
                if(matrix[i][j] == 0) {
                    zRow |= (1 << i);
                    zColumn |= (1 << j);
                }
            }
        }

        for (int i = 0; i < 32; i++) {
            if ((zRow & (1<<i)) != 0) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < 32; j++) {
            if ((zColumn & (1<<j)) != 0) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/*
* 1. Check if element in a row is zero.
* 2. Store that in an integer with row
* 3. Similarly Store that for a column
*/