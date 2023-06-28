package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

  public void add(Car car){
       int count = (int) data.stream()
               .filter(c-> c.getManufacturer().equals(car.getManufacturer()) && c.getModel().equals(car.getModel())).count();
       if(capacity > data.size() && count == 0){
           data.add(car);
       }
  }

  public boolean remove(String manufacturer, String model){

       return    data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));

  }

  public Car getLatestCar(){
      Optional<Car> car = data.stream().max(Comparator.comparingInt(Car::getYear));
      return car.orElse(null);
  }

  public  Car getCar(String manufacturer, String model){
      Optional<Car> any = data.stream()
              .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findAny();
      if(any.isPresent()){
          return any.get();
      }else{
          return null;
      }
  }

  public int getCount(){
        return data.size();
  }

  public  String getStatistics(){
    StringBuilder str = new  StringBuilder();
    str.append(String.format("The cars are parked in %s:",this.type)).append("\n");
    if(data.size()> 0) {
        data.forEach(e -> str.append(e).append("\n"));
    }
    return str.toString().trim();

  }





}
