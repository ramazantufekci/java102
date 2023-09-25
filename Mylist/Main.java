public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Dizideki Eleman Sayısı : "+liste.size());
        System.out.println("Dizinin Kapasitesi : "+liste.getCapacity());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı :"+liste.size());
        System.out.println("Dizinin Kapasitesi : "+liste.getCapacity());
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : "+liste.size());
        System.out.println("Dizinin Kapasitesi : "+liste.getCapacity());
        System.out.println(liste.get(-1));
        System.out.println(liste.remove(-1));
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(2);
        liste.set(0, 100);
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.toString();
        System.out.println("En son "+liste.lastIndexOf(1001));
        System.out.println(liste.toArray());
        //liste.clear();
        System.out.println(liste.toString());
        MyList<Integer> altListem = liste.sublist(3,6);
        System.out.println(altListem.toString());

    }
}
