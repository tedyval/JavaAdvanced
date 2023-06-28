package cafe;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Cafe {
    private String name;
    private int capacity;
    private Map<String,Employee> employees;

    public Cafe(String name, int capacity){

        this.name = name;
        this.capacity = capacity;
        this.employees = new LinkedHashMap();
    }

    public void addEmployee(Employee employee){
        if(employees.size() < capacity){
            employees.put(employee.getName(),employee);
        }
    }

    public boolean removeEmployee(String name){
        if(employees.containsKey(name)){
            employees.remove(name);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee value = employees.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().getAge())).get().getValue();
        return value;
    }

    public Employee getEmployee(String name){
        if(employees.containsKey(name)) {
            return employees.get(name);
        }else{
            return null;
        }
    }

    public int getCount(){
        return employees.size();
    }

    public String report() {
        StringBuilder ss = new StringBuilder();
        for (var strEmpl : this.employees.entrySet()) {
            ss.append(String.format("Employee: %s, %d from %s",
                    strEmpl.getValue().getName(), strEmpl.getValue().getAge(), strEmpl.getValue().getCountry())).append("\n");
        }
        String mapOut = ss.toString();

        StringBuilder str = new StringBuilder();
        str.append(String.format("Employees working at Cafe %s:",this.name)).append("\n").append(mapOut);
        return str.toString();
    }
}
