package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokenss = scanner.nextLine().split("\\s+");
        Map<String, Integer> names = new LinkedHashMap<>();
        for (String token : tokenss) {
            names.put(token, 1);
        }


        String output = "";
        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String commandPartTwo = tokens[1];
            String commandPartThree = tokens[2];
            Predicate<String> isMetCriteria = getPredicate(commandPartTwo, commandPartThree);


            switch (command) {
                case "Add filter":
                    counter++;

                    Function<Map<String, Integer>, List<String>> filteredList = array -> array.keySet().stream().filter(isMetCriteria).collect(Collectors.toList());

                    List<String> namesToBeRemoved = filteredList.apply(names);
                    for (Map.Entry<String, Integer> entry : names.entrySet()) {
                        for (String s : namesToBeRemoved) {
                            if (entry.getKey().equals(s)) {
                                names.put(entry.getKey(), 0);
                            }
                        }

                    }

                    break;
                case "Remove filter":
                    Function<Map<String, Integer>, List<String>> filteredList2 = array -> array.keySet().stream().filter(isMetCriteria).collect(Collectors.toList());

                    List<String> namesToAdded = filteredList2.apply(names);
                    for (Map.Entry<String, Integer> entry : names.entrySet()) {
                        for (String s : namesToAdded) {
                            if (entry.getKey().equals(s)) {
                                names.put(entry.getKey(), 1);
                            }
                        }

                    }
                    break;


            }
            input = scanner.nextLine();

        }


        if(names.entrySet().stream().anyMatch(e -> e.getValue() == 1)){
            names.entrySet().stream().filter(e -> e.getValue() == 1).forEach(e -> System.out.print(e.getKey() + " "));
        }







    }


        private static Predicate<String> getPredicate (String commandPartTwo, String commandPartThree){
            Predicate<String> predicate;
            switch (commandPartTwo) {
                case "Starts with":
                    predicate = name -> name.startsWith(commandPartThree);
                case "Ends with":
                    predicate = name -> name.endsWith(commandPartThree);
                case "Length":
                    predicate = name -> name.length() == Integer.parseInt(commandPartThree);
                case "Contains":
                    predicate = name -> name.contains(commandPartThree);

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + commandPartTwo);
            }
            return predicate;


        }


    }

