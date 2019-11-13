package com;

enum TileType {
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
    private TileType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

public final class Map {
    static final Map map = new Map();
    private Tile[] tiles; // tiles의 인덱스 == TileType의 인덱스 : 각 타일 접근성 향상을 위해

    private Map(){

    };

    public Map getInstance(){
        return map;
    }
}
