package Exsam16122020;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String input = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();
        }

        int startRow = 0;
        int startCol = 0;
        int pillars = 0;
        int pilarRow = 0;
        int pillarCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (matrix[i][j] == 'O') {
                    pillars++;
                    if (pillars == 2) {
                        pilarRow = i;
                        pillarCol = j;
                    }
                }
            }
        }

        boolean isThereCommand = true;
        int currentRow = startRow;
        int currentCol = startCol;
        boolean isOut = false;
        boolean isEnoughMoney = false;
        int sum = 0;

        while(true){
            try {
                String command = scanner.nextLine();


                    matrix[currentRow][currentCol] = '-';

                switch (command) {
                    case "up":
                        currentRow--;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            System.out.println("Bad news, you are out of the bakery.");
                            System.out.printf("Money: %d%n",sum);
                            print(matrix);
                            return;
                        } else if (matrix[currentRow][currentCol] == 'O') {
                            matrix[currentRow][currentCol] = '-';
                            currentRow = pilarRow;
                            currentCol = pillarCol;
                            matrix[currentRow][currentCol] = '-';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int val = Integer.parseInt(value);
                            sum += val;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnoughMoney = true;
                                System.out.println("Good news! You succeeded in collecting enough money!");
                                System.out.printf("Money: %d%n",sum);
                                matrix[currentRow][currentCol] = 'S';
                                print(matrix);
                                return;
                            }
                        }else{
                            matrix[currentRow][currentCol] = 'S';
                        }
                        break;
                    case "down":
                        currentRow++;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            System.out.println("Bad news, you are out of the bakery.");
                            System.out.printf("Money: %d%n",sum);
                            print(matrix);
                            return;
                        } else if (matrix[currentRow][currentCol] == 'O') {
                            matrix[currentRow][currentCol] = '-';
                            currentRow = pilarRow;
                            currentCol = pillarCol;
                            matrix[currentRow][currentCol] = '-';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int val = Integer.parseInt(value);
                            sum += val;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnoughMoney = true;
                                System.out.println("Good news! You succeeded in collecting enough money!");
                                System.out.printf("Money: %d%n",sum);
                                matrix[currentRow][currentCol] = 'S';
                                print(matrix);
                                return;
                            }
                        }else{
                            matrix[currentRow][currentCol] = 'S';
                        }

                        break;
                    case "left":
                        currentCol--;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            System.out.println("Bad news, you are out of the bakery.");
                            System.out.printf("Money: %d%n",sum);
                            print(matrix);
                            return;
                        } else if (matrix[currentRow][currentCol] == 'O') {
                            matrix[currentRow][currentCol] = '-';
                            currentRow = pilarRow;
                            currentCol = pillarCol;
                            matrix[currentRow][currentCol] = '-';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int val = Integer.parseInt(value);
                            sum += val;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnoughMoney = true;
                                System.out.println("Good news! You succeeded in collecting enough money!");
                                System.out.printf("Money: %d%n",sum);
                                matrix[currentRow][currentCol] = 'S';
                                print(matrix);
                                return;
                            }
                        }else{
                            matrix[currentRow][currentCol] = 'S';
                        }

                        break;
                    case "right":
                        currentCol++;
                        if (!isInMatrix(size, currentRow, currentCol)) {
                            isOut = true;
                            System.out.println("Bad news, you are out of the bakery.");
                            System.out.printf("Money: %d%n",sum);
                            print(matrix);
                            return;
                        } else if (matrix[currentRow][currentCol] == 'O') {
                            matrix[currentRow][currentCol] = '-';
                            currentRow = pilarRow;
                            currentCol = pillarCol;
                            matrix[currentRow][currentCol] = '-';
                        } else if (Character.isDigit(matrix[currentRow][currentCol])) {
                            String value = String.valueOf(matrix[currentRow][currentCol]);
                            int val = Integer.parseInt(value);
                            sum += val;
                            matrix[currentRow][currentCol] = 'S';
                            if (sum >= 50) {
                                isEnoughMoney = true;
                                System.out.println("Good news! You succeeded in collecting enough money!");
                                System.out.printf("Money: %d%n",sum);
                                matrix[currentRow][currentCol] = 'S';
                                print(matrix);
                                return;
                            }
                        }else{
                            matrix[currentRow][currentCol] = 'S';
                        }

                        break;
                }
            } catch (Exception e) {
                isThereCommand = false;
            }

        }


    }

    public static void print(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(int size, int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
}
