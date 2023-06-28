package FunctinalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int[] numbers = Arrays.stream(scanner.nextLine().split(" ")) .mapToInt(Integer::parseInt).toArray();
       String condition = scanner.nextLine();
        Predicate<Integer> predicate = condition.equals("even") ? n -> n % 2 == 0 : n -> n % 2 != 0;
        IntStream.rangeClosed(numbers[0],numbers[1]).boxed().filter(predicate).forEach(e-> System.out.print(e + " "));




    }
}
