package SetAndMapExercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Long>> countryByPopulation = new LinkedHashMap<>();
        Map<String ,Long> countryTotalPopulation = new LinkedHashMap<>();
        while (!input.equals("report")) {
            int totalPopulation = 0;
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            totalPopulation += population;
            countryTotalPopulation.putIfAbsent(country, 0L);
            countryTotalPopulation.put(country, countryTotalPopulation.get(country) + totalPopulation);


            countryByPopulation.putIfAbsent(country, new LinkedHashMap<>());
            countryByPopulation.get(country).putIfAbsent(city, 0L);
            long oldValue = countryByPopulation.get(country).get(city);
            countryByPopulation.get(country).put(city,oldValue + population);

            input = scanner.nextLine();
        }





        countryByPopulation.entrySet().stream().sorted((e1,e2) -> Long.compare(countryTotalPopulation.get(e2.getKey()),countryTotalPopulation.get(e1.getKey())))
                .forEach(e -> {
            System.out.println(e.getKey() +" (total population: " +countryTotalPopulation.get(e.getKey()) + ")");
            e.getValue().entrySet().stream().sorted((e1,e2) -> {
                return Long.compare(e2.getValue(), e1.getValue());
            }).forEach(s -> System.out.printf("=>%s: %d%n",s.getKey(),s.getValue()));

        });


    }
}
