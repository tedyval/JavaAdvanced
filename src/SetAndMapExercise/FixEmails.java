package SetAndMapExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> emailsByName = new LinkedHashMap<>();
        while(!input.equals("stop")){
         String name = input;
         String email = scanner.nextLine();
         if(!email.endsWith(".uk") && !email.endsWith(".com") && !email.endsWith(".us")){
             emailsByName.put(name,email);
         }

         input = scanner.nextLine();
        }

        emailsByName.entrySet().forEach(e->{
            System.out.printf("%s -> %s%n",e.getKey(),e.getValue());
        });








    }
}
