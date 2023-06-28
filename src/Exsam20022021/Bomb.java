package Exsam20022021;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startRow = 0;
        int startCol = 0;
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String input = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();
        }


        int bombs = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 's') {
                    startRow = i;
                    startCol = j;
                } else if (matrix[i][j] == 'B') {
                    bombs++;
                }
            }
        }




        int currentRow = startRow;
        int currentCol = startCol;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            switch (command){
                case "up":
                    currentRow--;
                    if(!isInMatrix(size,currentRow,currentCol)){
                        currentRow++;

                    } else if(matrix[currentRow][currentCol] == 'B'){
                        matrix[currentRow][currentCol] = '+';
                        bombs--;
                        System.out.println("You found a bomb!");
                        if(bombs == 0){
                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                    }else if(matrix[currentRow][currentCol] == 'e'){
                        matrix[currentRow][currentCol] = 's';
                        System.out.printf("END! %d bombs left on the field%n",bombs);
                        break;
                    }



                    break;
                case "down":
                    currentRow++;
                    if(!isInMatrix(size,currentRow,currentCol)){
                        currentRow--;

                    } else if(matrix[currentRow][currentCol] == 'B'){
                        matrix[currentRow][currentCol] = '+';
                        bombs--;
                        System.out.println("You found a bomb!");
                        if(bombs == 0){

                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                    }else if(matrix[currentRow][currentCol] == 'e'){
                        matrix[currentRow][currentCol] = 's';
                        System.out.printf("END! %d bombs left on the field%n",bombs);
                        return;
                    }

                    break;
                case "left":
                    currentCol--;
                    if(!isInMatrix(size,currentRow,currentCol)){
                        currentCol++;

                    } else if(matrix[currentRow][currentCol] == 'B'){
                        matrix[currentRow][currentCol] = '+';
                        bombs--;
                        System.out.println("You found a bomb!");
                        if(bombs == 0){

                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                    }else if(matrix[currentRow][currentCol] == 'e'){
                        matrix[currentRow][currentCol] = 's';
                        System.out.printf("END! %d bombs left on the field%n",bombs);
                        return;
                    }

                    break;
                case "right":
                    currentCol++;
                    if(!isInMatrix(size,currentRow,currentCol)){
                        currentCol--;

                    } else if(matrix[currentRow][currentCol] == 'B'){
                        matrix[currentRow][currentCol] = '+';
                        bombs--;
                        System.out.println("You found a bomb!");
                        if(bombs == 0){

                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                    }else if(matrix[currentRow][currentCol] == 'e'){
                        matrix[currentRow][currentCol] = 's';
                        System.out.printf("END! %d bombs left on the field%n",bombs);
                        return;
                    }

                    break;
            }

        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombs,currentRow,currentCol);













    }

    private static boolean isInMatrix(int size, int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
}
