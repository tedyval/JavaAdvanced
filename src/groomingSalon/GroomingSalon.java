package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;


    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Pet pet){
        if(this.data.size() < capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        Pet toBeRemoved = null;
        int sizeBeforeRemove = data.size();
        for (Pet pet : data) {
            if(pet.getName().equals(name)){
                toBeRemoved = pet;
            }
        }


        data.remove(toBeRemoved);
        if(sizeBeforeRemove > data.size()){
            return true;
        }
        return false;

    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
              return pet;
            }

        }
        return null;

    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder str = new StringBuilder();
        str.append("The grooming salon has the following clients:").append("\n");
        if(data.size() > 1) {
            for (int i = 0; i <= data.size() - 2; i++) {
                str.append(String.format("%s %s%n", data.get(i).getName(), data.get(i).getOwner()));

            }
            str.append(String.format("%s %s%n", data.get(data.size() -1).getName(), data.get(data.size() -1).getOwner()));
        }else if(data.size() == 1){
            str.append(String.format("%s %s", data.get(0).getName(), data.get(0).getOwner()));
        }else if(data.size() == 0){

        }

        return str.toString();
    }
}
