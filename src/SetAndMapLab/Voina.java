package SetAndMapLab;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while(rounds > 0){
            int cardFirstPlayer = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(cardFirstPlayer);

            int cardSecondPlayer = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(cardSecondPlayer);


            if(cardFirstPlayer > cardSecondPlayer){
                firstPlayerCards.add(cardFirstPlayer);
                firstPlayerCards.add(cardSecondPlayer);
            }else if(cardFirstPlayer < cardSecondPlayer){
                secondPlayerCards.add(cardFirstPlayer);
                secondPlayerCards.add(cardSecondPlayer);
            }

            if(firstPlayerCards.isEmpty()){
                System.out.println("Second player win!");
                break;
            }else if(secondPlayerCards.isEmpty()){
                System.out.println("First player win!");
                break;
            }


            rounds--;
        }

        if(firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        }else if(firstPlayerCards.size() < secondPlayerCards.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }







    }
}
