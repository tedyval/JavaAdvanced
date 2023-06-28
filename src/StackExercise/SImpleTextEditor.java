package StackExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SImpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < numOfOperations; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            switch (command) {
                case "1":
                    stack.push(text.toString());
                    String addedText = commands[1];
                    text.append(addedText);

                    break;
                case "2":
                    stack.push(text.toString());
                    int numOfDeletedChars = Integer.parseInt(commands[1]);
                    int startIndex = text.length() - numOfDeletedChars;
                    text.delete(startIndex, text.length());

                    break;
                case "3":
                    int numOfElement = Integer.parseInt(commands[1]);
                    if(numOfElement <= text.length()) {
                        char element = text.charAt(numOfElement - 1);
                        System.out.println(element);
                    }
                    break;
                case "4":
                    text = new StringBuilder(stack.pop());
                    break;

            }


        }


    }
}
