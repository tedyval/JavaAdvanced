package hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int id;
    private int age;
    private List<String> hometown;

    public Person(String name,int id, int age,String... hometown ){
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown == null ? Collections.singletonList("n/a") : new ArrayList<>(Arrays.asList(hometown));
    }





    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s",this.name,this.id,this.age,this.hometown);
    }
}
