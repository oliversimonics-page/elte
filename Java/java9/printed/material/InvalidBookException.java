package java9.printed.material;
public class InvalidBookException extends Exception{
    private String author;
    private String title;
    public InvalidBookException(String author, String title){
        this.title = title;
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
}