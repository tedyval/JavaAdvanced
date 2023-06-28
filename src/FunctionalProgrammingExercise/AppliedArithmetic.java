package FunctionalProgrammingExercise;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        String modifiedList = "";
        Consumer<String> print = str -> System.out.println(str);
        while(!command.equals("end")){
            modifiedList = getFunction(numbers,command);
            numbers = Arrays.stream(modifiedList.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            if(command.equals("print")){
                print.accept(modifiedList);
            }

            command = scanner.nextLine();
        }






    }

    private static String getFunction(List<Integer> numbers, String command) {
        String output = "";
        switch(command){
            case "add":
                output = numbers.stream().map(n-> n + 1).map(String::valueOf).collect(Collectors.joining(" "));
                break;
            case "multiply":
                output = (String) numbers.stream().map(n-> n * 2).map(String::valueOf).collect(Collectors.joining(" "));
                break;
            case "subtract":
                output = numbers.stream().map(n-> n - 1).map(String::valueOf).collect(Collectors.joining(" "));
                break;
            case "print":
                output = numbers.stream().map(String::valueOf).collect(Collectors.joining(" "));
                break;


        }
        return output;
    }
}
