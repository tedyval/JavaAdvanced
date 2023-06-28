package MultidimensionalArrayExercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split("\\s+")[0]);
        int col = Integer.parseInt(input.split("\\s+")[1]);
        String [][] matrix = new String[row][col];

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char startChar = 97;
        int sumOfRowCol = row + col;

        for (int i = 0; i < row; i++) {

            for (int j = 0 ; j < col ; j++) {
                StringBuilder str = new StringBuilder();
                sumOfRowCol = i+j;
                str.append(alphabet[i]).append(alphabet[sumOfRowCol]).append(alphabet[i]);
                matrix[i][j] = str.toString();

            }

        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();

        }



    }


}
