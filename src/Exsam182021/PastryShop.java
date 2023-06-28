package Exsam182021;

import java.util.*;
import java.util.stream.Collectors;


public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> liquids = new ArrayDeque<>();
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i : input) {
            liquids.offer(i);
        }

        Deque<Integer> ingredients = new ArrayDeque<>();
        int[] input2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i : input2) {
            ingredients.push(i);
        }


        Map<String, Integer> pastry = new LinkedHashMap<>();
        pastry.put("Biscuit", 0);
        pastry.put("Cake", 0);
        pastry.put("Pie", 0);
        pastry.put("Pastry", 0);


        while (!ingredients.isEmpty() && !liquids.isEmpty()) {

            int sum = liquids.peek() + ingredients.peek();
            switch (sum) {
                case 25:
                    fillPastry(liquids, ingredients, pastry, "Biscuit");
                    break;
                case 50:
                    fillPastry(liquids, ingredients, pastry, "Cake");
                    break;
                case 75:
                    fillPastry(liquids, ingredients, pastry, "Pastry");
                    break;
                case 100:
                    fillPastry(liquids, ingredients, pastry, "Pie");
                    break;
                default:
                    liquids.poll();
                    int newValue = ingredients.pop() + 3;
                    ingredients.addFirst(newValue);
                    break;

            }


        }

        int countOfMatchings = (int)pastry.values().stream().filter(e-> e >= 1).count();
        if(countOfMatchings == pastry.size()){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if(liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            StringBuilder str  = new StringBuilder();
            for (Integer liquid : liquids) {
                str.append(liquid).append(", ");
            }
            str.delete(str.length() - 2,str.length());
            String output = str.toString();

            System.out.println("Liquids left: " + output);
        }

        if(ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            StringBuilder str  = new StringBuilder();
            for (Integer ingredient : ingredients) {
                str.append(ingredient).append(", ");
            }
            str.delete(str.length() - 2,str.length());
            String output = str.toString();

            System.out.println("Ingredients left: " + output);
        }


        pastry.entrySet().stream().forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));


    }

    private static void fillPastry(Queue<Integer> liquids, Deque<Integer> ingredients, Map<String, Integer> pastry, String pastryName) {
        liquids.poll();
        ingredients.pop();
        pastry.put(pastryName, pastry.get(pastryName) + 1);
    }
}
