package com;

import lombok.*;
import static com.Validator.isValidForProperty;

@Data
@Builder
public class Player{

    @Builder.Default
    private TileType pos = null;
    @Builder.Default
    private int money=0;

    private int power;
    private int health;
    private int mental;
    private int dexterity;
    private int intelligence;
    private String characteristics;


    public TileType moveTo(TileType here) {
        pos = here;
        return pos;
    }

}
