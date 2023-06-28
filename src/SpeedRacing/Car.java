package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private static int startKm = 0;
    private int distanceTraveled;


    public Car(String model,double fuelAmount, double fuelCostFor1Km){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distanceTraveled = startKm;
    }

    public boolean isPossibleToTravel(int distance){
        if(distance * fuelCostFor1Km <= fuelAmount){
            return true;
        }else{
            return false;
        }
    }

    public double setFuelAmount(double fuel){
       return this.fuelAmount -= fuel;
    }

    public int setDistanceTraveled(int distance){
        return  this.distanceTraveled += distance;
    }

    public String getModel(){
        return this.model;
    }

    public double getFuelCostFor1Km() {
        return  this.fuelCostFor1Km;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",model,fuelAmount,distanceTraveled);
    }
}
