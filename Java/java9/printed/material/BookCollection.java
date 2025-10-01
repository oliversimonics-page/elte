package java9.printed.material;
import java.util.ArrayList;

public class BookCollection{
    private ArrayList<Book> books;
    public BookCollection(){
        books = new ArrayList<>();
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public void add(Book [] books){
        
    }
    public static BookCollection load(String filename){
        return null;
    }
    public boolean save(String filename){
        return false;
    }
}