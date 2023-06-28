package StackExercise;



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int push = commands[0];
        int pop = commands[1];
        int numOfContainingDigit = commands[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length ; i++) {
           stack.push(numbers[i]);
        }

        for (int i = 1; i <= pop ; i++) {
            stack.pop();
        }

        if(stack.contains(numOfContainingDigit)){
            System.out.println("true");

        } else{
            if(stack.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(Collections.min(stack));
            }

        }






    }
}
