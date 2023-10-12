package com.drn.Model;

import java.util.ArrayList;

public class Quiz {
    private int id;
    private String soru;
    private ArrayList<String> secenekler;

    public Quiz(int id, String soru, ArrayList<String> secenekler) {
        this.id = id;
        this.soru = soru;
        this.secenekler = secenekler;
    }
    public Quiz(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public ArrayList<String> getSecenekler() {
        return secenekler;
    }

    public void setSecenekler(ArrayList<String> secenekler) {
        this.secenekler = secenekler;
    }

    public static Quiz getFetch(){
        Quiz quiz = new Quiz();
        quiz.setId(1);
        quiz.setSoru("Aşağıdakilerden hangisi yazılım dili değildir.");
        ArrayList<String> secenekler = new ArrayList<>();
        secenekler.add("PHP");
        secenekler.add("C#");
        secenekler.add("Java");
        secenekler.add("Türkçe");
        quiz.setSecenekler(secenekler);
        return quiz;

    }


}
