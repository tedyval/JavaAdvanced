package StreamsFilesDirectory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\input.txt";
        try(FileInputStream inputStream = new FileInputStream(path);){
            int readByte = inputStream.read();
            while(readByte != -1){
                System.out.print(Integer.toBinaryString(readByte) + " ");

                readByte = inputStream.read();
            }


        }catch(IOException e){
         e.printStackTrace();
        }


    }
}
