package SetAndMapLab;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int num = Integer.parseInt(scanner.nextLine());
        Map<String, LinkedHashMap<String, List<String>>> countriesAndCities = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String  input = scanner.nextLine();

            String[] tokens = input.split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];
            if(!countriesAndCities.containsKey(continent)){
                countriesAndCities.put(continent, new LinkedHashMap<>());
            }

            if(!countriesAndCities.get(continent).containsKey(country)){
                countriesAndCities.get(continent).put(country,new ArrayList<>());
            }

            countriesAndCities.get(continent).get(country).add(city);

        }


        for (var contint : countriesAndCities.entrySet()) {
            System.out.printf("%s:%n",contint.getKey());
            for (var country : contint.getValue().entrySet()) {
                System.out.printf("  %s -> ",country.getKey());
                String listOfCities = String.join(", ", country.getValue());
                System.out.println(listOfCities);
            }


        }










    }
}
