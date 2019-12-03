package com;

public enum BossType {
    AZATHOTH("아자투스",10, 10, 10,"src\\main\\java\\GUI\\imgaes\\boss\\azatoth.png", "src\\main\\java\\GUI\\imgaes\\boss\\azatoth.png"),
    CHUTHULU("크툴루",10,3,1,"src\\main\\java\\GUI\\imgaes\\boss\\CHUTHULU.png", "src\\main\\java\\GUI\\imgaes\\boss\\cthulhu.gif"),
    NYARLATHOTEP("니알라토텝",10,2,1,"src\\main\\java\\GUI\\imgaes\\boss\\NYARLATHOTEP.png","src\\main\\java\\GUI\\imgaes\\boss\\nyala.gif");

    final private String name;
    private int damage;
    private int health;
    private int requireVal;
    private String boss_imgpath;
    private String active_imgpath;
    BossType(String name, int health, int damage, int requireVal,String boss_imgpath, String imgpath2){
        this.name = name;
        this.health=health;
        this.damage=damage;
        this.requireVal=requireVal;
        this.boss_imgpath = boss_imgpath;
        this.active_imgpath=imgpath2;
    }
    public String getName(){
        return name;
    }
    public String getBoss_imgpath(){return boss_imgpath;}
    public String getActive_imgpath(){return active_imgpath;}
}
