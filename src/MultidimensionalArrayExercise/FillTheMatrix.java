package MultidimensionalArrayExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parameters = scanner.nextLine().split(", ");
        int size = Integer.parseInt(parameters[0]);
        String patternType = parameters[1];
        int[][] matrix = new int[size][size];
        if(patternType.equals("A")){
            fillMatrixA(matrix);
        }else if(patternType.equals("B")){
           fillMatrixB(matrix);
        }


        

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();

        }


    }

    private static void fillMatrixB(int[][] matrix) {
        int startNumber = 1;
        for (int col= 0; col < matrix.length; col++) {

                if(col % 2 == 0){
                    for (int row = 0; row < matrix.length; row++){
                        matrix[row][col] = startNumber;
                        startNumber++;
                    }
                }else{
                    for (int row =matrix.length - 1 ; row >= 0; row--){
                        matrix[row][col] = startNumber;
                        startNumber++;
                    }
                }

        }
    }


    private static void fillMatrixA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0;  col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
            }
        }


    }


}

