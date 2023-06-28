package SetAndMapExercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Collections.addAll(elements, tokens);
        }

        elements.forEach(e-> System.out.print(e + " "));


    }
}
