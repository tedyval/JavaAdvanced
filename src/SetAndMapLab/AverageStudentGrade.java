package SetAndMapLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AverageStudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsGrade = new TreeMap<>();
        int num  = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String input2 = scanner.nextLine();

            String[] tokens = input2.split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            if(!studentsGrade.containsKey(name)) {
                studentsGrade.put(name, new ArrayList<>());

            }
            studentsGrade.get(name).add(grade);
        }

        studentsGrade.entrySet().forEach(e-> {
            String list = e.getValue().stream().map(s -> String.format("%.2f",s)).map(String::valueOf).collect(Collectors.joining(" "));
            double average = e.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
            System.out.printf("%s -> %s (avg: %.2f)%n",e.getKey(),list,average);
        });









    }
}
