package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>,Integer> getMin = array ->
        {
            int min = array.stream().mapToInt(Integer::intValue).min().orElse(0);
            return  min;
        };
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int index = numbers.lastIndexOf(getMin.apply(numbers));
        System.out.println(index);









    }
}
