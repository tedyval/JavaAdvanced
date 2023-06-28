package Exsam20022021;

import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(first::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(second::push);

        int total = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int firstElement = first.peek();
            int secondElement = second.peek();
            int sum = firstElement + secondElement;
            if (sum % 2 == 0) {
                total += sum;
                first.poll();
                second.pop();
            } else {
                first.offer(second.pop());
            }
        }

        if (first.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (second.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (total >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", total);
        } else {
            System.out.printf("Poor prey... Value: %d", total);

        }


    }
}
