import java.util.Comparator;

public class Book implements Comparable<Book> {
    @Override
    public int compareTo(Book o1) {
        return this.name.compareTo(o1.name);
    }
    private String name;
    private String authorName;
    private String releaseDate;
    private int pageumber;

    public Book(String name, String authorName, String releaseDate, int pageumber){
        this.name = name;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.pageumber = pageumber;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPageumber() {
        return pageumber;
    }

    public void setPageumber(int pageumber) {
        this.pageumber = pageumber;
    }

    public String toString(){
        return "Name: "+name+"\nAuthor: "+authorName+"\nRelease Date: "+releaseDate+"\n Page: "+pageumber;
    }
}
