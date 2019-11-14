package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    public static Player player;

    @BeforeAll
    public static void makeInstance(){
        player = Player
                .builder()
                .power(10)
                .dexterity(20)
                .health(30)
                .intelligence(40)
                .mental(50)
                .characteristics("test")
                .build();
    }

    @Test
    void test_getItems(){
        assertEquals(player.getItems(), new ArrayList<Item>());
    }

}