package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers);
        int num = Integer.parseInt(scanner.nextLine());
        Function<List<Integer>,String> modifiedList = array -> {
           String newNumbers = array.stream().mapToInt(Integer::intValue).filter(n-> n % num != 0)
                   .mapToObj(String::valueOf).collect(Collectors.joining(" "));
           return newNumbers;
        };

        System.out.println(modifiedList.apply(numbers));







    }
}
