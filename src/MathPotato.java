import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String[] names = scanner.nextLine().split("\\s+");
       int number  = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name : names) {
          queue.offer(name);
        }

        int counter = 0;
        int cycle =  0;
        while(queue.size() > 1){
            counter++;
            if(counter == number){
                cycle++;
            }

            if( counter == number){

                if(cycle == 1 || !isPrime(cycle)){
                    System.out.println("Removed " + queue.poll());
                    counter = 0;
                } else {
                    System.out.println("Prime " + queue.peek());

                    counter = 0;
                }
            }else{
                    queue.offer(queue.poll());

            }

        }

        System.out.println("Last is " + queue.peek());


    }

    public static boolean isPrime(int n){

        for (int i = 2; i <= n/2; i++) {
            if(n % i == 0 & n != i){
                return false;
            }
        }
        return true;
    }
}
