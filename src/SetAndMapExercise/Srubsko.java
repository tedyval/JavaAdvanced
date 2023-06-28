package SetAndMapExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Srubsko {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String input = br.readLine();

        while(!input.equals("End")){
            List<String> tokens = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            int price = Integer.parseInt(tokens.get(tokens.size() - 2));
            int countTickets = Integer.parseInt(tokens.get(tokens.size() - 1));
            if(price < 0 || price >200 || countTickets < 0 || countTickets > 100000){
                br.readLine();
                continue;
            }

            tokens.remove(tokens.size() - 1);
            tokens.remove(tokens.size() - 2);
            StringBuilder str = new StringBuilder(String.join(" ",tokens));
            int indexOfAt = str.indexOf("@");
            String subStr = str.substring(0,indexOfAt + 1);
            String[] nameParts = subStr.split(" ");
            int numOfParts = 0;
            if(nameParts.length > 3){
                br.readLine();
                continue;
            }else{
               numOfParts = nameParts.length;
               switch(numOfParts){
                   case 1:
                       String name1 = nameParts[0];
                       break;
                   case 2:
                       name1 = nameParts[0];
                       String name2 = nameParts[1];
                       break;
                   case 3:
                   name1 = nameParts[0];
                   name2 = nameParts[1];
                   String name3 = nameParts[2];
                   break;
               }
            }
            String afterAt = str.substring(indexOfAt, str.length());
            String[] partsOfVanue = afterAt.split(" ");
            if(partsOfVanue.length > 2){
                br.readLine();
                continue;
            }













            input = br.readLine();
        }










    }
}
