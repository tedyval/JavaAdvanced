package vetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void  add(Pet pet){
        if(capacity > data.size()){
            int count = (int )data.stream().filter(e-> e.getName().equals(pet.getName()) && e.getOwner().equals(pet.getOwner())).count();
            if(count == 0){
                data.add(pet);
            }
        }
    }

    public boolean remove(String name){

            Optional<Pet> any = data.stream().filter(e -> e.getName().equals(name)).findAny();
            if(any.isPresent()){
                data.remove(any.get());
                return  true;
            }else{
                return false;
            }

    }

    public Pet getPet(String name, String owner){
        Optional<Pet> any =  data.stream().filter(e -> e.getName().equals(name) && e.getOwner().equals(owner)).findAny();
        return any.orElse(null);
    }

    public Pet getOldestPet(){
        if(data.size() > 0) {
            Pet max = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i).getAge() > max.getAge()) {
                    max = data.get(i);
                }
            }
            return max;
        }else{
            return null;
        }
    }

    public int  getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder str = new StringBuilder();
        str.append("The clinic has the following patients:").append("\n");
        if(data.size() > 0) {
            data.forEach(e -> str.append(e.getName()).append(" ").append(e.getOwner()).append("\n"));
        }
        return str.toString().trim();
    }






}
