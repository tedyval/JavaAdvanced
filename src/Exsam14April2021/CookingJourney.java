package Exsam14April2021;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startRow = 0;
        int startCol = 0;

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();

        }

        int counter = 0;
        int pillarSecondRow = 0;
        int pillarsSecondCol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (matrix[i][j] == 'P') {
                    counter++;
                    if (counter == 2) {
                        pillarSecondRow = i;
                        pillarsSecondCol = j;
                    }

                }

            }

        }

        int currentRow = startRow;
        int currentCol = startCol;
        boolean isOut = false;
        boolean isEnough = false;
        int sum = 0;
        String command = "";

        while (true) {
            try {
                command = scanner.nextLine();
                matrix[currentRow][currentCol] = '-';
                switch (command) {
                    case "up":
                        currentRow--;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            break;
                        }

                        if (matrix[currentRow][currentCol] == 'P') {
                            currentRow = pillarSecondRow;
                            currentCol = pillarsSecondCol;
                            matrix[currentRow][currentCol] = 'S';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int valueOfDigit = Integer.parseInt(value);
                            sum += valueOfDigit;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnough = true;
                                break;
                            }
                        }

                        break;
                    case "down":
                        currentRow++;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            break;
                        }

                        if (matrix[currentRow][currentCol] == 'P') {
                            currentRow = pillarSecondRow;
                            currentCol = pillarsSecondCol;
                            matrix[currentRow][currentCol] = 'S';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int valueOfDigit = Integer.parseInt(value);
                            sum += valueOfDigit;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnough = true;
                                break;
                            }
                        }


                        break;
                    case "left":
                        currentCol--;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            break;
                        }

                        if (matrix[currentRow][currentCol] == 'P') {
                            currentRow = pillarSecondRow;
                            currentCol = pillarsSecondCol;
                            matrix[currentRow][currentCol] = 'S';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int valueOfDigit = Integer.parseInt(value);
                            sum += valueOfDigit;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnough = true;
                                break;
                            }
                        }


                        break;
                    case "right":
                        currentCol++;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            break;
                        }

                        if (matrix[currentRow][currentCol] == 'P') {
                            matrix[currentRow][currentCol] = '-';
                            currentRow = pillarSecondRow;
                            currentCol = pillarsSecondCol;
                            matrix[currentRow][currentCol] = 'S';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int valueOfDigit = Integer.parseInt(value);
                            sum += valueOfDigit;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnough = true;
                                break;
                            }
                        }

                        break;
                }
            } finally {
                if (isOut == true) {
                    System.out.println("Bad news! You are out of the pastry shop.");
                    System.out.printf("Money: %d%n", sum);
                    print(matrix);
                    break;

                } else if (isEnough == true) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    System.out.printf("Money: %d%n", sum);
                    print(matrix);
                    break;
                }


            }


        }




    }

    private static boolean isInMatrix(int size, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < size && currentCol >= 0 && currentCol < size;
    }

    public static void print(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
