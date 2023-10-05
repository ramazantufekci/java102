package KitapListesi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("cin ali",10,"milli egitim1",1981));
        books.add(new Book("cin ali2",20,"milli egitim2",1982));
        books.add(new Book("cin ali3",30,"milli egitim3",1983));
        books.add(new Book("cin ali4",40,"milli egitim4",1984));
        books.add(new Book("cin ali5",50,"milli egitim5",1985));
        books.add(new Book("cin ali6",60,"milli egitim6",1986));
        books.add(new Book("cin ali7",70,"milli egitim7",1987));
        books.add(new Book("cin ali8",80,"milli egitim8",1988));
        books.add(new Book("cin ali9",90,"milli egitim9",1989));
        books.add(new Book("cin ali10",110,"milli egitim",1980));

        Map<String,String> map = new HashMap<>();
        books.forEach(book -> map.put(book.getName(),book.getAuthor()));
        map.forEach((name,author)->System.out.println("Book Name: "+name+" Author Name: "+author));
        books.stream().filter(book -> book.getPage()>100).forEach(book -> System.out.println("Book Name: "+book.getName()+" Page: "+book.getPage()));
    }
}
