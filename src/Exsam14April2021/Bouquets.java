package Exsam14April2021;

import java.util.*;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulips::push);
        Queue<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodils::offer);
        int bouquets = 0;
        int floewrs = 0;
        while(!tulips.isEmpty() && !daffodils.isEmpty()){
            int tulipValue = tulips.peek();
            int daffodilValue = daffodils.peek();
            int sum = tulipValue + daffodilValue;
            if(sum == 15){
                bouquets++;
                tulips.pop();
                daffodils.poll();
            }else if(sum >15){

                while(sum > 15){
                    sum -= 2;
                }

                if(sum == 15){
                    bouquets++;
                    tulips.pop();
                    daffodils.poll();
                }else{
                    tulips.pop();
                    daffodils.poll();
                    floewrs += sum;
                }
            }else if(sum < 15){
                tulips.pop();
                daffodils.poll();
                floewrs += sum;
            }

        }

        bouquets += floewrs / 15;
        if(bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        }else{
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }






    }
}
