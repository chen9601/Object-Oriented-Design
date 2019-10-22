package com;

/*
인덱스와 이름을 맞춰 넣어주면 맵으로 접근해서 타일을 선택할 수 있게 된다. with values() 메소드
 */
enum TileType {
    SHOP("상점"), // index 0
    HOSPITAL("병원"), // index 1
    MENTAL_HOSPITAL("정신병원"); // index 2

    final private String name;
    private TileType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}