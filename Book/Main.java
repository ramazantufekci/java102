import java.util.*;

public class Main {
    public static void main(String[] args) {
      TreeSet<Book> books = new TreeSet<>();
      books.add(new Book("Tarık bin Ziyad","Ebubekir","1845",365));
      books.add(new Book("Beyaz Melek","Tarık","1945",54));
      books.add(new Book("Cin Ali","Milli Eğitim","1881",24));
      books.add(new Book("Üç Tepe","Cihat","1965",211));
      books.add(new Book("Halicin Boynuzları","Fatih","1453",1000));
      Iterator<Book> itr = books.descendingIterator();
      while (itr.hasNext()){
          System.out.println(itr.next());
      }

        TreeSet<Book> books2 = new TreeSet<>(new PageNumberComparator());

        books2.add(new Book("Tarık bin Ziyad","Ebubekir","1845",365));
        books2.add(new Book("Beyaz Melek","Tarık","1945",54));
        books2.add(new Book("Cin Ali","Milli Eğitim","1881",24));
        books2.add(new Book("Üç Tepe","Cihat","1965",211));
        books2.add(new Book("Halicin Boynuzları","Fatih","1453",1000));

        for (Book book : books2) {
            System.out.println(book.toString());
        }
    }
}
