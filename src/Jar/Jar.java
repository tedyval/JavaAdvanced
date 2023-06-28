package Jar;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Jar<T> {
    private Deque<T> listOfItems;

    public Jar(){
        listOfItems = new ArrayDeque<>();
    }

    public void add(T element){
        this.listOfItems.push(element);
    }

    public T remove(){
       return this.listOfItems.pop();
    }


}
