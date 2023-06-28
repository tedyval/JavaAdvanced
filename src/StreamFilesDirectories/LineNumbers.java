package StreamFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\InputLineNumbers.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        PrintWriter out = new PrintWriter("LineNumbers.txt");
        int counter = 1;
        for (String line : lines) {
            out.println(counter + ". " + line);
            counter++;
        }

       out.close();
    }
}
