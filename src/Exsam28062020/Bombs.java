package Exsam28062020;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> effects = new ArrayDeque<>();
        Deque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(effects::offer);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(casings::push);

        Map<String, Integer> types = new TreeMap<>();
        types.put("Datura Bombs", 0);
        types.put("Cherry Bombs", 0);
        types.put("Smoke Decoy Bombs", 0);
        boolean isEnough = false;
        int sum = 0;
        while (!effects.isEmpty() && !casings.isEmpty()) {
            int effect = effects.peek();
            int casing = casings.peek();
            sum = effect + casing;
            switch (sum) {
                case 40:
                    types.put("Datura Bombs", types.get("Datura Bombs") + 1);
                    effects.poll();
                    casings.pop();
                    break;
                case 60:
                    types.put("Cherry Bombs", types.get("Cherry Bombs") + 1);
                    effects.poll();
                    casings.pop();
                    break;
                case 120:
                    types.put("Smoke Decoy Bombs", types.get("Smoke Decoy Bombs") + 1);
                    effects.poll();
                    casings.pop();
                    break;
                default:
                    int elementChanged = casings.pop();

                    while (true) {
                        elementChanged -= 5;
                        sum = effect + elementChanged;
                        if (sum == 40 || sum == 60 || sum == 120) {
                            casings.push(elementChanged);
                          break;
                        }

                    }
                    break;
            }

            int count = (int) types.values().stream().filter(e -> e >= 3).count();
            if (count == types.size()) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                isEnough = true;
                break;
            }
        }




            if (isEnough == false) {
                System.out.println("You don't have enough materials to fill the bomb pouch.");
            }


            if (effects.isEmpty()) {
                System.out.println("Bomb Effects: empty");

            } else {
                System.out.print("Bomb Effects: ");
                int counter = 0;
                StringBuilder str = new StringBuilder();

                for (Integer effect : effects) {
                    counter++;
                    if (counter < effects.size()) {
                        str.append(effect).append(", ");
                    } else if (counter == effects.size()) {
                        str.append(effect);
                    }
                }

                System.out.println(str.toString());
            }


            if (casings.isEmpty()) {
                System.out.println("Bomb Casings: empty");
            } else {
                System.out.print("Bomb Casings: ");
                int counter = 0;
                StringBuilder str = new StringBuilder();

                for (Integer casing : casings) {
                    counter++;
                    if (counter < casings.size()) {
                        str.append(casing).append(", ");
                    } else if (counter == casings.size()) {
                        str.append(casing);
                    }
                }
                System.out.println(str.toString());

            }

            types.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));


        }


    }
