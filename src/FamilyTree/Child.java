package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Child {

    private String firstName;
    private String lastName;
    private String birthday;
    private List<Parent> parents;

    public Child(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = null;
        this.parents = new ArrayList<>();
    }

    public Child(String birthday){
        this.birthday = birthday;
        this.firstName = null;
        this.lastName = null;
        this.parents = new ArrayList<>();
    }

    public List<Parent> getParents() {
        return parents;
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
}
