package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T item){
        T[] arrayToBeCreate = (T[])Array.newInstance(item.getClass(),length);
        for (int i = 0; i < arrayToBeCreate.length; i++) {
            arrayToBeCreate[i] = item;
        }
      return arrayToBeCreate;
    }

    public static <T> T[] create(Class<T>clazz,int length, T item){
        T[] arrayToBeCreate = (T[])Array.newInstance(clazz,length);
        for (int i = 0; i < arrayToBeCreate.length; i++) {
            arrayToBeCreate[i] = item;
        }
        return arrayToBeCreate;
    }

}
