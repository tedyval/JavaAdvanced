package Exsam17Dec2019;

import java.util.Scanner;

public class PresentDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }


        int startRow = 0;
        int startCol = 0;
        int niceKids = 0;
        final int niceForPresent = niceKids;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (matrix[i][j] == 'V') {
                    niceKids++;
                }
            }
        }

        boolean areNotThere = false;
        String input = scanner.nextLine();
        while (!input.equals("Christmas morning")) {
            String command = input;
            matrix[startRow][startCol] = '-';
            switch (command) {
                case "up":
                    startRow--;
                    if (matrix[startRow][startCol] == 'X') {
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'V'){
                        presents--;

                        niceKids--;
                        matrix[startRow][startCol] = 'S';
                        if(presents == 0){
                            areNotThere = true;
                            break;
                        }
                    }else if(matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'C'){
                        if( matrix[startRow][startCol--] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol--] == 'X'){
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow][startCol++] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol++] == 'X'){
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow--][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow--][startCol] == 'X'){
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        if( matrix[startRow++][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow++][startCol] == 'X'){
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        matrix[startRow][startCol] = 'S';
                    }


                    break;
                case "down":
                    startRow++;
                    if (matrix[startRow][startCol] == 'X') {
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'V'){
                        presents--;

                        niceKids--;
                        matrix[startRow][startCol] = 'S';
                        if(presents == 0){
                            areNotThere = true;
                            break;
                        }
                    }else if(matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'C'){
                        if( matrix[startRow][startCol--] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol--] == 'X'){
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow][startCol++] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol++] == 'X'){
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow--][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow--][startCol] == 'X'){
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        if( matrix[startRow++][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow++][startCol] == 'X'){
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        matrix[startRow][startCol] = 'S';
                    }



                    break;
                case "left":
                    startCol--;
                    if (matrix[startRow][startCol] == 'X') {
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'V'){
                        presents--;

                        niceKids--;
                        matrix[startRow][startCol] = 'S';
                        if(presents == 0){
                            areNotThere = true;
                            break;
                        }
                    }else if(matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'C'){
                        if( matrix[startRow][startCol--] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol--] == 'X'){
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow][startCol++] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol++] == 'X'){
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow--][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow--][startCol] == 'X'){
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        if( matrix[startRow++][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow++][startCol] == 'X'){
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        matrix[startRow][startCol] = 'S';
                    }



                    break;
                case "right":
                    startCol++;
                    if (matrix[startRow][startCol] == 'X') {
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'V'){
                        presents--;

                        niceKids--;
                        matrix[startRow][startCol] = 'S';
                        if(presents == 0){
                            areNotThere = true;
                            break;
                        }
                    }else if(matrix[startRow][startCol] == '-'){
                        matrix[startRow][startCol] = 'S';
                    }else if(matrix[startRow][startCol] == 'C'){
                        if( matrix[startRow][startCol--] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol--] == 'X'){
                            presents--;
                            matrix[startRow][startCol--] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow][startCol++] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow][startCol++] == 'X'){
                            presents--;
                            matrix[startRow][startCol++] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }

                        if( matrix[startRow--][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow--][startCol] == 'X'){
                            presents--;
                            matrix[startRow--][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        if( matrix[startRow++][startCol] == 'V'){
                            niceKids--;
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }else if(matrix[startRow++][startCol] == 'X'){
                            presents--;
                            matrix[startRow++][startCol] = '-';
                            if(presents == 0){
                                areNotThere = true;
                                break;
                            }
                        }


                        matrix[startRow][startCol] = 'S';
                    }

                    break;
            }

            if(areNotThere == true){
                break;
            }

            input = scanner.nextLine();
        }

        if(areNotThere == true){
            System.out.println("Santa ran out of presents.");
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }

        if(niceKids == 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n",niceForPresent);
        }else{
            System.out.printf("No presents for %d nice kid/s.",niceKids);
        }



    }
}
