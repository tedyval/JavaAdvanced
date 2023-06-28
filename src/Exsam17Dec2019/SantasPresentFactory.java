package Exsam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        String[] num = scanner.nextLine().split(" ");
        for (int i = 0; i < num.length; i++) {
            materials.push(Integer.parseInt(num[i]));
        }
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(magicLevel::offer);
        Map<String, Integer> toys = new TreeMap<>();
        toys.put("Doll", 0);
        toys.put("Wooden train", 0);
        toys.put("Teddy bear", 0);
        toys.put("Bicycle", 0);


        int presents = 0;
        boolean isMade = false;
        boolean isMaded = false;
        while (!materials.isEmpty() && !magicLevel.isEmpty()) {
            int materiall = materials.peek();
            int magic = magicLevel.peek();
            int result = materiall * magic;
            if (result == 150 || result == 250 || result == 300 || result == 400) {
                switch (result) {
                    case 150:
                        toys.put("Doll", toys.get("Doll") + 1);
                        break;
                    case 250:
                        toys.put("Wooden train", toys.get("Wooden train") + 1);
                        break;
                    case 300:
                        toys.put("Teddy bear", toys.get("Teddy bear") + 1);
                        break;
                    case 400:
                        toys.put("Bicycle", toys.get("Bicycle") + 1);
                        break;

                }

                presents++;
                materials.pop();
                magicLevel.poll();
                if (toys.get("Doll") >= 1 && toys.get("Wooden train") >= 1) {
                    isMade = true;
                } else if (toys.get("Teddy bear") >= 1 && toys.get("Bicycle") >= 1) {
                    isMaded = true;
                }

            } else {
                if (result > 0) {
                    magicLevel.poll();
                    int changed = materials.pop() + 15;
                    materials.push(changed);

                } else if (result < 0) {
                    int sum = materiall + magic;
                    materials.pop();
                    magicLevel.poll();
                    materials.push(sum);
                } else if (result == 0) {
                    if(materiall == 0){
                        materials.pop();
                    }else if(magic == 0){
                        magicLevel.poll();
                    }else{
                        materials.pop();
                        magicLevel.poll();
                    }


                }
            }



        }

        if (isMade || isMaded) {
            System.out.println("The presents are crafted! Merry Christmas!");
            if(isMade && isMaded){
                System.out.println("The presents are crafted! Merry Christmas!");
            }

        } else{
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            StringBuilder str = new StringBuilder();
            str.append("Materials left: ");

            String collect = materials.stream().map(String::valueOf).collect(Collectors.joining(", "));
            str.append(collect);
            System.out.println(str.toString());

        }

        if (!magicLevel.isEmpty()) {
            StringBuilder str = new StringBuilder();
            str.append("Magic left: ");

            String collect = magicLevel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            str.append(collect);
            System.out.println(str.toString());

        }

       toys.entrySet().stream().filter(e -> e.getValue() >= 1).forEach(e-> System.out.println(e.getKey() + ": " + e.getValue()));


    }
}
