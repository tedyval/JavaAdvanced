import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < names.length ; i++) {
        queue.offer(names[i]);
        }

        int counter = 0;
        while(queue.size() > 1) {
            counter++;

            if(counter == number){
                System.out.println("Removed " + queue.poll());
                counter = 0;
            }else{
                queue.offer(queue.poll());
            }

        }

        System.out.println("Last is " + queue.peek());


    }
}
