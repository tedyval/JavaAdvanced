package StreamFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        String input = "C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(input))){
               String line = br.readLine();
               int sum = 0;
               while(line != null){

                   for (int i = 0; i < line.length(); i++) {
                       char symbol = line.charAt(i);
                       sum += symbol;
                   }

                   line = br.readLine();
               }
            System.out.println(sum);

        }catch(IOException e){
            e.printStackTrace();
        }




    }
}
