package practice.OOPS;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book{
    private String title;
    private String author;
    private String isbn;

    Book(String title,String author,String isbn){
        if(title==null || title.trim().isEmpty()){throw new IllegalArgumentException("invalid title");}
        if(author==null || author.trim().isEmpty()){throw new IllegalArgumentException("invalid author");}
        if(isbn==null || isbn.matches("[0-9Xx-]{10,17}")){throw new IllegalArgumentException("invalid ISBN like-Value");}
        this.author=author;
        this.title=title;
        this.isbn=isbn.replaceAll("-","").toUpperCase();
    }
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getISBN(){return isbn;}

    public boolean equals(Object o){
        return (o instanceof Book b) && isbn.equals(b.isbn);
    }
    public int hashCode(){
        return Objects.hash(isbn);
    }
    public String toString(){
        return "title : %s , author : %s and ISBN : %s".formatted(title,author,isbn);
    }

}

public class BookRepresentationInLibrary {
    public static void main(String[] args) {
        Set<Book> books= new HashSet<>();
        books.add(new Book("abc","xyz","asas"));

        books.forEach(System.out::println);
    }
}
