import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if(decimal == 0){
            System.out.println(0);
            return;
        }
        while(decimal > 0){
            int leftPart = decimal % 2;
            stack.push(leftPart);
            decimal /= 2;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }










    }
}
