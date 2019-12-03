package com;

public enum BossType {
    AZATHOTH("아자투스",10, 10, 10,"src\\main\\java\\GUI\\imgaes\\boss\\azatoth.png"),
    CHUTHULU("크툴루",10,3,5,"src\\main\\java\\GUI\\imgaes\\boss\\azatoth.png"),
    NYARLATHOTEP("니알라토텝",10,2,6,"src\\main\\java\\GUI\\imgaes\\boss\\NYARLATHOTEP.png");

    final private String name;
    private int damage;
    private int health;
    private int requireVal;
    private String boss_imgpath;
    BossType(String name, int health, int damage, int requireVal,String boss_imgpath){
        this.name = name;
        this.health=health;
        this.damage=damage;
        this.requireVal=requireVal;
        this.boss_imgpath = boss_imgpath;
    }
    public String getName(){
        return name;
    }
    public String getBoss_imgpath(){return boss_imgpath;}
}
