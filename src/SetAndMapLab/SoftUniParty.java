package SetAndMapLab;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeSet<String> guestsInList = new TreeSet<>();
        while(!input.equals("PARTY")){
            guestsInList.add(input);
            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while(!input2.equals("END")){
            guestsInList.remove(input2);
            input2 = scanner.nextLine();
        }

        System.out.println(guestsInList.size());
        for (String s : guestsInList) {
            System.out.println(s);
        }


    }
}
