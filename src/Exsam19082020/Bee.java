package Exsam19082020;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ","").toCharArray();
        }

        int startRow = 0;
        int startCol = 0;
        int flowers = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrix[i][j] == 'B'){
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int currentRow = startRow;
        int currentCol = startCol;
        boolean isLost = false;

        String command = scanner.nextLine();
        while(!command.equals("End")){
            matrix[currentRow][currentCol] = '.';
          switch (command){
              case "up":
                  currentRow--;
                  if(!isInMatrix(size,currentRow,currentCol)){
                      isLost = true;
                    break;
                  }else if(matrix[currentRow][currentCol] == 'f'){
                      matrix[currentRow][currentCol] = 'B';
                      flowers++;
                  }else if(matrix[currentRow][currentCol] == 'O'){
                      matrix[currentRow][currentCol] = '.';
                      currentRow--;
                      if(!isInMatrix(size,currentRow,currentCol)){
                          isLost = true;
                          break;
                      }else if(matrix[currentRow][currentCol] == 'f'){
                          matrix[currentRow][currentCol] = 'B';
                          flowers++;
                      }else{
                          matrix[currentRow][currentCol] = 'B';
                      }
                  }else{
                      matrix[currentRow][currentCol] = 'B';
                  }

                  break;
              case "down":
                  currentRow++;
                  if(!isInMatrix(size,currentRow,currentCol)){
                      isLost = true;
                      break;
                  }else if(matrix[currentRow][currentCol] == 'f'){
                      matrix[currentRow][currentCol] = 'B';
                      flowers++;
                  }else if(matrix[currentRow][currentCol] == 'O'){
                      matrix[currentRow][currentCol] = '.';
                      currentRow++;
                      if(!isInMatrix(size,currentRow,currentCol)){
                          isLost = true;
                          break;
                      }else if(matrix[currentRow][currentCol] == 'f'){
                          matrix[currentRow][currentCol] = 'B';
                          flowers++;
                      }else{
                          matrix[currentRow][currentCol] = 'B';
                      }
                  }else{
                      matrix[currentRow][currentCol] = 'B';
                  }

                  break;
              case "left":
                  currentCol--;
                  if(!isInMatrix(size,currentRow,currentCol)){
                      isLost = true;
                      break;
                  }else if(matrix[currentRow][currentCol] == 'f'){
                      matrix[currentRow][currentCol] = 'B';
                      flowers++;
                  }else if(matrix[currentRow][currentCol] == 'O'){
                      matrix[currentRow][currentCol] = '.';
                      currentCol--;
                      if(!isInMatrix(size,currentRow,currentCol)){
                          isLost = true;
                          break;
                      }else if(matrix[currentRow][currentCol] == 'f'){
                          matrix[currentRow][currentCol] = 'B';
                          flowers++;
                      }else{
                          matrix[currentRow][currentCol] = 'B';
                      }
                  }else{
                      matrix[currentRow][currentCol] = 'B';
                  }

                  break;
              case "right":
                  currentCol++;
                  if(!isInMatrix(size,currentRow,currentCol)){
                      isLost = true;
                      break;
                  }else if(matrix[currentRow][currentCol] == 'f'){
                      matrix[currentRow][currentCol] = 'B';
                      flowers++;
                  }else if(matrix[currentRow][currentCol] == 'O'){
                      matrix[currentRow][currentCol] = '.';
                      currentCol++;
                      if(!isInMatrix(size,currentRow,currentCol)){
                          isLost = true;
                          break;
                      }else if(matrix[currentRow][currentCol] == 'f'){
                          matrix[currentRow][currentCol] = 'B';
                          flowers++;
                      }else{
                          matrix[currentRow][currentCol] = 'B';
                      }
                  }else{
                      matrix[currentRow][currentCol] = 'B';
                  }

                  break;

          }
            if(isLost == true){
                break;
            }
          command = scanner.nextLine();
        }

        if(isLost == true){
            System.out.println("The bee got lost!");
        }

        if(flowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",flowers);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",(5-flowers));
        }

        print(matrix);







    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(int size, int r, int c) {
      return  r >= 0 && r < size && c >= 0 && c < size;
    }
}
