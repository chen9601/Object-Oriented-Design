package com;

public enum TileType {
    HOSPITAL("병원"),
    MENTAL_HOSTPITAL("정신병원"),
    STORE("상점"),
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J");

    final private String name;
    TileType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}