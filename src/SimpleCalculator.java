import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
       String[] input = scanner.nextLine().split("\\s+");
        for (int i = input.length-1; i >= 0; i--) {
           stack.push(input[i]);
        }

        while(stack.size() > 1){
            int left = Integer.parseInt(stack.pop());
            char operator = stack.pop().charAt(0);
            int right = Integer.parseInt(stack.pop());

           int result =0;
            switch(operator){
                case '-':
                    result = left - right;
                    break;
                case '+':
                    result = left + right;
                    break;
            }

            stack.push(String.valueOf(result));

        }

        System.out.println(stack.peek());








    }
}
