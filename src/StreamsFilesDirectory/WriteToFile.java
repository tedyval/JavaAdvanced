package StreamsFilesDirectory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\input.txt";

       try(FileInputStream inputStream = new FileInputStream(path);
           FileOutputStream outputStream = new FileOutputStream ("output.txt")){
           Set<Character> punctuation = Set.of(',','.','?','!');
            int oneByte = inputStream.read();
            while(oneByte != -1){
             char symbol = (char) oneByte;
             if(!punctuation.contains(symbol)){
                 System.out.print(symbol);
             }
                oneByte = inputStream.read();
            }


       }catch (IOException e){
           e.printStackTrace();
       }







    }
}
