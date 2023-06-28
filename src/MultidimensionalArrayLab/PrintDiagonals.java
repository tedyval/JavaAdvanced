package MultidimensionalArrayLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[num][num];
        for (int r = 0; r < num; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < num ; ) {
            for (int j = 0; j < num ; ) {
                int firstPoint = matrix[i][j];
                System.out.print(firstPoint + " ");
                i++;
                j++;
            }
        }


        System.out.println();
        for (int i = num - 1; i >=  0 ; ) {
            for (int j = 0; j < num ; ) {
                int firstPoint = matrix[i][j];
                System.out.print(firstPoint + " ");
                i--;
                j++;
            }
        }






    }
}
