package StreamsFilesDirectory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\input.txt"));
            PrintWriter out = new PrintWriter("Sort.txt")){
            List<String> sortedLines = new ArrayList<>();
            String line = br.readLine();
            while(line != null){
                sortedLines.add(line);
                line = br.readLine();
            }
            Collections.sort(sortedLines);
            for (String sortedLine : sortedLines) {
                out.println(sortedLine);
            }

        }catch(IOException e){
            e.printStackTrace();
        }






















    }
}
