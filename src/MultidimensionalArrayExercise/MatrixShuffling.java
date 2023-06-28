package MultidimensionalArrayExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        String[][] matrix = readMatrix(rows,scanner,cols);

        String input2 = scanner.nextLine();
        while(!input2.equals("END")){
            if(isCommandValid(input2)){
                int firstRow = Integer.parseInt(input2.split("\\s+")[1]);
                int firstCol = Integer.parseInt(input2.split("\\s+")[2]);
                int secondRow = Integer.parseInt(input2.split("\\s+")[3]);
                int secondCol = Integer.parseInt(input2.split("\\s+")[4]);
                if(isValidCell(firstRow,firstCol,matrix) && isValidCell(secondRow,secondCol,matrix)){
                    String firstCell = matrix[firstRow][firstCol];
                    String secondCell = matrix[secondRow][secondCol];
                    matrix[firstRow][firstCol] = secondCell;
                    matrix[secondRow][secondCol] = firstCell;

                    for (String[] ints : matrix) {
                        for (String anInt : ints) {
                            System.out.print(anInt + " ");
                        }
                        System.out.println();
                    }

                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }







            input2 = scanner.nextLine();
        }





    }

    private static boolean isValidCell(int firstRow, int firstCol, String[][] matrix) {
        return  firstRow >=0 && firstRow < matrix.length && firstCol >= 0 && firstCol < matrix[firstRow].length;
    }

    private static boolean isCommandValid(String input2) {
        String[] commandParts = input2.split("\\s+");
        if(!commandParts[0].equals("swap")){
            return false;
        }

        if(commandParts.length != 5){
            return false;
        }



        return true;
    }

    private static String[][] readMatrix(int rows, Scanner scanner, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String rowContain = scanner.nextLine();
            matrix[i] = rowContain.split("\\s+");
        }
        return matrix;
    }


}
