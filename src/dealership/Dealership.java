package dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        int count = (int) data.stream().filter(c -> c.getManufacturer()
                .equals(car.getManufacturer()) && c.getModel().equals(car.getModel())).count();
        if (count == 0 && capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        int sizeBefore = data.size();
        boolean b = data.removeIf(c -> c.getManufacturer()
                .equals(manufacturer) && c.getModel().equals(model));
        return b;
    }

    public Car getLatestCar(){
        Optional<Car> max = data.stream().max((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear()));
          if(max.isPresent()){
              return max.get();
          }else{
              return null;
          }

    }

    public Car getCar(String manufacturer, String model){
        Optional<Car> car = data.stream().filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findAny();
        if(car.isPresent()){
            return car.get();
        }else{
            return null;
        }


    }

    public int getCount(){
        return data.size();
    }


    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        str.append(String.format(" The cars are in a car dealership %s:%n",name));
        for (Car car : data) {
            str.append(car.toString()).append("\n");
        }

        return str.toString().trim();
    }
}
