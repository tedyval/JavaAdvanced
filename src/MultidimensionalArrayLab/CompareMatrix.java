package MultidimensionalArrayLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] firstMatrix = readMatrix(rows,scanner,"\\s+");
        int rowsSecond = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] secondMatrix = readMatrix(rowsSecond,scanner,"\\s+");
        boolean isEqual = isEqual(firstMatrix,secondMatrix);
        String output = isEqual ? "equal" : "not equal";
        System.out.println(output);





    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];
            if(firstArr.length != secondArr.length){
                return  false;
            }

            for (int j = 0; j < firstArr.length; j++) {
                if(firstArr[j] != secondArr[j]){
                    return false;
                }
            }

        }
        return true;
    }

    private static int[][] readMatrix(int rows, Scanner scanner,String regexPattern) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(regexPattern)).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        return matrix;
    }

}
