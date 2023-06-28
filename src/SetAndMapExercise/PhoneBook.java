package SetAndMapExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        while(!input.equals("search")){

             String[] tokens = input.split("-");
             String name = tokens[0];
             String number = tokens[1];
             phonebook.put(name,number);

         input = scanner.nextLine();
        }

        String searchedName = scanner.nextLine();
        while(!searchedName.equals("stop")){
            if(phonebook.containsKey(searchedName)){
                System.out.printf("%s -> %s%n",searchedName,phonebook.get(searchedName));
            }else{
                System.out.printf("Contact %s does not exist.%n",searchedName);
            }

            searchedName = scanner.nextLine();
        }





    }
}
