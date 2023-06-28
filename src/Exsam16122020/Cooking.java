package Exsam16122020;

import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> liquids = new ArrayDeque<>();
        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        Map<String, Integer> items = new TreeMap<>();
        items.put("Bread", 0);
        items.put("Cake", 0);
        items.put("Pastry", 0);
        items.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liqElement = liquids.peek();
            int ingridElement = ingredients.peek();
            int sum = liqElement + ingridElement;
            switch (sum) {
                case 25:
                    items.put("Bread",items.get("Bread") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 50:
                    items.put("Cake",items.get("Cake") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 75:
                    items.put("Pastry",items.get("Pastry") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 100:
                    items.put("Fruit Pie",items.get("Fruit Pie") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                default:
                    liquids.poll();
                    Integer elem = ingredients.pop();
                    ingredients.push(elem + 3);

                    break;
            }
        }

        int count = (int)items.values().stream().filter(i-> i >=1).count();
        if(count == items.size()){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if(liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.print("Liquids left: ");
            StringBuilder str = new StringBuilder();
            for (Integer liquid : liquids) {
                str.append(liquid).append(", ");
            }

            str.delete(str.length() - 2,str.length());


            System.out.println(str.toString());

        }

        if(ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.print("Ingredients left: ");
            StringBuilder str = new StringBuilder();
            for (Integer ingredient : ingredients) {
                str.append(ingredient).append(", ");
            }

            str.delete(str.length() - 2,str.length());

            System.out.println(str.toString());

        }


            for (var entry : items.entrySet()) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());

            }



    }
}
