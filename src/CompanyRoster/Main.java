package CompanyRoster;



import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
           String[] tokens = scanner.nextLine().split("\\s+");
           String name = tokens[0];
           double salary = Double.parseDouble(tokens[1]);
           String position = tokens[2];
           String department = tokens[3];
           departments.putIfAbsent(department,new Department(department));
           Employee employee;
           if(tokens.length == 6){
               String email = tokens[4];
               int age = Integer.parseInt(tokens[5]);
               employee = new Employee(name,salary,position,department,email,age);
               departments.get(department).setEmployees(employee);
           }else if(tokens.length == 5){
               if(tokens[4].contains("@")){
                   String email = tokens[4];
                   employee = new Employee(name,salary,position,department,email);
                   departments.get(department).setEmployees(employee);
               }else{
                   int age = Integer.parseInt(tokens[4]);
                   employee = new Employee(name,salary,position,department,age);
                   departments.get(department).setEmployees(employee);
               }
           }else if(tokens.length == 4){
               employee = new Employee(name,salary,position,department);
               departments.get(department).setEmployees(employee);
           }

        }

        Department maxAverageSalaryDepartment = departments.entrySet().stream().max(Comparator.comparingDouble(entry-> entry.getValue().getAverageSalary())).get().getValue();
        System.out.printf("Highest Average Salary: %s%n",maxAverageSalaryDepartment.getName());

        maxAverageSalaryDepartment.getEmployees().stream().sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary())).forEach(System.out::print);



    }
}
