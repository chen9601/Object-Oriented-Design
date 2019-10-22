package com;

public final class Map {
    static final Map map = new Map();
    private Tile[] tiles; // tiles의 인덱스 == TileType의 인덱스 : 각 타일 접근성 향상을 위해


    private Map(){

    };

    public Map getInstance(){
        return map;
    }
}
