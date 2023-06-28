package Exsam19082020;


import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(lilies::push);
        Queue<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(roses::offer);
        int sum = 0;
        int wreaths = 0;
        int flowersStored = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lilElement = lilies.peek();
            int roseElem = roses.peek();
            sum = lilElement + roseElem;
            if (sum == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (sum > 15) {
                while (sum > 15) {
                    lilElement -= 2;
                    sum = roseElem + lilElement;
                    if (sum == 15) {
                        wreaths++;
                        lilies.pop();
                        roses.poll();
                    } else if (sum < 15) {
                        flowersStored += sum;
                        lilies.pop();
                        roses.poll();
                    }
                }

            } else {
                flowersStored += sum;
                lilies.pop();
                roses.poll();
            }
        }

        wreaths += flowersStored / 15;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", (5 - wreaths));
        }


    }
}
