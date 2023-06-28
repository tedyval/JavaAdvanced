package FunctinalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");


        List<String> wordsWithCappitalLetter = Arrays.stream(words).filter(w-> Character.isUpperCase(w.charAt(0))).collect(Collectors.toList());
        System.out.println(wordsWithCappitalLetter.size());
        wordsWithCappitalLetter.forEach(w-> System.out.println(w));



    }
}
