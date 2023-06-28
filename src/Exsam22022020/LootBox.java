package Exsam22022020;

import java.util.*;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> firstBox = new ArrayDeque<>();
        Deque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstBox::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);
        int storedBox = 0;
        while(!firstBox.isEmpty() && !secondBox.isEmpty()){
            int firstQueue = firstBox.peek();
            int firstDeque = secondBox.peek();
            int sum = firstDeque + firstQueue;
            if(sum % 2 == 0){
                storedBox += sum;
                firstBox.poll();
                secondBox.pop();
            }else{
                firstBox.offer(secondBox.pop());
            }
        }


        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else if(secondBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if(storedBox >= 100){
            System.out.printf("Your loot was epic! Value: %d%n",storedBox);
        }else{
            System.out.printf("Your loot was poor... Value: %d",storedBox);
        }




    }
}
