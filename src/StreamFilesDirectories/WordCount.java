package StreamFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        List<String> lines = Files.readAllLines(path);
        String[] words = lines.get(0).split("\\s+");
        Map<String, Integer> repetition = new HashMap<>();
        Path path1 = Path.of("C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> linesInText = Files.readAllLines(path1);
        for (String s : linesInText) {
            String[] wordsInLine = s.split("\\s+");
            for (String s1 : wordsInLine) {
                String wordWithoutComma = s1.replaceAll(",","");
                for (int i = 0; i < words.length; i++) {
                    if(words[i].equals(s1)){
                      repetition.putIfAbsent(words[i],0);
                      repetition.put(words[i],repetition.get(words[i]) + 1);
                      break;
                    }
                }


            }


        }

        PrintWriter out = new PrintWriter("WordCount.txt");
        repetition.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e-> {
            out.println(e.getKey() + " - " + e.getValue());
        });

        out.close();
    }
}
