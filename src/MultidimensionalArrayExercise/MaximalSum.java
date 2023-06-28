package MultidimensionalArrayExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = readMatrix(rows, scanner);
        int[][] coordinations = new int[3][3];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int thirdCol = j + 2;
                int thirdRow = i + 2;
                if (isThereThirdElement(thirdCol,thirdRow, matrix)) {
                    int sum = 0;
                    for (int k = i; k <= i+2; k++) {
                        for (int l = j; l <= j+2 ; l++) {
                            sum += matrix[k][l];
                            if(maxSum < sum){
                                maxSum = sum;
                                coordinations = new int[][]{
                                        {matrix[i][j],matrix[i][j+1],matrix[i][j+2]},
                                        {matrix[i+1][j],matrix[i+1][j+1],matrix[i+1][j+2]},
                                        {matrix[i+2][j],matrix[i+2][j+1],matrix[i+2][j+2]}
                                };
                            }
                        }
                    }

                }


            }
        }

        System.out.printf("Sum = %d%n",maxSum);
        for (int[] coordination : coordinations) {
            for (int i : coordination) {
                System.out.print(i + " ");
            }
            System.out.println();

        }


    }


    private static boolean isThereThirdElement(int thirdCol , int thirdRow , int[][] matrix) {
        return   thirdRow < matrix.length && thirdCol   < matrix[thirdRow].length ;
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
                matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }
}
