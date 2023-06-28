package StreamFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class GetFolderSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Tedy\\OneDrive\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        long sizeOfFolderInBytes = getSize(file);
        System.out.println("Folder size: " + sizeOfFolderInBytes);

    }

    private static long getSize(File file) {
        long sum = 0;
        File[] files = file.listFiles();
        if(files != null){
            for (File file1 : files) {
                if(file1.isDirectory()){
                    getSize(file1);
                }else{
                    long fileSize = file1.length();
                    sum+= fileSize;
                }

            }

        }
        return sum;
    }
}
