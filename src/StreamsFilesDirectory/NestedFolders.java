package StreamsFilesDirectory;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {

        File file = new File("C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Deque<File> queue = new ArrayDeque<>();
        int counter = 1;
        queue.offer(file);
        System.out.println(file.getName());
        while(!queue.isEmpty()){
            File current = queue.poll();

            File[] files = current.listFiles();
            if(files != null){
                for (File file1 : files) {
                    if(file1.isDirectory()){
                        queue.offer(file1);
                        counter++;
                        System.out.println(file1.getName());
                    }
                }

            }

        }

        System.out.println(counter + " folders");




    }
}
