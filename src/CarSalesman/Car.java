package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine,int weight){
       this(model,engine);
        this.weight = 0;

    }

    public Car(String model, Engine engine,String color){
        this(model,engine);
        this.color = color;

    }

    public Car(String model, Engine engine,int weight,String color){
        this(model,engine);
        this.weight = weight;
        this.color = color;
    }

//
//    {CarModel}:
//    {EngineModel}:
//    Power: {EnginePower}
//    Displacement: {EngineDisplacement}
//    Efficiency: {EngineEfficiency}
//    Weight: {CarWeight}
//    Color: {CarColor}

    @Override
    public String toString() {
        String weightPrint;
        if(weight == 0){
            weightPrint = "n/a";
        }else{
            weightPrint  = weight + "";
        }
        StringBuilder str = new StringBuilder();
        str.append(model).append(":").append("\n");
        str.append(engine.toString()).append("Weight: ").append(weightPrint).append("\n").append("Color: ").append(color);
        return str.toString();
    }
}
