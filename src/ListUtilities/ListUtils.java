package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils<T extends Comparable<T>>{

    private  List<T> utils;

    public ListUtils(){
        this.utils = new ArrayList<>() ;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
       return  Collections.min(list);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return  Collections.max(list);
    }

}
