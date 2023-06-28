package GenericArrayCreator;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

     String[] str = ArrayCreator.create(4,"Stef");


        for (String s : str) {
            System.out.println(s);
        }


    }
}
