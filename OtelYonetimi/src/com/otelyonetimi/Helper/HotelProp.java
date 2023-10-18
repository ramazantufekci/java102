package com.otelyonetimi.Helper;

import java.util.ArrayList;

public class HotelProp {
    private String prop;
    public static ArrayList<String> HotelProp(){
        ArrayList<String> hotelProp = new ArrayList<>();
        hotelProp.add("Ücretsiz Otopark");
        hotelProp.add("Ücretsiz WiFi");
        hotelProp.add("Yüzme Havuzu");
        hotelProp.add("Fitness Center");
        hotelProp.add("Hotel Concierge");
        hotelProp.add("SPA");
        hotelProp.add("7/24 Oda Servisi");
        return hotelProp;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}