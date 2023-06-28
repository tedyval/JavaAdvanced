package Izpit;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshLevel = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            ingredients.offer(Integer.parseInt(s));
        }

        String[] input1 = scanner.nextLine().split("\\s+");
        for (String s : input1) {
            freshLevel.push(Integer.parseInt(s));
        }

        Map<String, Integer> coctails = new TreeMap<>();
        coctails.put("Pear Sour",0);
        coctails.put("The Harvest",0);
        coctails.put("Apple Hinny",0);
        coctails.put("High Fashion",0);
        boolean isEmtyy = false;
        while(!ingredients.isEmpty() && !freshLevel.isEmpty()){
            int ingr = ingredients.peek();
            int fresh = freshLevel.peek();
            int result = ingr * fresh;

            if(result == 150 || result == 250 || result == 300 || result == 400){
               switch (result){
                   case 150:
                       coctails.put("Pear Sour", coctails.get("Pear Sour") + 1);
                       ingredients.poll();
                       freshLevel.pop();
                       break;
                   case 250:
                       coctails.put("The Harvest", coctails.get("The Harvest") + 1);
                       ingredients.poll();
                       freshLevel.pop();
                       break;
                   case 300:
                       coctails.put("Apple Hinny", coctails.get("Apple Hinny") + 1);
                       ingredients.poll();
                       freshLevel.pop();
                       break;
                   case 400:
                       coctails.put("High Fashion", coctails.get("High Fashion") + 1);
                       ingredients.poll();
                       freshLevel.pop();

                       break;
               }
            }else {

                if (ingr == 0) {
                    ingredients.poll();
                } else {
                    freshLevel.pop();
                    int changed = ingredients.poll() + 5;
                    ingredients.addLast(changed);
                }
            }



        }

        int count = (int)coctails.values().stream().filter(c -> c >= 1).count();
        if(count >= 4){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sum = ingredients.stream().mapToInt(Integer::intValue).sum();
        if(sum >0){
            System.out.printf("Ingredients left: %d%n",sum);
        }


        int count1 = (int) coctails.entrySet().stream().filter(c -> c.getValue() >= 1).count();
        if(count1 >= 1){
            coctails.entrySet().stream().filter(c -> c.getValue() >= 1).forEach(c-> System.out.printf(" # %s --> %d%n",c.getKey(),c.getValue()));

        }



    }
}
