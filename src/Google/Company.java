package Google;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName,String department,double salary){
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(companyName).append(" ").append(department).append(" ").append(String.format("%.2f",salary)).append("\n");
        return  str.toString();
    }
}
