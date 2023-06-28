package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;



    public class Box<T extends Comparable<T>> {
        private List<T> list;

        public Box(){
            this.list = new ArrayList<>();
        }

        public void addElement(T element){
            this.list.add(element);
        }

        public  void swapElements(int firstIndex, int secondIndex){
            T temp = this.list.get(firstIndex);
            list.set(firstIndex,list.get(secondIndex));
            list.set(secondIndex,temp);
        }

        public  int getCountGreaterElements(T elementForCompare){
            int count =(int) list.stream().filter(e-> elementForCompare.compareTo(e) < 0).count();
            return count;
        }

        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            for (T t : list) {
                str.append(t.getClass().getName()).append(": ").append(t).append(System.lineSeparator());
            }
            return  str.toString();


        }



    }









