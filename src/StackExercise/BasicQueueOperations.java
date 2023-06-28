package StackExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int delete = commands[1];
        int containingNum = commands[2];
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 1; i <= delete; i++) {
            queue.poll();
        }

        if(queue.contains(containingNum)){
            System.out.println("true");
        }else{
            if(queue.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(Collections.min(queue));
            }

        }



    }
}
