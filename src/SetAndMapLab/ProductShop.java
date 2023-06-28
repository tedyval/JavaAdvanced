package SetAndMapLab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String,Double>> shopsAndProduct = new TreeMap<>();
        while(!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            if(!shopsAndProduct.containsKey(shop)) {
                shopsAndProduct.put(shop, new LinkedHashMap<>());
            }

            if(!shopsAndProduct.get(shop).containsKey(product)){
                shopsAndProduct.get(shop).put(product,price);
            }

            shopsAndProduct.get(shop).put(product,price);

            input = scanner.nextLine();
        }

        shopsAndProduct.entrySet().stream().forEach(e->{
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(s ->{
                System.out.printf("Product: %s, Price: %.1f%n",s.getKey(),s.getValue());

            });




        });









    }
}
