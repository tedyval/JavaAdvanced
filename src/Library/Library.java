package Library;

import Library.Book.Book;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books){
        this.books = books;
    }




    @Override
    public Iterator<Book> iterator() {
        return new Libliterator(books);
    }

    public static class Libliterator implements Iterator<Book>{
        int nextIndex;
        Book[] books;

        public Libliterator(Book[] books){
            this.nextIndex = 0;
            this.books = books;
        }


        @Override
        public boolean hasNext() {
            return nextIndex < books.length;
        }

        @Override
        public Book next() {
            Book toBeReturn = books[nextIndex];
            this.nextIndex = nextIndex + 1;
            return toBeReturn;
        }
    }
}
