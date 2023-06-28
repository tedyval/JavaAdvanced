package FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOfPredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<Integer> divider = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Predicate<Integer> predicate = n -> {
            for (Integer integer : divider) {
                if (integer == 0) {
                    continue;
                }
                if (n % integer != 0) {
                    return false;
                }
            }
            return true;

        };

        IntStream.rangeClosed(1, num).boxed().filter(predicate).forEach(e -> System.out.print(e + " "));

    }
}
