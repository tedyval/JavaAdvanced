package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());


        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String commandPartTwo = tokens[1];
            String commandPartThree = tokens[2];
            Predicate<String> isMetCriteria = getPredicate(commandPartTwo,commandPartThree);
            Function<List<String>,List<String>> newList = array -> array.stream().filter(isMetCriteria).collect(Collectors.toList());
            switch(command){
                case "Remove":
                    List<String> searchedElements = newList.apply(names);
                    searchedElements.forEach(names::remove);
                    break;
                case "Double":
                    List<String> searchedElements2 = newList.apply(names);
                    names.addAll(searchedElements2);
                    break;
            }

            input = scanner.nextLine();
        }

        Collections.sort(names);
        if(names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            String namesAsString = names.toString().replaceAll("\\[","").replaceAll("\\]","");
            System.out.println(namesAsString + " are going to the party!");

        }


    }

    private static Predicate<String> getPredicate(String commandPartTwo, String commandPartThree) {

                switch (commandPartTwo) {
                    case "StartsWith":
                        return name -> name.startsWith(commandPartThree);
                    case "EndsWith":
                        return name -> name.endsWith(commandPartThree);
                    case "Length":
                        return name -> name.length() == Integer.parseInt(commandPartThree);
                }

        return null;
    }
}
