package com;

import lombok.*;
import static com.Validator.isValidForProperty;

@Data
@Builder
public class Player{
    private int power;
    private int health;
    private int mental;
    private int dexterity;
    private int intelligence;
    @Builder.Default
    private TileType pos = TileType.A;
    private String characteristics;


    public TileType moveTo(TileType here) {
        pos = here;
        return pos;
    }
}
