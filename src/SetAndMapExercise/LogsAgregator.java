package SetAndMapExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LogsAgregator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Set<String>> users = new TreeMap<>();
        Map<String, Integer> totalDuration = new LinkedHashMap<>();
        for (int i = 0; i < n; i++ ) {
            String input = br.readLine();
            String[] tokens = input.split(" ");
            String ipAddress = tokens[0];
            String user = tokens[1];
            int sessionDuration = Integer.parseInt(tokens[2]);
            totalDuration.putIfAbsent(user,0);
            totalDuration.put(user, totalDuration.get(user) + sessionDuration);

            users.putIfAbsent(user,new TreeSet<>());
            users.get(user).add(ipAddress);

        }

//
        users.entrySet().stream().forEach(e-> {
            String outputFromSet = String.join(", ",e.getValue());
            System.out.printf("%s: %d [%s]%n",e.getKey(),totalDuration.get(e.getKey()),outputFromSet);
        });

        br.close();







    }
}





