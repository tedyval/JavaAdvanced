package StreamFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = Files.readAllLines(path);
        Set<String> vowels = Set.of("a","u","e","i","o");
        Set<String> punctuation = Set.of(",",".","!","?");
        AtomicInteger vowelsCount = new AtomicInteger();
        AtomicInteger consonantsCount = new AtomicInteger() ;
        AtomicInteger punctuationsCount = new AtomicInteger();
        for (String line : lines) {
            for (String word : line.split("\\s+")) {
                Arrays.stream(word.split(""))
                        .forEach(symbol -> {
                            if (vowels.contains(symbol)) {
                                vowelsCount.getAndIncrement();
                            } else if (punctuation.contains(symbol)) {
                                punctuationsCount.getAndIncrement();
                            } else if (symbol.charAt(0) == ' ') {

                            } else {
                                consonantsCount.getAndIncrement();
                            }
                        });
            }
        }

//        Vowels: 41
//        Consonants: 72
//        Punctuation: 6
//
        PrintWriter out = new PrintWriter("CountsOfEach.txt");
        out.println("Vowels: " + vowelsCount);
        out.println("Consonants: " + consonantsCount);
        out.println("Punctuation: " + punctuationsCount);
        out.close();

    }
}
