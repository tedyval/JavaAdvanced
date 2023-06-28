package SetAndMapExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Map<String, Integer>  mapOfMaterials = new TreeMap<>();
        mapOfMaterials.put("shards",0);
        mapOfMaterials.put("fragments",0);
        mapOfMaterials.put("motes",0);
        Map<String, Integer> junks = new TreeMap<>();
        Map<String, String> legendarys = new HashMap<>();
        legendarys.put("shards","Shadowmourne");
        legendarys.put("fragments","Valanyr");
        legendarys.put("motes","Dragonwrath");


        int counter = 0;
        while(true){
            counter++;
            if(counter > 10){
                return;
            }
            String input = br.readLine();
            String[] parts = input.split("\\s+");
            if(parts.length > 25){
                return;
            }
            for (int i = 0; i < parts.length; i+=2) {
                int points = Integer.parseInt(parts[i]);
                String material = parts[i + 1].toLowerCase();


                if (mapOfMaterials.containsKey(material)) {
                    mapOfMaterials.put(material, mapOfMaterials.get(material)+points);
                    if (mapOfMaterials.get(material) >= 250) {
                        String wonLegendary = legendarys.get(material);
                        mapOfMaterials.put(material, mapOfMaterials.get(material) - 250);
                        System.out.println(wonLegendary + " obtained!");
                        mapOfMaterials.entrySet().stream().sorted((e1, e2) -> {
                            if(e2.getValue().equals(e1.getValue())){
                                return e1.getKey().compareTo(e2.getKey());
                            }else{
                               return  Integer.compare(e2.getValue(),e1.getValue());
                            }

                        }).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
                        junks.entrySet().stream()
                                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

                        return;
                    }
                } else {
                    junks.put(material, points);
                }
            }

        }











    }
}
