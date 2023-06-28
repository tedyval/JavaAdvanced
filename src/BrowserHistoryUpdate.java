import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stackBack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stackBack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stackBack.peek());
                    stackBack.pop();
                    System.out.println(stackBack.peek());

                }
            } else if (input.equals("forward")) {
                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currentURL = stackForward.pop();
                    stackBack.push(currentURL);
                    System.out.println(currentURL);
                }

            } else {
                System.out.println(input);
                stackBack.push(input);
                stackForward.clear();
            }

            input = scanner.nextLine();
        }


    }
}
