package SetAndMapLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> inCarNumbers = new LinkedHashSet<>();
        while(!input.equals("END")){
            String[] inputParts = input.split(", ");
            String inOrOut = inputParts[0];
            String number = inputParts[1];

            if (inOrOut.equals("IN")) {
                inCarNumbers.add(number);
            } else {
                inCarNumbers.remove(number);
            }


            input = scanner.nextLine();
        }

        String output = inCarNumbers.isEmpty() ? "Parking Lot is Empty" : inCarNumbers.stream().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);








    }
}
