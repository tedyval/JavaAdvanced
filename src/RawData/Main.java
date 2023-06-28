package RawData;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Car> carInfo = new LinkedHashMap<>();
        for (int i = 0; i < n ; i++) {
           String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
           Engine engine = new Engine(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
           Cargo cargo = new Cargo(Integer.parseInt(tokens[3]),tokens[4]);
           Tire tire1 = new Tire(Double.parseDouble(tokens[5]),Integer.parseInt(tokens[6]));
           Tire tire2 = new Tire(Double.parseDouble(tokens[7]),Integer.parseInt(tokens[8]));
           Tire tire3 = new Tire(Double.parseDouble(tokens[9]),Integer.parseInt(tokens[10]));
           Tire tire4 = new Tire(Double.parseDouble(tokens[11]),Integer.parseInt(tokens[12]));

           carInfo.putIfAbsent(model,new Car(model,engine,cargo));
           carInfo.get(model).getTires().add(tire1);
           carInfo.get(model).getTires().add(tire2);
           carInfo.get(model).getTires().add(tire3);
           carInfo.get(model).getTires().add(tire4);
        }

        String input2 = scanner.nextLine();
        List<String> model = new ArrayList<>();
        if(input2.equals("fragile")) {
            for (Map.Entry<String, Car> e : carInfo.entrySet()) {
                if (e.getValue().getCargo().getType().equals("fragile")) {
                    for (Tire tire : e.getValue().getTires()) {
                        if (tire.getPressure() < 1) {
                            model.add(e.getKey());
                            break;
                        }
                    }

                }


            }
        }else if(input2.equals("flamable")){
            carInfo.entrySet().forEach(e-> {
                if (e.getValue().getCargo().getType().equals("flamable") && e.getValue().getEngine().getPower() > 250){
                    model.add(e.getKey());
                }
            });
        }


        if(model.size() > 0) {
            model.forEach(e -> System.out.println(e));
        }

    }
}
