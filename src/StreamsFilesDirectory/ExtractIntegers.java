package StreamsFilesDirectory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\input.txt");
            PrintStream out = new PrintStream("ExtractedIntegers.txt")){
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    int foundInt = scanner.nextInt();
                    out.println(foundInt);
                }
                scanner.next();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
