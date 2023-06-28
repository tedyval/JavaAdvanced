package CustomList;

public class Sorter<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        for (int i = 0; i < list.getSize(); i++) {
            T element = list.getElement(i);
            for (int j = i+1; j < list.getSize(); j++) {
                T elementNext = list.getElement(j);
                if(element.compareTo(elementNext) > 0){
                    list.swap(i,j);
                }
            }
        }




    }



}
