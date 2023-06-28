package FamilyTree;



import java.util.ArrayList;
import java.util.List;

public class Parent {
    private String firstName;
    private String lastName;
    private String birthday;
    private List<Child> children;

    public Parent(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = null;
        this.children = new ArrayList<>();
    }

    public Parent(String birthday){
        this.birthday = birthday;
        this.firstName = null;
        this.lastName = null;
        this.children = new ArrayList<>();
    }

    public Parent(String firstName, String lastName, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.children = new ArrayList<>();
    }

    public List<Child> getChildren() {
        return children;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
