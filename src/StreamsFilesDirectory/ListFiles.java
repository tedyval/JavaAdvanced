package StreamsFilesDirectory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File file = new File(String.valueOf(path));
        File[] files= file.listFiles();
        for (File file1 : files) {
            if(!file1.isDirectory()){
                System.out.println(file1.getName() +": " + "[" + file1.length() + "]");
            }

        }


    }
}
