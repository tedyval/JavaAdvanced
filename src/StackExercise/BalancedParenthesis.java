package StackExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if(symbol == '(' || symbol == '{' || symbol == '['){
                stack.push(symbol);
            }else if(symbol == ')' || symbol == '}' || symbol == ']'){
                queue.offer(symbol);
            }
        }

        boolean isBalanced = false;
        if(stack.size() != queue.size()){
            System.out.println("NO");
        }else {
            for (int i = 0; i < stack.size(); i++) {
                char openParenthes = stack.pop();
                char closeParenthes = queue.poll();
                if(openParenthes =='(' && closeParenthes == ')'){
                    isBalanced = true;
                }else if(openParenthes =='[' && closeParenthes == ']'){
                    isBalanced = true;
                }else if(openParenthes =='{' && closeParenthes == '}'){
                    isBalanced = true;
                }
            }
            if(isBalanced == true){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }










    }
}
