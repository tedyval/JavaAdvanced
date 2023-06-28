package SetAndMapLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String,List<Double>> studentGrades = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            if(!studentGrades.containsKey(name)){
                studentGrades.put(name, new ArrayList<>());
            }

            for (int j = 0; j < grades.size(); j++) {
                studentGrades.get(name).add(grades.get(j));
            }

        }



        studentGrades.entrySet().stream().forEach(e-> {
            double average = e.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);

            System.out.println(e.getKey() + " is graduated with " + average);


        });







    }
}
