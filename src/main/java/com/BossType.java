package com;

public enum BossType {
    AZATHOTH("아자투스",10, 10, 10),
    CHUTHULU("크툴루",10,3,5),
    NYARLATHOTEP("니알라토텝",10,2,6);

    final private String name;
    private int damage;
    private int health;
    private int requireVal;
    BossType(String name, int health, int damage, int requireVal){
        this.name = name;
        this.health=health;
        this.damage=damage;
        this.requireVal=requireVal;
    }
    public String getName(){
        return name;
    }
}
