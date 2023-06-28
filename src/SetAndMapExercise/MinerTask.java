package SetAndMapExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        int counter = 0;
        String resource = "";

        while (!input.equals("stop")) {
            counter++;
            int amount = 0;
            if (counter % 2 == 0) {
                amount = Integer.parseInt(input);
            } else {
                resource = input;
            }

            if (!resources.containsKey(resource)) {
                resources.put(resource, amount);
            } else {
                resources.put(resource, resources.get(resource) + amount);
            }

            input = scanner.nextLine();
        }


        for (var res : resources.entrySet()) {
            System.out.printf("%s -> %d%n", res.getKey(), res.getValue());
        }


    }
}
