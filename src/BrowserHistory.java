import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentPage = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (!currentPage.equals("Home")) {
            if (currentPage.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                   stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(currentPage);
                System.out.println(stack.peek());
            }


            currentPage = scanner.nextLine();
        }










    }
}
