package FunctinalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatCalculator = p -> p * 1.2;
        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).map(vatCalculator).forEach(p->{

            System.out.printf("%.2f%n",p);
        });








    }
}
