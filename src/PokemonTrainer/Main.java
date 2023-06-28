package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String nameTrainer = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(nameTrainer, new Trainer(nameTrainer));
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            trainers.get(nameTrainer).getPokemons().add(pokemon);
            input = scanner.nextLine();
        }


        String element = scanner.nextLine();
        while (!element.equals("End")) {

            switch (element) {
                case "Fire":
                    element = "Fire";
                    setPokemonsInMap(trainers, element);
                    break;
                case "Water":
                    element = "Water";
                    setPokemonsInMap(trainers, element);
                    break;
                case "Electricity":
                    element = "Electricity";
                    setPokemonsInMap(trainers, element);
                    break;
            }

            element = scanner.nextLine();
        }

        trainers.values().stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getName(), t.getBadges(), t.getPokemons().size()));


    }

    private static void setPokemonsInMap(Map<String, Trainer> trainers, String element) {
        int count = 0;
        for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
            if (trainer.getValue().getPokemons().size() > 0) {
                for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                    if (pokemon.getElement().equals(element)) {
                        trainer.getValue().setBadges();
                        count++;
                        break;
                    }

                }

                if (count == 0) {
                    List<Pokemon> toBeRemoved = new ArrayList<>();
                    for (Pokemon pokemonInList : trainer.getValue().getPokemons()) {
                        pokemonInList.setHealth(10);
                         if(pokemonInList.getHealth() <= 0){
                             toBeRemoved.add(pokemonInList);
                         }

                    }
                  trainer.getValue().getPokemons().removeAll(toBeRemoved);
                }
            }

        }
    }
}
