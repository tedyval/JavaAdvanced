package SetAndMapExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        TreeMap<Character, Integer> symbolTimes = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if(!symbolTimes.containsKey(symbol)){
                symbolTimes.put(symbol,1);
            }else {
                symbolTimes.put(symbol, symbolTimes.get(symbol) + 1);
            }
        }

        for (var character: symbolTimes.entrySet()) {
            System.out.printf("%c: %d time/s%n",character.getKey(),character.getValue());
        }


    }
}
