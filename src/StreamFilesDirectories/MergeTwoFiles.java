package StreamFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path path1 = Path.of("C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt");
        Path path2 = Path.of("C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt");
        List<String> lines1 = Files.readAllLines(path1);
        List<String> lines2 = Files.readAllLines(path2);
        PrintWriter out = new PrintWriter("MergedFile.txt");
        for (String s : lines1) {
            out.println(s);
        }

        for (String s : lines2) {
            out.println(s);
        }

        out.close();


    }
}
