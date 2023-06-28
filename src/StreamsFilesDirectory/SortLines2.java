package StreamsFilesDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines2 {
    public static void main(String[] args) throws IOException {
        Path inPath = Paths.get("C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\input.txt");
        Path outPath = Paths.get("sorted2.txt");
        List<String> sortedLines = Files.readAllLines(inPath);
        Collections.sort(sortedLines);
        Files.write(outPath,sortedLines);






    }


}
