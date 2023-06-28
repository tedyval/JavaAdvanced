package SetAndMapExercise;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> cards = new HashSet<>();
        Map<String, Set<String>> players = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            cards = Arrays.stream(tokens[1].split(", ")).collect(Collectors.toSet());
            if (!players.containsKey(name)) {
                players.put(name, cards);
            } else {
                players.get(name).addAll(cards);
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> powerOfLettersInCardName= new HashMap<>();
        powerOfLettersInCardName.put("J", 11);
        powerOfLettersInCardName.put("Q", 12);
        powerOfLettersInCardName.put("K", 13);
        powerOfLettersInCardName.put("A", 14);
        powerOfLettersInCardName.put("S", 4);
        powerOfLettersInCardName.put("H", 3);
        powerOfLettersInCardName.put("D", 2);
        powerOfLettersInCardName.put("C", 1);
        for (var e : players.entrySet()) {
            int sum = 0;
            for (String s : e.getValue()) {
                String[] partsOfCard = s.split("");
                String type = partsOfCard[partsOfCard.length - 1];
                int num = 0;
                int valueOfType = powerOfLettersInCardName.get(type);

                if(partsOfCard.length == 3){
                    num = 10;

                }else{
                    if(Character.isDigit(partsOfCard[0].charAt(0))){
                        num = Integer.parseInt(partsOfCard[0]);
                    }else{
                      num = powerOfLettersInCardName.get(partsOfCard[0]);
                    }

                }
                int valueOfCard = num * valueOfType;
                sum += valueOfCard;

            }
            System.out.printf("%s: %d%n", e.getKey(), sum);

        }
    }
}
