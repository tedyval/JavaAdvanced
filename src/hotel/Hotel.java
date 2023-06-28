package hotel;

import java.util.*;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity){
        this.name = name;
        this.capacity =capacity;
        this.roster = new ArrayList<>();
    }


    public void add(Person person){
        if(capacity > roster.size()){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        for (var entry : roster) {
            if(entry.getName().equals(name)){
                roster.remove(entry);
                return true;
            }
        }
        return false;

    }

    public Person getPerson(String name, String hometown){
        for (var entry : roster) {
            if(entry.getName().equals(name) && entry.getHometown().equals(hometown)){

                return entry;
            }
        }
        return null;
    }

    public int getCount(){
       return roster.size();
    }

    public String getStatistics(){
       StringBuilder str = new StringBuilder();
        str.append(String.format("The people in the hotel %s are:",name)).append("\n");
       if(roster.size() > 0){

           roster.forEach(p -> str.append(p.toString()).append("\n"));
       }

      return str.toString().trim();


    }
}
