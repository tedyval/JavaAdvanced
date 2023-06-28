package Generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }

    public void addElement(T element){
        this.elements.add(element);
    }



    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T element : elements) {
            str.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator());
        }
        return str.toString();


    }
}
