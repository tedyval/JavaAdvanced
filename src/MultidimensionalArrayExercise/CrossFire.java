package MultidimensionalArrayExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;


public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        String[][] matrix = new String[rows][cols];

        int startNumber = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = String.valueOf(startNumber);
                startNumber++;
            }
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("Nuke it from orbit")) {
            int rowCoordinate = Integer.parseInt(input2.split("\\s+")[0]);
            int colCoordinate = Integer.parseInt(input2.split("\\s+")[1]);
            int radiusCoordinate = Integer.parseInt(input2.split("\\s+")[2]);
            int newStartRow = rowCoordinate - radiusCoordinate;
            int newEndRow = rowCoordinate + radiusCoordinate;
            int newStartCol = colCoordinate - radiusCoordinate;
            int newEndCol = colCoordinate + radiusCoordinate;



            for (int i = colCoordinate; ; ) {
                for (int k = newStartRow; k <= newEndRow; k++) {

                    if (isValid(k, i, matrix)) {
                        matrix[k][i] = "x";
                    }

                }
                break;

            }


            for (int i = rowCoordinate; ; ) {
                for (int k = newStartCol; k < newEndCol; k++) {
                    if (isValid(i, k, matrix)) {
                        matrix[i][k] = "x";
                    }
                }
                break;
            }

            ArrayDeque<String> queue = new ArrayDeque<>();
            for (int i = 0; i < matrix.length; i++) {
                String lineToClear = String.join("x",matrix[i]);
                String modification = lineToClear.replaceAll("x","");
                if(!modification.equals("")){
                    queue.offer(lineToClear);
                }

            }

            int lengthMatrix = queue.size();
            String[][] output = new String[lengthMatrix][];
            for (int i = 0; i < lengthMatrix; i++) {
                output[i] = queue.poll().split("x+");
            }

            matrix = output;


            input2 = scanner.nextLine();
        }





        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }


    }

    private static boolean isValid(int k, int j, String[][] matrix) {
        return k >= 0 && k < matrix.length && j >= 0 && j < matrix[k].length;
    }


}
