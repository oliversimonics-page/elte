package java9.printed.material;
public class Book{
    public static final String defaultAuthor = "John Steinbeck";
    public static final String defaultTitle = "Of Mice and Men";
    public static final int defaultPageCount = 107;
    private String author;
    private String title;
    protected int pageCount;
    public Book(String author, String title, int pageCount){
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }
    public Book(){
        this(defaultAuthor, defaultTitle, defaultPageCount);
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public int getPageCount(){
        return pageCount;
    }
    private void checkInitData(String a, String b, int c){

    }
    public String createReference(String a, int b, int c){
        return null;
    }
    public static Book decode(String a){
        return null;
    }
    protected String getAuthorWithInitials(){
        return null;
    }
    public int getPrice(){
        return 0;
    }
    public String getShortInfo(){
        return null;
    }
    protected void initBook(String a, String b, int c){

    }
    @Override public String toString(){
        return null;
    }
}