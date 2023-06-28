package StreamsFilesDirectory;

import MultidimensionalArrayLab.PrintDiagonals;

import java.io.*;

public class EveryThirdLine {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tedy\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\input.txt"));
             PrintWriter out = new PrintWriter("ThirdLines.txt")) {
            String line = br.readLine();
            int counter = 1;
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = br.readLine();

            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
