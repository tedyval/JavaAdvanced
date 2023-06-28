package Exsam22022020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ","").toCharArray();
        }

        int startRow = 0;
        int startCol = 0;


        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'f') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        boolean isAtFinish = false;

        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();
            matrix[startRow][startCol] = '-';
            int[][] lastposition = new int[startRow][startCol];
            switch(command){
                case "up":
                    startRow--;
                    if(!isInMatrix(size,startRow,startCol)) {
                        startRow = size - 1;
                        lastposition = new int[startRow][startCol];
                    }

                     if(matrix[startRow][startCol] == 'F'){
                        matrix[startRow][startCol] = 'f';


                            isAtFinish = true;
                            break;

                    }else if(matrix[startRow][startCol] == 'B'){

                        startRow--;
                         if(!isInMatrix(size,startRow,startCol)) {
                             startRow = size - 1;
                             lastposition = new int[startRow][startCol];
                         }
                         if(matrix[startRow][startCol] =='F'){
                             matrix[startRow][startCol] = 'f';
                             isAtFinish = true;
                             break;
                         }

                        matrix[startRow][startCol] = 'f';
                         lastposition = new int[startRow][startCol];
                    }else if(matrix[startRow][startCol] == 'T'){

                        startRow = lastposition.length;
                        matrix[startRow][startCol] = 'f';
                    }else if( matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'f';
                         lastposition = new int[startRow][startCol];
                    }

                    break;
                case "down":
                   startRow++;
                    if(!isInMatrix(size,startRow,startCol)) {
                        startRow = 0;
                        lastposition = new int[startRow][startCol];
                    }

                    if(matrix[startRow][startCol] == 'F'){
                        matrix[startRow][startCol] = 'f';
                        isAtFinish = true;
                            break;


                    }else if(matrix[startRow][startCol] == 'B'){

                        startRow++;
                        if(!isInMatrix(size,startRow,startCol)) {
                            startRow = 0;
                            lastposition = new int[startRow][startCol];
                        }
                        if(matrix[startRow][startCol] =='F'){
                            matrix[startRow][startCol] = 'f';
                            isAtFinish = true;
                            break;
                        }
                        matrix[startRow][startCol] = 'f';
                        lastposition = new int[startRow][startCol];
                    }else if(matrix[startRow][startCol] == 'T'){

                        startRow = lastposition.length;
                        matrix[startRow][startCol] = 'f';
                    }else if( matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'f';
                        lastposition = new int[startRow][startCol];
                    }


                    break;
                case "left":
                    startCol--;
                    if(!isInMatrix(size,startRow,startCol)) {
                        startCol = size - 1;
                        lastposition = new int[startRow][startCol];
                    }

                    if(matrix[startRow][startCol] == 'F'){
                        matrix[startRow][startCol] = 'f';
                        isAtFinish = true;
                            break;


                    }else if(matrix[startRow][startCol] == 'B'){
                        startCol--;
                        if(!isInMatrix(size,startRow,startCol)) {
                            startCol = size - 1;
                            lastposition = new int[startRow][startCol];
                        }
                        if(matrix[startRow][startCol] =='F'){
                            matrix[startRow][startCol] = 'f';
                            isAtFinish = true;
                            break;
                        }
                        matrix[startRow][startCol] = 'f';
                        lastposition = new int[startRow][startCol];
                    }else if(matrix[startRow][startCol] == 'T'){

                        startCol = lastposition[lastposition.length-1].length;
                        matrix[startRow][startCol] = 'f';
                    }else if( matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'f';
                        lastposition = new int[startRow][startCol];
                    }

                    break;
                case "right":
                    startCol++;
                    if(!isInMatrix(size,startRow,startCol)) {
                        startCol = 0;
                        lastposition = new int[startRow][startCol];
                    }

                    if(matrix[startRow][startCol] == 'F'){
                        matrix[startRow][startCol] = 'f';
                        isAtFinish = true;
                            break;

                    }else if(matrix[startRow][startCol] == 'B'){

                        startCol++;
                        if(!isInMatrix(size,startRow,startCol)) {
                            startCol = 0;
                            lastposition = new int[startRow][startCol];
                        }
                        if(matrix[startRow][startCol] =='F'){
                            matrix[startRow][startCol] = 'f';
                            isAtFinish = true;
                            break;
                        }
                        matrix[startRow][startCol] = 'f';
                        lastposition = new int[startRow][startCol];
                    }else if(matrix[startRow][startCol] == 'T'){

                        startCol = lastposition[lastposition.length-1].length;
                        matrix[startRow][startCol] = 'f';
                    }else if( matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'f';
                        lastposition = new int[startRow][startCol];
                    }

                    break;

            }

            if(isAtFinish == true){
                break;
            }
        }

        if(isAtFinish == true){
            System.out.println("Player won!");
        }else{
            System.out.println("Player lost!");
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }




    }

    private static boolean isInMatrix(int size, int r, int c) {
        return  r >= 0 && r < size && c >= 0 && c < size;


    }
}
