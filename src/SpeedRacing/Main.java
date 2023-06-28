package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int n = Integer.parseInt(scanner.nextLine());
      Map<String,Car> carInfo = new LinkedHashMap<>();
      Car car;
        for (int i = 0; i < n; i++) {
              String input = scanner.nextLine();
              String[] tokens = input.split("\\s+");
              String model = tokens[0];
              double fuelAmount = Double.parseDouble(tokens[1]);
              double fuelCostFor1Km = Double.parseDouble(tokens[2]);
              car = new Car(model,fuelAmount,fuelCostFor1Km);
              carInfo.put(model,car);
        }

        String input2 = scanner.nextLine();
        while(!input2.equals("End")){
          String[] partitions = input2.split("\\s+");
          String model = partitions[1];
          int amountKm = Integer.parseInt(partitions[2]);
          if(carInfo.get(model).isPossibleToTravel(amountKm)){
            carInfo.get(model).setDistanceTraveled(amountKm);
            double consumedFuel = amountKm * carInfo.get(model).getFuelCostFor1Km();

            carInfo.get(model).setFuelAmount(consumedFuel);
          }else{
              System.out.println("Insufficient fuel for the drive");
          }
          input2 = scanner.nextLine();
        }

       carInfo.values().forEach(e-> System.out.println(e.toString()));






    }
}
