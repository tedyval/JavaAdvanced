package Exsam26June2021;
import java.util.Scanner;


public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        if(sizeMatrix < 2 || sizeMatrix == 2147483647){
            return;
        }
        String[] commands = scanner.nextLine().split(",\\s+");
        char[][] matrix = new char[sizeMatrix][sizeMatrix];
        boolean isEnough = false;
        for (int i = 0; i < sizeMatrix; i++) {
            String firstLine = scanner.nextLine().replaceAll(" ","");
            int countSymbols = firstLine.length();
            if(sizeMatrix < countSymbols){
                isEnough = true;
                break;
            }else{
                matrix[i] = firstLine.toCharArray();
            }

        }
        if(isEnough == true){
            return;
        }


        int startLength = 1;
        int rowStart = 0;
        int colStart = 0;
        int food = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 's') {
                    rowStart = i;
                    colStart = j;
                } else if (matrix[i][j] == 'f') {
                    food++;
                }
            }
        }

        boolean wasKilled = false;
        int currentRow = rowStart;
        int currentCol = colStart;
        int index = 0;
        while(index < commands.length){
            String command = commands[index];
            switch (command){
                case "up":
                    currentRow--;
                    if(!isInMatrix(matrix, currentRow,currentCol)){
                        currentRow = sizeMatrix - 1;
                    }
                    if(matrix[currentRow][currentCol] == 'e'){
                        wasKilled = true;
                        break;
                    }else if(matrix[currentRow][currentCol] == 'f'){
                        food--;
                        startLength++;
                    }
                    break;
                case "down":
                        currentRow++;

                        if (!isInMatrix(matrix, currentRow, currentCol)) {
                            currentRow = 0;
                        }
                        if (matrix[currentRow][currentCol] == 'e') {
                            wasKilled = true;
                            break;
                        } else if (matrix[currentRow][currentCol] == 'f') {
                            food--;
                            startLength++;
                        }


                    break;
                case "left":
                    currentCol--;
                    if(!isInMatrix(matrix,currentRow,currentCol)){
                        currentCol = sizeMatrix - 1;
                    }
                    if(matrix[currentRow][currentCol] == 'e'){
                        wasKilled = true;
                        break;
                    }else if(matrix[currentRow][currentCol] == 'f'){
                        food--;
                        startLength++;
                    }
                    break;
                case "right":
                    currentCol++;
                    if(!isInMatrix(matrix,currentRow,currentCol)){
                        currentCol = 0;
                    }
                    if(matrix[currentRow][currentCol] == 'e'){
                        wasKilled = true;
                        break;
                    }else if(matrix[currentRow][currentCol] == 'f'){
                        food--;
                        startLength++;
                    }
                    break;

            }

            if(food == 0){
                System.out.printf("You win! Final python length is %d%n",startLength);
                return;
            }


            if(wasKilled == true){
                break;
            }
            index++;
        }


        if(wasKilled == true){
            System.out.println("You lose! Killed by an enemy!");

        }else{
            System.out.printf("You lose! There is still %d food to be eaten.",food);

        }








    }

    private static boolean isInMatrix(char[][] matrix, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix.length;
    }


}
