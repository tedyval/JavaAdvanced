package FunctinalProgrammingLab;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] numbers = scanner.nextLine().split(", ");
       List<Integer> evenNumbers = Arrays.stream(numbers).map(Integer::parseInt).filter(n-> n % 2 == 0).collect(Collectors.toList());
       System.out.println(evenNumbers.toString().replaceAll("\\[","").replaceAll("\\]",""));
       List<Integer> sortedEvenNum = Arrays.stream(numbers).map(Integer::parseInt).filter(n-> n % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(sortedEvenNum.toString().replaceAll("\\[","").replaceAll("\\]",""));
    }

}
