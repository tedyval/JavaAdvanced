package Izpit;

import java.util.Scanner;

public class MouseAndCheese {
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

        int cheeses = 0;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'M') {
                    startRow = i;
                    startCol = j;
                }

                if (matrix[i][j] == 'c') {
                    cheeses++;

                }

            }

        }



        boolean isOut = false;
        int counter = 0;
        String command = scanner.nextLine();
        while(!command.equals("end")){
           matrix[startRow][startCol] = '-';
           switch (command){
               case "up":
                   startRow--;
                   if(!isInMatrix(size,startRow,startCol)){
                      isOut = true;
                      break;
                   }else if( matrix[startRow][startCol] == 'c'){
                       counter++;
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == '-'){
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == 'B'){
                       matrix[startRow][startCol] = '-';
                       startRow--;
                       if(!isInMatrix(size,startRow,startCol)) {
                           isOut = true;
                           break;
                       }else if( matrix[startRow][startCol] == 'c'){
                           counter++;
                           matrix[startRow][startCol] = 'M';
                       }else if(matrix[startRow][startCol] == '-'){
                           matrix[startRow][startCol] = 'M';
                       }

                   }

                   break;
               case "down":
                   startRow++;
                   if(!isInMatrix(size,startRow,startCol)){
                       isOut = true;
                       break;
                   }else if( matrix[startRow][startCol] == 'c'){
                       counter++;
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == '-'){
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == 'B'){
                       matrix[startRow][startCol] = '-';
                       startRow++;
                       if(!isInMatrix(size,startRow,startCol)) {
                           isOut = true;
                           break;
                       }else if( matrix[startRow][startCol] == 'c'){
                           counter++;
                           matrix[startRow][startCol] = 'M';
                       }else if(matrix[startRow][startCol] == '-'){
                           matrix[startRow][startCol] = 'M';
                       }

                   }


                   break;
               case "left":
                   startCol--;
                   if(!isInMatrix(size,startRow,startCol)){
                       isOut = true;
                       break;
                   }else if( matrix[startRow][startCol] == 'c'){
                       counter++;
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == '-'){
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == 'B'){
                       matrix[startRow][startCol] = '-';
                       startCol--;
                       if(!isInMatrix(size,startRow,startCol)) {
                           isOut = true;
                           break;
                       }else if( matrix[startRow][startCol] == 'c'){
                           counter++;
                           matrix[startRow][startCol] = 'M';
                       }else if(matrix[startRow][startCol] == '-'){
                           matrix[startRow][startCol] = 'M';
                       }

                   }


                   break;
               case "right":
                   startCol++;
                   if(!isInMatrix(size,startRow,startCol)){
                       isOut = true;
                       break;
                   }else if( matrix[startRow][startCol] == 'c'){
                       counter++;
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == '-'){
                       matrix[startRow][startCol] = 'M';
                   }else if(matrix[startRow][startCol] == 'B'){
                       matrix[startRow][startCol] = '-';
                       startCol++;
                       if(!isInMatrix(size,startRow,startCol)) {
                           isOut = true;
                           break;
                       }else if( matrix[startRow][startCol] == 'c'){
                           counter++;
                           matrix[startRow][startCol] = 'M';
                       }else if(matrix[startRow][startCol] == '-'){
                           matrix[startRow][startCol] = 'M';
                       }

                   }


                   break;

           }



            if(isOut == true){
                break;
            }

            command = scanner.nextLine();
        }

        if(isOut == true) {
            System.out.println("Where is the mouse?");
        }

        if(counter < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5 - counter);
        }else{
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",counter);
        }

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
