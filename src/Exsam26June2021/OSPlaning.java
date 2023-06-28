package Exsam26June2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OSPlaning {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> tasks = new ArrayDeque<>();
        int[] input1 = Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int s : input1) {
            tasks.push(s);
        }

        Queue<Integer> threads = new ArrayDeque<>();
        int[] input2 = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : input2) {
            threads.offer(i);
        }

        int taskToBeKilled = Integer.parseInt(bf.readLine());
        int thread = 0;
        while (tasks.size() > 0 && threads.size() > 0) {

                int currentTask = tasks.peek();
                thread = threads.peek();
                if (currentTask != taskToBeKilled) {
                    if (thread > currentTask) {
                        threads.remove(thread);
                        tasks.remove(currentTask);
                    } else if (thread < currentTask) {
                        threads.remove(thread);
                    }
                } else {
                    break;
                }


        }

        System.out.printf("Thread with value %d killed task %d%n",thread,taskToBeKilled);
        for (Integer threadd : threads) {
            System.out.print(threadd + " ");
        }


    }


}
