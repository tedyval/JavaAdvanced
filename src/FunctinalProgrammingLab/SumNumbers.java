package FunctinalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");
        int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        long count =  Arrays.stream(numbers).mapToInt(Integer::parseInt).count();

        System.out.printf("Count = %d%n",count);
        System.out.printf("Sum = %d",sum);




    }
}
