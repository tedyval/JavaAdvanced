package SetAndMapExercise;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String , Map<String, Integer>> users = new TreeMap<>();
        while(!input.equals("end")){
            String[] tokens = input.split(" ");
             String ipAddress = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];
            String message = tokens[1];
            if(!users.containsKey(user)){
                users.put(user, new LinkedHashMap<>());
            }
            if(!users.get(user).containsKey(ipAddress)) {

                users.get(user).put(ipAddress, 1);
            }else{
                int oldValue = users.get(user).get(ipAddress);
                users.get(user).put(ipAddress,oldValue + 1 );
            }




            input = scanner.nextLine();
        }



        for (var user : users.entrySet()) {
            System.out.println(user.getKey() + ":");
            int counter = user.getValue().size();
            for (var ipAddresss : user.getValue().entrySet()) {

                if(counter == 1 ) {
                    System.out.printf("%s => %d.", ipAddresss.getKey(), ipAddresss.getValue());
                }else{

                System.out.printf("%s => %d, ",ipAddresss.getKey(),ipAddresss.getValue());

                }
                counter--;
            }
            System.out.println();


        }


    }
}
