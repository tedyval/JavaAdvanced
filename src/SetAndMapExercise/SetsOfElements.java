package SetAndMapExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetLength = tokens[0];
        int secondSetLength = tokens[1];
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            String number = scanner.nextLine();
            firstSet.add(number);
        }

        for (int i = 0; i < secondSetLength; i++) {
            String number = scanner.nextLine();
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);

        for (String s : firstSet) {
            System.out.print(s + " ");

        }


    }
}
