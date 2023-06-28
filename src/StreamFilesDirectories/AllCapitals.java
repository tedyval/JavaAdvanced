package StreamFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter("allCapitals.txt")) {
            String line = br.readLine();
            while (line != null) {
                String upperCase = line.toUpperCase();
                out.println(upperCase);
                line = br.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }
}
