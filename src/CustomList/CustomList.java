package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }


    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        if(index >= 0 && index < list.size()) {
            return list.remove(index);
        }else{
            throw new IllegalArgumentException("Not such index exist.");
        }

    }

    public boolean contains(T element){
        int count = (int)list.stream().filter(e-> e.compareTo(element) == 0).count();
        if(count == 0){
            return false;
        }
        return true;
    }

    public void swap(int firstIndex,int secondIndex){
        if(firstIndex >=0 && firstIndex < list.size() && secondIndex >= 0 && secondIndex < list.size()) {
            Collections.swap(this.list, firstIndex, secondIndex);
        }else{
            throw new IndexOutOfBoundsException("Not such index.");
        }
    }

    public int countGreaterThan(T element){
        int count = (int)list.stream().filter(e-> e.compareTo(element) > 0).count();
        return count;
    }

    public T getMax(){
        if(list.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }else {
            T max = list.get(0);
            for (T t : list) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
            return max;
        }

    }

    public T getMin(){
        if(list.isEmpty()) {
            throw new IllegalStateException("Empty list.");

        }else {
            T min = list.get(0);
            for (T t : list) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
            return min;
        }


    }

    public int getSize(){
        return list.size();
    }

    public T getElement(int index){
        return list.get(index);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T t : list) {
            str.append(t).append("\n");
        }
        return str.toString();

    }
}
