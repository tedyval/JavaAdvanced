package LadyCat;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String input = scanner.nextLine();
       Map<String, LinkedHashMap<String,Cat>> catsEachType = new LinkedHashMap<>();
       catsEachType.put("Siamese",new LinkedHashMap<>());
       catsEachType.put("Cymric",new LinkedHashMap<>());
       catsEachType.put("StreetExtraordinaire",new LinkedHashMap<>());
       while(!input.equals("End")){
        String[] tokens = input.split("\\s+");
        String breed = tokens[0];
        String name = tokens[1];
        double criteria = Double.parseDouble(tokens[2]);
        switch(breed){
            case "Siamese":
            case "StreetExtraordinaire":
            case "Cymric":
                if(!catsEachType.get(breed).containsKey(name)){
                    catsEachType.get(breed).put(name,new Cat(breed,name,criteria));
                }
                break;
        }

        input = scanner.nextLine();
       }

       String searchedCat = scanner.nextLine();
        for (Map.Entry<String, LinkedHashMap<String, Cat>> typeOfCat : catsEachType.entrySet()) {
            for (Map.Entry<String, Cat> stringCatEntry : typeOfCat.getValue().entrySet()) {
                if(stringCatEntry.getValue().getName().equals(searchedCat)){
                    System.out.println(stringCatEntry.getValue().toString());
                }
            }


        }


    }
}
