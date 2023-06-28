package MultidimensionalArrayLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        List<int[]> coordinations = new ArrayList<>();

        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == num){
                    int[] foundAt = {i,j};
                    coordinations.add(foundAt);
                }

            }

        }

        String output = coordinations.stream().map(arr -> arr[0] + " " + arr[1]).collect(Collectors.joining(System.lineSeparator()));
        if(coordinations.isEmpty()){
            System.out.println("not found");
        }else{
            System.out.println(output);
        }









    }
}
