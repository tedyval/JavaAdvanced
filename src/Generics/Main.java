package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            int input =Integer.parseInt(scanner.nextLine());
            box.addElement(input);
        }

        System.out.println(box);



    }
}
