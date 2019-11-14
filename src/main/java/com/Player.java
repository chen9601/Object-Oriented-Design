package com;

import lombok.*;

import java.util.ArrayList;

import static com.Validator.isValidForProperty;

@Data
@Builder
public class Player{

    @Builder.Default
    private TileType pos = null;
    @Builder.Default
    private int money=1000;

    private int power;
    private int health;
    private int mental;
    private int dexterity;
    private int intelligence;
    private String characteristics;
    @Builder.Default
    private ArrayList<Item> items = new ArrayList<>();

    // TODO : 이 메소드를 GameMaster로 옮기는게 한 객체가 하나의 역할만 하는 방법일 것 같다.
    public TileType moveTo(TileType here) {
        pos = here;
        return pos;
    }

    public boolean hasItem(Item item) {
        return true;
    }
}
