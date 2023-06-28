package MultidimensionalArrayLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[] coordinatesOfSearchingPoint = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowPoint = coordinatesOfSearchingPoint[0];
        int colPoint = coordinatesOfSearchingPoint[1];

        int value = matrix[rowPoint][colPoint];
        int[][] outputMatrix = new int[rows][matrix[0].length];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                int sum = 0;
                if(matrix[i][j] == value){
                    if(isInBound(i+1,j,matrix) && matrix[i+1][j] != value){
                        sum += matrix[i+1][j];
                    }

                    if(isInBound(i-1,j,matrix) && matrix[i-1][j] != value){
                        sum += matrix[i-1][j];
                    }

                    if(isInBound(i,j+1,matrix) &&  matrix[i][j+1] != value){
                        sum += matrix[i][j+1];
                    }

                    if(isInBound(i,j-1,matrix) && matrix[i][j-1] != value ){
                        sum += matrix[i][j-1];
                    }


                    outputMatrix[i][j] = sum;
                }else{
                    outputMatrix[i][j] = matrix[i][j];
                }
            }

        }

        for (int[] ints : outputMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();

        }


    }

    private static boolean isInBound(int i, int j, int[][] matrix) {
        return i >=0 && i < matrix.length && j >= 0 && j < matrix[i].length;
    }


}
