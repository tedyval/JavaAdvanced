package bakery;



import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public void add(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        int count = (int) employees.stream().filter(e -> e.getName().equals(name)).count();
        if (count != 0) {
            employees.removeIf(e -> e.getName().equals(name));
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        if (employees.size() == 0) {
            return null;
        } else {
            Employee max = null;
            int counter = 0;
            for (var employee : employees) {
                counter++;
                if (counter == 1) {
                    max = employee;
                } else if(counter > 1) {
                    assert max != null;
                    if (employee.getAge() > max.getAge()) {
                        max = employee;
                    }
                }
            }
            return max;
        }

    }

    public Employee getEmployee(String name) {
        for (var employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Employees working at Bakery %s:", name)).append("\n");

        if (employees.size() >= 1) {
            employees.forEach(e -> str.append(e.toString()).append("\n"));
        }
        String output = str.toString().trim();
        return output;
    }

}
