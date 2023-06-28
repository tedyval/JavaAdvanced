package MultidimensionalArrayExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(size,scanner);
        int sumOfFirst = getSumOfPrimeDiagonal(matrix);
        int sumOfSecond = getSumOfSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumOfSecond - sumOfFirst));




    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(j == matrix.length - i - 1 ){
                    sum += matrix[i][j];
                }
            }
        }
        return  sum;
    }

    private static int getSumOfPrimeDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j){
                    sum += matrix[i][j];
                }
            }
        }
        return  sum;
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
