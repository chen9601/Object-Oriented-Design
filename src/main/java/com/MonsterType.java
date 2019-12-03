package com;

import javax.swing.*;

public enum MonsterType {
    Nightgaunt("나이트건트", 3, 3, 1, 1, 3,"src\\main\\java\\GUI\\imgaes\\monster\\nightgaunt2.png"),
    Dagon("다곤", 1, 4, 2, 2, 5,"src\\main\\java\\GUI\\imgaes\\monster\\dagon2.png"),
    Byakhee("비야키", 2, 2, 1, 1, 1,"src\\main\\java\\GUI\\imgaes\\monster\\BYAKEE2.png"),
    Ghoul("구울", 4, 4, 2, 1, 4,"src\\main\\java\\GUI\\imgaes\\monster\\ghoul2.png"),
    Elder_Thing("옛 것", 5, 4, 1, 2, 5,"src\\main\\java\\GUI\\imgaes\\monster\\elder_thing.png");

    private String name;
    private int initial_health;
    private int initial_requireVal;
    private int initial_damage;
    private int initial_damageType;
    private int initial_monster_result;
    private String inintial_imgpath;

    MonsterType(String name, int health, int requireVal, int damage, int damageType, int monster_result,String imagepath) {
        this.name = name;
        this.initial_health = health;
        this.initial_requireVal = requireVal;
        this.initial_damage = damage;
        this.initial_damageType = damageType;
        this.initial_monster_result = monster_result;
        this.inintial_imgpath = imagepath;
    }


    public String getName() {
        return name;
    }

    public int getInitial_health() {
        return initial_health;
    }

    public int getInitial_requireVal() {
        return initial_requireVal;
    }

    public int getInitial_damage() {
        return initial_damage;
    }

    public int getInitial_damageType() {
        return initial_damageType;
    }

    public int getInitial_monster_result() {
        return initial_monster_result;
    }
    public String getInintial_imgpath(){return inintial_imgpath;}
}
