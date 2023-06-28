package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
//        Collections.addAll(integers,1,2,18,2,-1);
        Integer max = ListUtils.getMax(integers);
        Integer min = ListUtils.getMin(integers);

        System.out.println(min);

    }
}
