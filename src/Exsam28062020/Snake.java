package Exsam28062020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();

        }


        int startRow = 0;
        int startCol = 0;
        int foods = 0;
        int secondBurrowRow = 0;
        int secondBurrowCol = 0;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (matrix[i][j] == 'B') {
                    counter++;
                    if (counter == 2) {
                        secondBurrowRow = i;
                        secondBurrowCol = j;
                    }
                }
            }
        }


        boolean isOut = false;


        while (foods < 10) {

                String command = scanner.nextLine();
                matrix[startRow][startCol] = '.';
                switch (command) {
                    case "up":
                        startRow--;
                        if (!isInMatrix(size, startRow, startCol)) {
                            isOut = true;
                            break;
                        } else if (matrix[startRow][startCol] == '*') {
                            foods++;
                            matrix[startRow][startCol] = 'S';

                        } else if (matrix[startRow][startCol] == 'B') {
                            matrix[startRow][startCol] = '.';
                            startRow = secondBurrowRow;
                            startCol = secondBurrowCol;
                            matrix[startRow][startCol] = 'S';
                        } else if (matrix[startRow][startCol] == '-') {
                            matrix[startRow][startCol] = 'S';
                        }

                        break;
                    case "down":
                        startRow++;
                        if (!isInMatrix(size, startRow, startCol)) {
                            isOut = true;
                            break;
                        } else if (matrix[startRow][startCol] == '*') {
                            foods++;
                            matrix[startRow][startCol] = 'S';

                        } else if (matrix[startRow][startCol] == 'B') {
                            matrix[startRow][startCol] = '.';
                            startRow = secondBurrowRow;
                            startCol = secondBurrowCol;
                            matrix[startRow][startCol] = 'S';
                        } else if (matrix[startRow][startCol] == '-') {
                            matrix[startRow][startCol] = 'S';
                        }

                        break;
                    case "left":
                        startCol--;
                        if (!isInMatrix(size, startRow, startCol)) {
                            isOut = true;
                            break;
                        } else if (matrix[startRow][startCol] == '*') {
                            foods++;
                            matrix[startRow][startCol] = 'S';

                        } else if (matrix[startRow][startCol] == 'B') {
                            matrix[startRow][startCol] = '.';
                            startRow = secondBurrowRow;
                            startCol = secondBurrowCol;
                            matrix[startRow][startCol] = 'S';
                        } else if (matrix[startRow][startCol] == '-') {
                            matrix[startRow][startCol] = 'S';
                        }

                        break;
                    case "right":
                        startCol++;
                        if (!isInMatrix(size, startRow, startCol)) {
                            isOut = true;
                            break;
                        } else if (matrix[startRow][startCol] == '*') {
                            foods++;
                            matrix[startRow][startCol] = 'S';

                        } else if (matrix[startRow][startCol] == 'B') {
                            matrix[startRow][startCol] = '.';
                            startRow = secondBurrowRow;
                            startCol = secondBurrowCol;
                            matrix[startRow][startCol] = 'S';
                        } else if (matrix[startRow][startCol] == '-') {
                            matrix[startRow][startCol] = 'S';
                        }

                        break;

                }

                if(isOut){
                    break;
                }
        }

        if (isOut) {
            System.out.println("Game over!");
        } else if(foods == 10){
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foods);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }





    }

    private static boolean isInMatrix(int size, int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
}
