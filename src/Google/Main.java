package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap();
        String input = scanner.nextLine();
        while(!input.equals("End")){
         String[] tokens = input.split("\\s+");
         String name = tokens[0];
         people.putIfAbsent(name,new Person(name));

         switch(tokens[1]){
             case "company":
                 String companyName = tokens[2];
                 String department = tokens[3];
                 double salary = Double.parseDouble(tokens[4]);
                 Company company = new Company(companyName,department,salary);
                 people.get(name).setCompany(company);
                 break;
             case "pokemon":
                 String pokemonName = tokens[2];
                 String pokemonType = tokens[3];
                 Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                 people.get(name).getPokemon().add(pokemon);
                 break;
             case "parents":
                 String parentName = tokens[2];
                 String parentBirthday = tokens[3];
                 Parent parent = new Parent(parentName, parentBirthday);
                 people.get(name).getParents().add(parent);
                 break;
             case "children":
                 String childName = tokens[2];
                 String childBirthday = tokens[3];
                 Child child = new Child(childName, childBirthday);
                 people.get(name).getChildren().add(child);
                 break;
             case "car":
                 String model = tokens[2];
                  int speed = Integer.parseInt(tokens[3]);
                  Car car = new Car(model, speed);
                 people.get(name).setCar(car);
                 break;

         }



            input = scanner.nextLine();
        }


        String searchedName = scanner.nextLine();
        for (Map.Entry<String, Person> s : people.entrySet()) {
            if(s.getValue().getName().equals(searchedName)){
                System.out.println(s.getValue().toString());
            }
        }


    }
}
