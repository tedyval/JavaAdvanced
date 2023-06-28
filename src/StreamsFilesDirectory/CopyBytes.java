package StreamsFilesDirectory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String path = "C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(FileInputStream inputStream = new FileInputStream(path);
            PrintStream outputStream = new PrintStream("copy-bytes.txt")){
            int oneByte = inputStream.read();
            while(oneByte != -1){
                if(oneByte != 10 && oneByte != 32){
                    outputStream.print(oneByte);
                }else{
                    outputStream.print((char)oneByte);
                }
                oneByte = inputStream.read();
            }

        }catch(IOException e){
            e.printStackTrace();
        }




    }
}
