package CarSalesman;


public class Engine {
    private String modelEngine;
    private int power;

    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.modelEngine = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String  efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }



        @Override
    public String toString() {
        String displacementPrint;
        if(displacement == 0){
            displacementPrint = "n/a";
        }else{
            displacementPrint = displacement + "";
        }

        StringBuilder str = new StringBuilder();
        str.append(modelEngine).append(":").append("\n");
        str.append("Power: ").append(power).append("\n");
        str.append("Displacement: ").append(displacementPrint).append("\n");
        str.append("Efficiency: ").append(efficiency).append("\n");

        return str.toString();
    }
}
