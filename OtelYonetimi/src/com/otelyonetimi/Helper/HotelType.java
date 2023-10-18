package com.otelyonetimi.Helper;

public enum HotelType {
    UHD("Ultra Herşey Dahil"),
    HD("Herşey Dahil"),
    OK("Oda Kahvaltı"),
    TP("Tam Pansiyon"),
    YP("Yarım Pansiyon"),
    SY("Sadece Yatak"),
    AHF("Alkol Hariç Full credit");

    private String type;

    HotelType(String s) {
        this.type = s;
    }

    public String getType(){
        return this.type;
    }
}
