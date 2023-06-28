package ListyIterator;


import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {
    private List<String> strings;

    public ListyIterator(){

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }
}
