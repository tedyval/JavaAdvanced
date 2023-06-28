package GenericCountMethodString;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {
            double element = Double.parseDouble(scanner.nextLine());
            box.addElement(element);
        }

        double elementForCompare = Double.parseDouble(scanner.nextLine());
        int count = box.getCountGreaterElements(elementForCompare);
        System.out.println(count);



    }
}
