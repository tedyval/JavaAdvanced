package RawData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;
    private  static int numberOfTires = 4;

    public Car(String model, Engine engine, Cargo cargo){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new LinkedList<>();
    }



    public  Cargo getCargo(){
        return  this.cargo;
    }


    public  List<Tire> getTires() {
        return this.tires;
    }


    public Engine getEngine() {
        return this.engine;
    }
}
