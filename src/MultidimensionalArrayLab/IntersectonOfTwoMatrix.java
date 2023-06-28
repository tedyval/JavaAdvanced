package MultidimensionalArrayLab;

import java.util.Scanner;

public class IntersectonOfTwoMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows  = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readMatrix(rows,scanner);
        char[][] secondMatrix = readMatrix(rows,scanner);
        char[][] outputMatrix = new char[rows][cols];
        for (int i = 0; i < firstMatrix.length ; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if(firstMatrix[i][j] == secondMatrix[i][j]){
                    outputMatrix[i][j] = firstMatrix[i][j];
                }else{
                    outputMatrix[i][j] = '*';
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int i = 0; i < outputMatrix[r].length; i++) {
                System.out.print(outputMatrix[r][i] + " ");
            }
            System.out.println();

        }






    }

    private static char[][] readMatrix(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().replaceAll("\\s+","");
            char[] arr = line.toCharArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
