package MultidimensionalArrayLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i]  = Arrays.stream((scanner.nextLine().split(", "))).mapToInt(Integer::parseInt).toArray();
        }


        int sum = 0;
        int maxSum = 0;
        int[][] subMatrix = new int[2][2];
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int leftCorner = matrix[i][j];
                int leftNext = matrix[i][j+1];
                int bottom = matrix[i+1][j];
                int bottomNext = matrix[i+1][j+1];
                sum = leftCorner + leftNext + bottomNext + bottom;

                if(maxSum < sum){
                    maxSum = sum;
                    subMatrix = new int[][]{
                            {leftCorner,leftNext},
                            {bottom,bottomNext}
                    };
                }
            }

        }
        for (int[] ints : subMatrix) {
            for (int c: ints) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);


    }
}
