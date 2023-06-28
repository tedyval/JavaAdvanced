package SetAndMapExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> username = new LinkedHashSet<>();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String input = scanner.nextLine();
            username.add(input);
        }

        username.forEach(System.out::println);







    }
}
