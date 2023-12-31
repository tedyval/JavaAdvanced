package BookComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public void setTitle(String name){
        this.title = name;
    }

    public void setYear(int year){
        this.year = year;
    }

    public  String getTitle(){
        return this.title;
    }

    public  int getYear(){
        return this.year;
    }

    public List<String> getAuthors(){
        return this.authors;
    }


}
