package SetAndMapLab;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbersInMap = new LinkedHashMap<>();

        for (double element : numbers) {
            if (!numbersInMap.containsKey(element)) {
                numbersInMap.put(element, 1);
            } else {
                numbersInMap.put(element, numbersInMap.get(element) + 1);
            }
        }




        for (Map.Entry<Double, Integer> e : numbersInMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue());
        }


    }
}
