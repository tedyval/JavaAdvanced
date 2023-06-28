package StackExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPlants = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondQueue = new ArrayDeque<>();
        for (int i = 0; i <plants.length ; i++) {
            firstQueue.offer(plants[i]);
        }



        int counter = 0;
        boolean isDead = true;
        while(!isDead == false) {
          int size = firstQueue.size();
            int count = 0;
            for (Integer integer : firstQueue) {
                count++;
                if(count == 1){
                    int removedElement = firstQueue.peek();
                    secondQueue.offer(removedElement);
                }else{
                    if(firstQueue.peek() > secondQueue.peek()){
                        firstQueue.poll();
                    }else{
                        int shiftedElem = firstQueue.poll();
                        secondQueue.offer(shiftedElem);
                    }
                }
            }

            if(size > secondQueue.size()){
                isDead = true;
                counter++;

            }else{
                isDead = false;

            }

            firstQueue.addAll(secondQueue);
            secondQueue.clear();

        }

        System.out.println(counter);


    }
}
